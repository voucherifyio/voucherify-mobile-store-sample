package io.voucherify.android.sample.store.injection.module.customers.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.details.CustomerDetailsFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.details.CustomerDetailsViewModel

@Module
class CustomerDetailsModule {

    private class CustomerDetailsViewModelFactory() :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerDetailsViewModel() as T
        }
    }

    @Provides
    @FragmentScope
    fun provideCustomerDetailsViewModel(
        fragment: CustomerDetailsFragment
    ): CustomerDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            CustomerDetailsViewModelFactory()
        ).get(CustomerDetailsViewModel::class.java)
}