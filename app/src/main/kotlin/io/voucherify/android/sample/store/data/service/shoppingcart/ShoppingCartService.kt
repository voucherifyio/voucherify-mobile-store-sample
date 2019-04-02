package io.voucherify.android.sample.store.data.service.shoppingcart

import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

interface ShoppingCartService {

    fun items(): List<Pair<ProductResponse, Int>>

    fun add(item: Pair<ProductResponse, Int>)

    fun remove(item: Pair<ProductResponse, Int>)

    fun clear()

}