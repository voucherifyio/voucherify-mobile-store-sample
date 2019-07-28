package io.voucherify.android.sample.store.ui.customer.order.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.data.local.model.LocalOrderItem
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService
import io.voucherify.android.sample.store.ui.base.BaseViewModel
import java.util.*

class OrderDetailsViewModel(
    private val customerPerspectiveService: CustomerPerspectiveService,
    private val shoppingCartService: ShoppingCartService,
    private val ordersService: OrdersService
) : BaseViewModel() {

    private val customerLiveData = MutableLiveData<LocalCustomer>()
    private val orderCostLiveData = MutableLiveData<Double>()

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

    fun outputOderCost(): LiveData<Double> {

        orderCostLiveData.value = shoppingCartService.items()
            .sumByDouble {
                val item = it.first.skus.data[it.second]
                item.price ?: 0.0
            }

        return orderCostLiveData
    }

    fun outputCustomerData(): LiveData<LocalCustomer> {

        customerPerspectiveService.activeCustomer()?.let {
            customerLiveData.value = it
        }

        return customerLiveData
    }
}
