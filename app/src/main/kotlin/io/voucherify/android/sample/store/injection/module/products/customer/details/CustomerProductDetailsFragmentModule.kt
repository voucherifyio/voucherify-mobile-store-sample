package io.voucherify.android.sample.store.injection.module.products.customer.details

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsFragment

@Module
abstract class CustomerProductDetailsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomerProductDetailsModule::class]
    )
    abstract fun customerProductDetailsFragment(): CustomerProductDetailsFragment
}
