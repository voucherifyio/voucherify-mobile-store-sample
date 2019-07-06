package io.voucherify.android.sample.store.ui.dashboard.admin.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class SettingsAdminViewModel(
    private val userService: UserService,
    private val customersService: CustomersService
) : BaseViewModel() {

    sealed class ViewCommand {
        data class UserChangePicker(val customers: List<CustomerResponse>) : ViewCommand()
        class Logout: ViewCommand()
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

    private val currentUserLiveData = MutableLiveData<LocalUser>()
    private val viewCommandsPublisher = ReplaySubject.create<ViewCommand>()


    init {
        currentUserLiveData.value = userService.getCurrentUser()
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun logout() {
        userService.removeCurrentUser()
//        currentUserLiveData.value = userService.getCurrentUser()

        viewCommandsPublisher.onNext(
            ViewCommand.Logout()
        )
    }

    fun switchUser() {

        compositeDisposable.add(
            customersService
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ data ->
                    isLoadingLiveData.postValue(false)
                    viewCommandsPublisher.onNext(
                        ViewCommand.UserChangePicker(data.customers)
                    )
                }, { error ->
                    isLoadingLiveData.postValue(false)
                })
        )
    }

    fun outputViewCommand(): Observable<ViewCommand> {
        return viewCommandsPublisher
    }

    fun outputLocalUser(): LiveData<LocalUser> {
        return currentUserLiveData
    }

}