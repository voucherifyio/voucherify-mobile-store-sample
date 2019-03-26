package io.voucherify.android.sample.store.injection.module.products.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.customers.ProductsService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.products.CustomerProductsFragment
import io.voucherify.android.sample.store.ui.customer.products.CustomerProductsViewModel

@Module
class CustomerProductsModule {

    private class ProductsCustomerViewModelFactory(private val productsService: ProductsService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerProductsViewModel(productsService = productsService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideProductsAdminViewModel(
        productsFragment: CustomerProductsFragment,
        productsService: ProductsService
    ): CustomerProductsViewModel =
        ViewModelProviders.of(
            productsFragment,
            ProductsCustomerViewModelFactory(productsService = productsService)
        ).get(CustomerProductsViewModel::class.java)

}