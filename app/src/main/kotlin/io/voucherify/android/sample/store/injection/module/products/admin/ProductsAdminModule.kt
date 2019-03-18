package io.voucherify.android.sample.store.injection.module.products.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.customers.ProductsService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.products.ProductsAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.products.ProductsAdminViewModel

@Module
class ProductsAdminModule {

    private class ProductsAdminViewModelFactory(private val productsService: ProductsService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProductsAdminViewModel(productsService = productsService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideProductsAdminViewModel(
        fragment: ProductsAdminFragment,
        productsService: ProductsService
    ): ProductsAdminViewModel =
        ViewModelProviders.of(
            fragment,
            ProductsAdminViewModelFactory(productsService = productsService)
        ).get(ProductsAdminViewModel::class.java)

}