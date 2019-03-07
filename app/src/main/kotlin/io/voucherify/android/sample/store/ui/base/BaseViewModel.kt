package io.voucherify.android.sample.store.ui.base

import androidx.lifecycle.ViewModel
import io.voucherify.android.sample.store.injection.component.DaggerViewModelInjector
import io.voucherify.android.sample.store.injection.component.ViewModelInjector
import io.voucherify.android.sample.store.injection.module.NetworkModule
import io.voucherify.android.sample.store.ui.login.LoginViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is LoginViewModel -> injector.inject(this)
        }
    }
}