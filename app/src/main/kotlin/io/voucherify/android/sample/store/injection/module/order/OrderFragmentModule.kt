package io.voucherify.android.sample.store.injection.module.order

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.order.address.OrderAddressFragment

@Module
abstract class OrderFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            OrderModule::class]
    )
    abstract fun orderAddressFragment(): OrderAddressFragment
}