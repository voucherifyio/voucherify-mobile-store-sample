package io.voucherify.android.sample.store.injection.module.dashboard.customer

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.customer.DashboardCustomerActivity

@Module
abstract class DashboardCustomerActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            DashboardCustomerModule::class]
    )
    abstract fun dashboardCustomerActivity(): DashboardCustomerActivity
}