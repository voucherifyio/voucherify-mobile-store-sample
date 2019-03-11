package io.voucherify.android.sample.store.injection.module.dashboard

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.dashboard.admin.DashboardAdminActivity

@Module
abstract class DashboardAdminActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            DashboardAdminModule::class]
    )
    abstract fun dashboardAdminActivity(): DashboardAdminActivity
}