package io.voucherify.android.sample.store.injection.module.products.customer

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.products.CustomerProductsFragment

@Module
abstract class CustomerProductsFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            CustomerProductsModule::class]
    )
    abstract fun productsCustomerFragment(): CustomerProductsFragment

}
