package io.voucherify.android.sample.store.injection.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.voucherify.android.sample.store.VoucherifyApplication
import io.voucherify.android.sample.store.injection.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContributeActivityModule::class,
        ContributeFragmentModule::class,
        ApplicationModule::class,
        ApiModule::class,
        DataModule::class,
        RepositoryModule::class,
        ServiceModule::class
    ]
)

interface ApplicationComponent : AndroidInjector<VoucherifyApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<VoucherifyApplication>() {

        abstract fun apiModule(apiModule: ApiModule): Builder
        abstract fun networkModule(networkModule: NetworkModule): Builder
        abstract fun dataModule(dataModule: DataModule): Builder
        abstract fun serviceModule(serviceModule: ServiceModule): Builder
    }
}