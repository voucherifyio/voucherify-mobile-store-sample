package io.voucherify.android.sample.store.injection.module.shoppingcart.list

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.shoppingcart.list.ShoppingCartListFragment

@Module
abstract class ShoppingCartListFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [ShoppingCartListModule::class]
    )
    abstract fun shoppingCartListFragment(): ShoppingCartListFragment
}