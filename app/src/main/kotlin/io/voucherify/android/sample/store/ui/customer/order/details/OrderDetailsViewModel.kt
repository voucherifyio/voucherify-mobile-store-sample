package io.voucherify.android.sample.store.ui.customer.order.details

import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.data.local.model.LocalOrderItem
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.ui.base.BaseViewModel
import java.util.*

class OrderDetailsViewModel(
    private val shoppingCartService: ShoppingCartService,
    private val ordersService: OrdersService
) : BaseViewModel() {

    fun buy() {

        val items = shoppingCartService
            .items()
            .map {
                val item = it.first.skus.data[it.second]
                LocalOrderItem(
                    sku = item,
                    id = UUID.randomUUID().toString(),
                    productId = it.first.id,
                    productSourceId = it.first.sourceId,
                    productName = it.first.name ?: it.first.id
                )
            }

        val order = LocalOrder(
            items = items,
            id = UUID.randomUUID().toString(),
            totalPrice = 99.0,
            createdAt = Date(),
            plannedDeliveryAt = Date()
        )

        ordersService.save(order = order)
    }
}
