package io.voucherify.android.sample.store.injection.module.products.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.products.details.ProductAdminDetailsFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.products.details.ProductAdminDetailsViewModel

@Module
class ProductAdminDetailsModule {

    private class ProductAdminDetailsViewModelFactory :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProductAdminDetailsViewModel() as T
        }
    }

    @Provides
    @FragmentScope
    fun provideProductAdminDetailsViewModel(
        fragment: ProductAdminDetailsFragment
    ): ProductAdminDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            ProductAdminDetailsViewModelFactory()
        ).get(ProductAdminDetailsViewModel::class.java)
}