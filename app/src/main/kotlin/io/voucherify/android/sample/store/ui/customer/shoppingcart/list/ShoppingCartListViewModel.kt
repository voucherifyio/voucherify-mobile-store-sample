package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class ShoppingCartListViewModel(private val shoppingCartService: ShoppingCartService) : BaseViewModel() {

    private val shoppingCartListItemsLiveData: MutableLiveData<List<ShoppingCartListAdapter.ShoppingCartItemData>> = MutableLiveData()

    fun fetchItems() {
        shoppingCartListItemsLiveData.value = shoppingCartService.items().map {
            ShoppingCartListAdapter.ShoppingCartItemData(productResponse = it.first, productSKUIndex = it.second)
        }
    }

    fun remove(position: Int) {
        shoppingCartListItemsLiveData.value?.get(position)?.let {
            shoppingCartService.remove(Pair(first = it.productResponse, second = it.productSKUIndex))
        }

        val items = shoppingCartListItemsLiveData.value?.toMutableList()
        items?.removeAt(position)
        shoppingCartListItemsLiveData.value = items
    }

    fun outputShoppingCartItems(): LiveData<List<ShoppingCartListAdapter.ShoppingCartItemData>> {
        return shoppingCartListItemsLiveData
    }
}
