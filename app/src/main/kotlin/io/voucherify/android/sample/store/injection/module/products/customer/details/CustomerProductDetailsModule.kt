package io.voucherify.android.sample.store.injection.module.products.customer.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsFragment
import io.voucherify.android.sample.store.ui.customer.products.details.CustomerProductDetailsViewModel

@Module
class CustomerProductDetailsModule {

    private class CustomerProductDetailsViewModelFactory :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerProductDetailsViewModel() as T
        }
    }

    @Provides
    @FragmentScope
    fun provideProductAdminDetailsViewModel(
        fragment: CustomerProductDetailsFragment
    ): CustomerProductDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            CustomerProductDetailsViewModelFactory()
        ).get(CustomerProductDetailsViewModel::class.java)
}