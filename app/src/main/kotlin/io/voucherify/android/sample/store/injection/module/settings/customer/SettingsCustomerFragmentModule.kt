package io.voucherify.android.sample.store.injection.module.settings.customer

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.settings.SettingsCustomerFragment

@Module
abstract class SettingsCustomerFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            SettingsCustomerModule::class]
    )
    abstract fun settingsCustomerFragment(): SettingsCustomerFragment
}