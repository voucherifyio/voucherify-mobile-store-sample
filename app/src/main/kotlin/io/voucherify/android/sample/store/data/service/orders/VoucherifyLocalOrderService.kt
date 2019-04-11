package io.voucherify.android.sample.store.data.service.orders

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.data.local.persistence.LocalPersistence
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.data.service.user.perspective.CustomerPerspectiveService

class VoucherifyLocalOrderService(
    private val customerPerspectiveService: CustomerPerspectiveService,
    private val customersLocalPersistence: LocalPersistence<LocalCustomer>,
    private val shoppingCartService: ShoppingCartService
) : OrdersService {

    override fun save(order: LocalOrder) {
        var activeCustomer: LocalCustomer? = customerPerspectiveService.activeCustomer() ?: return
        var orders = activeCustomer?.orders?.toMutableList() ?: mutableListOf()
        orders.add(order)

        activeCustomer?.orders = orders

        var customers = customersLocalPersistence
            .loadAll()
            .toMutableList()
            .map {
                if (it.id == activeCustomer?.id) {
                    activeCustomer
                } else {
                    it
                }
            }

        customersLocalPersistence.save(items = customers)
        shoppingCartService.clear()
    }

    override fun list(): Single<List<LocalOrder>> {
        return Single.just(customerPerspectiveService.activeCustomer()?.orders ?: emptyList())
    }
}