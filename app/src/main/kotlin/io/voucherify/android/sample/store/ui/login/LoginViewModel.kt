package io.voucherify.android.sample.store.ui.login

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.ReplaySubject
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.service.login.LoginService
import io.voucherify.android.sample.store.ui.base.BaseViewModel


class LoginViewModel(private val loginService: LoginService,
                     private val resources: Resources) : BaseViewModel() {

    sealed class ViewCommand {
        class ForgotPassword(val intent: Intent) : ViewCommand()
    }

    private val responseLiveData = MutableLiveData<DataResult<LocalUser>>()
    private val isLoadingLiveData = MutableLiveData<Boolean>()
    private val viewCommandsPublisher = ReplaySubject.create<ViewCommand>()

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun login(loginOrEmail: String, password: String) {
        compositeDisposable.add(
            loginService
                .login(loginOrEmail = loginOrEmail, password = password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ data ->
                    isLoadingLiveData.postValue(false)
                    responseLiveData.postValue(DataResult.succes(data))
                }, { error ->
                    isLoadingLiveData.postValue(false)
                    responseLiveData.postValue(DataResult.error(error))
                })
        )
    }

    fun forgotPassword() {
        val forgotPasswordLink = resources.getString(R.string.login_forgot_password_link)
        val uri = Uri.parse(forgotPasswordLink)

        viewCommandsPublisher.onNext(
            ViewCommand.ForgotPassword(Intent(Intent.ACTION_VIEW, uri))
        )
    }

    fun outputViewCommand(): Observable<ViewCommand> {
        return viewCommandsPublisher
    }

    fun outputDataResponse(): LiveData<DataResult<LocalUser>> {
        return responseLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}