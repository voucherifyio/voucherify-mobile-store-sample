package io.voucherify.android.sample.store.injection.module.products.customer.details

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsActivity

@Module
abstract class CustomerProductDetailsActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun customerProductDetailsActivity(): CustomerProductDetailsActivity
}