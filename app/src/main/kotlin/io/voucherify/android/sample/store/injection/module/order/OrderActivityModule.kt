package io.voucherify.android.sample.store.injection.module.order

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.ActivityScope
import io.voucherify.android.sample.store.ui.customer.order.OrderActivity

@Module
abstract class OrderActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            OrderModule::class]
    )
    abstract fun orderActivity(): OrderActivity
}