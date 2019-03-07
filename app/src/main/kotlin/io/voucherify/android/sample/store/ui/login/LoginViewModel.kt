package io.voucherify.android.sample.store.ui.login

import io.reactivex.disposables.Disposable
import io.voucherify.android.sample.store.ui.base.BaseViewModel
import retrofit2.Retrofit
import javax.inject.Inject

class LoginViewModel : BaseViewModel() {

    @Inject
    lateinit var retrofit: Retrofit

    private lateinit var subscription: Disposable

}