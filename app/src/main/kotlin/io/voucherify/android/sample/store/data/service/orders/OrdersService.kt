package io.voucherify.android.sample.store.data.service.orders

import io.reactivex.Single
import io.voucherify.android.sample.store.data.local.model.LocalOrder

interface OrdersService {

    fun list(): Single<List<LocalOrder>>

    fun save(order: LocalOrder)
}