package io.voucherify.android.sample.store.injection.module.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.history.CustomerOrdersHistoryFragment
import io.voucherify.android.sample.store.ui.customer.history.CustomerOrdersHistoryViewModel

@Module
class CustomerOrdersHistoryModule {

    private class CustomerOrdersHistoryViewModelFactory(private val ordersService: OrdersService) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CustomerOrdersHistoryViewModel(ordersService = ordersService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideCustomerOrdersHistoryViewModel(
        ordersHistoryFragment: CustomerOrdersHistoryFragment,
        ordersService: OrdersService
    ): CustomerOrdersHistoryViewModel =
        ViewModelProviders.of(
            ordersHistoryFragment,
            CustomerOrdersHistoryViewModelFactory(ordersService = ordersService)
        ).get(CustomerOrdersHistoryViewModel::class.java)

}