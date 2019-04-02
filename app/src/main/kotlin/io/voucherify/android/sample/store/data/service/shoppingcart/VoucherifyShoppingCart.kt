package io.voucherify.android.sample.store.data.service.shoppingcart

import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

class VoucherifyShoppingCart : ShoppingCartService {

    private val items = mutableListOf<Pair<ProductResponse, Int>>()

    override fun items(): List<Pair<ProductResponse, Int>> {
        return items.toList()
    }

    override fun add(item: Pair<ProductResponse, Int>) {
        items.add(item)
    }

    override fun remove(item: Pair<ProductResponse, Int>) {
        items.remove(item)
    }

    override fun clear() {
        items.clear()
    }
}