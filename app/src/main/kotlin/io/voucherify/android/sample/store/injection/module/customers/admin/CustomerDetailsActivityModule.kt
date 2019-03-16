package io.voucherify.android.sample.store.injection.module.customers.admin

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.details.CustomerDetailsActivity

@Module
abstract class CustomerDetailsActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun customerDetailsActivity(): CustomerDetailsActivity
}