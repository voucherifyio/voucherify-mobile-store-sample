package io.voucherify.android.sample.store.injection.module.history.details

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.history.details.CustomerOrderHistoryDetailsFragment

@Module
abstract class CustomerOrderHistoryDetailsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomerOrderHistoryDetailsModule::class]
    )
    abstract fun customerOrderHistoryDetailsFragment(): CustomerOrderHistoryDetailsFragment
}
