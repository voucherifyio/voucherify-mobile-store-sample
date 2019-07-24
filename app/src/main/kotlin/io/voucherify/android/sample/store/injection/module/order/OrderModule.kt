package io.voucherify.android.sample.store.injection.module.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.data.service.user.UserService
import io.voucherify.android.sample.store.injection.scope.FragmentScope
import io.voucherify.android.sample.store.ui.customer.order.details.OrderDetailsFragment
import io.voucherify.android.sample.store.ui.customer.order.details.OrderDetailsViewModel
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsFragment
import io.voucherify.android.sample.store.ui.customer.order.payment.OrderPaymentDetailsViewModel

@Module
class OrderModule {

    private class OrderDetailsViewModelFactory(
            private val ordersService: OrdersService,
            private val shoppingCartService: ShoppingCartService
    ) :
            ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderDetailsViewModel(
                    ordersService = ordersService,
                    shoppingCartService = shoppingCartService
            ) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideOrderDetailsViewModel(
            fragment: OrderDetailsFragment,
            ordersService: OrdersService,
            shoppingCartService: ShoppingCartService
    ): OrderDetailsViewModel =
            ViewModelProviders.of(
                    fragment,
                    OrderDetailsViewModelFactory(
                            ordersService = ordersService,
                            shoppingCartService = shoppingCartService
                    )
            ).get(OrderDetailsViewModel::class.java)

    private class OderPaymentDetailsViewModelFactory(
            private val userService: UserService
    ) :
            ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return OrderPaymentDetailsViewModel(userService = userService) as T
        }
    }

    @Provides
    @FragmentScope
    fun provideOrderPaymentDetailsViewModel(
            fragment: OrderPaymentDetailsFragment,
            userService: UserService
    ): OrderPaymentDetailsViewModel =
            ViewModelProviders.of(
                    fragment,
                    OderPaymentDetailsViewModelFactory(userService = userService)
            ).get(OrderPaymentDetailsViewModel::class.java)
}