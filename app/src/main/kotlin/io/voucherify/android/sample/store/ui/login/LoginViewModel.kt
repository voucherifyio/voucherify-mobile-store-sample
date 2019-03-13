package io.voucherify.android.sample.store.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.service.login.LoginService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class LoginViewModel(private val loginService: LoginService) : BaseViewModel() {

    private val responseLiveData = MutableLiveData<DataResult<LocalUser>>()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

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

    fun outputDataResponse(): LiveData<DataResult<LocalUser>> {
        return responseLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}