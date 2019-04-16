package io.voucherify.android.sample.store.injection.module.history.details

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.customer.history.details.CustomerOrderHistoryDetailsActivity

@Module
abstract class CustomerOrderHistoryDetailsActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun customerOrderHistoryDetailsActivity(): CustomerOrderHistoryDetailsActivity
}