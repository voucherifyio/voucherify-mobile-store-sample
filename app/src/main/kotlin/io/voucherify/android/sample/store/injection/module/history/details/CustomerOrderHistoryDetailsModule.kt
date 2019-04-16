package io.voucherify.android.sample.store.injection.module.history.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.history.details.CustomerOrderHistoryDetailsFragment
import io.voucherify.android.sample.store.ui.customer.history.details.CustomerOrderHistoryDetailsViewModel

@Module
class CustomerOrderHistoryDetailsModule {

    private class CustomerOrdersHistoryViewModelFactory :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerOrderHistoryDetailsViewModel() as T
        }
    }

    @Provides
    @FragmentScope
    fun provideCustomerOrdersHistoryViewModel(
        fragment: CustomerOrderHistoryDetailsFragment
    ): CustomerOrderHistoryDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            CustomerOrdersHistoryViewModelFactory()
        ).get(CustomerOrderHistoryDetailsViewModel::class.java)
}