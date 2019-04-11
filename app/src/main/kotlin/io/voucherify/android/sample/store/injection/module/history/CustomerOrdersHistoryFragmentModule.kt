package io.voucherify.android.sample.store.injection.module.history

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.history.CustomerOrdersHistoryFragment

@Module
abstract class CustomerOrdersHistoryFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomerOrdersHistoryModule::class]
    )
    abstract fun customerOrdersHistoryFragment(): CustomerOrdersHistoryFragment
}