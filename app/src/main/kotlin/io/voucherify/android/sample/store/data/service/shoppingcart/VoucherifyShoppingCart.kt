package io.voucherify.android.sample.store.data.service.shoppingcart

import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

class VoucherifyShoppingCart : ShoppingCartService {

    private val items = mutableListOf<Triple<ProductResponse, Int, Int>>()

    override fun items(): List<Triple<ProductResponse, Int, Int>> {
        return items.toList()
    }

    override fun add(item: Pair<ProductResponse, Int>) {

        var itemToUpdate = items.find {
            it.first == item.first && it.second == item.second
        }

        val index = items.indexOf(itemToUpdate)

        if (itemToUpdate != null && index > -1) {

            itemToUpdate = itemToUpdate.copy(
                itemToUpdate.first,
                itemToUpdate.second,
                itemToUpdate.third + 1)

            items[index] = itemToUpdate
        } else {
            items.add(Triple(item.first, item.second, 1))
        }
    }

    override fun remove(item: Pair<ProductResponse, Int>) {

        var itemToUpdate = items.find {
            it.first == item.first && it.second == item.second
        }

        val index = items.indexOf(itemToUpdate)

        if (itemToUpdate != null && index > -1) {

            if(itemToUpdate.third == 1) {
                items.remove(itemToUpdate)
            } else {
                itemToUpdate = itemToUpdate.copy(
                    itemToUpdate.first,
                    itemToUpdate.second,
                    itemToUpdate.third - 1)

                items[index] = itemToUpdate
            }
        }
    }

    override fun clear() {
        items.clear()
    }
}