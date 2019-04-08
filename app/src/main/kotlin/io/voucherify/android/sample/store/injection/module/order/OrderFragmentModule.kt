package io.voucherify.android.sample.store.injection.module.order

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.order.address.OrderAddressFragment
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsFragment
import io.voucherify.android.sample.store.ui.customer.order.summary.OrderSummaryFragment

@Module
abstract class OrderFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            OrderModule::class]
    )
    abstract fun orderAddressFragment(): OrderAddressFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            OrderModule::class]
    )
    abstract fun orderPaymentDetailsFragment(): OrderPaymentDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            OrderModule::class]
    )
    abstract fun orderSummaryFragment(): OrderSummaryFragment
}