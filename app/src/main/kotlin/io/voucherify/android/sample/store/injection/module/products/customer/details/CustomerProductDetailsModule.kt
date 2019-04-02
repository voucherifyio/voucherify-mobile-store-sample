package io.voucherify.android.sample.store.injection.module.products.customer.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsFragment
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsViewModel

@Module
class CustomerProductDetailsModule {

    private class CustomerProductDetailsViewModelFactory(
        private val shoppingCartService: ShoppingCartService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerProductDetailsViewModel(shoppingCartService = shoppingCartService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideProductAdminDetailsViewModel(
        fragment: CustomerProductDetailsFragment,
        shoppingCartService: ShoppingCartService
    ): CustomerProductDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            CustomerProductDetailsViewModelFactory(shoppingCartService = shoppingCartService)
        ).get(CustomerProductDetailsViewModel::class.java)
}