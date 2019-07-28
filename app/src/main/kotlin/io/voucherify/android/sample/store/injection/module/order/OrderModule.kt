package io.voucherify.android.sample.store.injection.module.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.order.address.OrderAddressFragment
import io.voucherify.android.sample.store.ui.customer.order.address.OrderAddressViewModel
import io.voucherify.android.sample.store.ui.customer.order.details.OrderDetailsFragment
import io.voucherify.android.sample.store.ui.customer.order.details.OrderDetailsViewModel
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsFragment
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsViewModel

@Module
class OrderModule {

    private class OrderAddressViewModelFactory(
        private val customerPerspectiveService: CustomerPerspectiveService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderAddressViewModel(
                customerPerspectiveService = customerPerspectiveService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideOrderAddressViewModel(
        fragment: OrderAddressFragment,
        customerPerspectiveService: CustomerPerspectiveService
    ): OrderAddressViewModel =
        ViewModelProviders.of(
            fragment,
            OrderAddressViewModelFactory(
                customerPerspectiveService = customerPerspectiveService
            )
        ).get(OrderAddressViewModel::class.java)

    private class OrderDetailsViewModelFactory(
        private val ordersService: OrdersService,
        private val shoppingCartService: ShoppingCartService,
        private val customerPerspectiveService: CustomerPerspectiveService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderDetailsViewModel(
                customerPerspectiveService = customerPerspectiveService,
                ordersService = ordersService,
                shoppingCartService = shoppingCartService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideOrderDetailsViewModel(
        fragment: OrderDetailsFragment,
        customerPerspectiveService: CustomerPerspectiveService,
        ordersService: OrdersService,
        shoppingCartService: ShoppingCartService
    ): OrderDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            OrderDetailsViewModelFactory(
                customerPerspectiveService = customerPerspectiveService,
                ordersService = ordersService,
                shoppingCartService = shoppingCartService
            )
        ).get(OrderDetailsViewModel::class.java)

    private class OderPaymentDetailsViewModelFactory(
        private val customerPerspectiveService: CustomerPerspectiveService
    ) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderPaymentDetailsViewModel(customerPerspectiveService = customerPerspectiveService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideOrderPaymentDetailsViewModel(
        fragment: OrderPaymentDetailsFragment,
        customerPerspectiveService: CustomerPerspectiveService
    ): OrderPaymentDetailsViewModel =
        ViewModelProviders.of(
            fragment,
            OderPaymentDetailsViewModelFactory(customerPerspectiveService = customerPerspectiveService)
        ).get(OrderPaymentDetailsViewModel::class.java)
}