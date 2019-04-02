package io.voucherify.android.sample.store.injection.module.shoppingcart.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.shoppingcart.list.ShoppingCartListFragment
import io.voucherify.android.sample.store.ui.customer.shoppingcart.list.ShoppingCartListViewModel

@Module
class ShoppingCartListModule {

    private class ShoppingCartViewModelFactory(
        private val shoppingCartService: ShoppingCartService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ShoppingCartListViewModel(
                shoppingCartService = shoppingCartService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideShoppingCartListViewModel(
        fragment: ShoppingCartListFragment,
        shoppingCartService: ShoppingCartService
    ): ShoppingCartListViewModel =
        ViewModelProviders.of(
            fragment,
            ShoppingCartViewModelFactory(
                shoppingCartService = shoppingCartService
            )
        ).get(ShoppingCartListViewModel::class.java)

}