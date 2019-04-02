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

    fun outputShoppingCartItems(): LiveData<List<ShoppingCartListAdapter.ShoppingCartItemData>> {
        return shoppingCartListItemsLiveData
    }
}
