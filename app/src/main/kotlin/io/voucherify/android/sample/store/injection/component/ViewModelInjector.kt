package io.voucherify.android.sample.store.injection.component

import dagger.Component
import io.voucherify.android.sample.store.injection.module.NetworkModule
import io.voucherify.android.sample.store.ui.login.LoginViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ViewModelInjector {

    fun inject(postListViewModel: LoginViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}