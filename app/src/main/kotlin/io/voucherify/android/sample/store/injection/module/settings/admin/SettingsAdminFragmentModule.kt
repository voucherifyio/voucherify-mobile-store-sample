package io.voucherify.android.sample.store.injection.module.settings.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminFragment

@Module
abstract class SettingsAdminFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            SettingsAdminModule::class]
    )
    abstract fun settingsAdminFragment(): SettingsAdminFragment
}