package io.voucherify.android.sample.store.injection.module.dashboard

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.dashboard.DashboardActivity

@Module
abstract class DashboardActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            DashboardModule::class]
    )
    abstract fun dashboardActivity(): DashboardActivity
}