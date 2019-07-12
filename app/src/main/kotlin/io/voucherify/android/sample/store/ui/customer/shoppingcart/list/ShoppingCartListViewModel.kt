package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.voucherify.android.sample.store.data.service.shoppingcart.ShoppingCartService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class ShoppingCartListViewModel(private val shoppingCartService: ShoppingCartService) : BaseViewModel() {

    private val shoppingCartListItemsLiveData: MutableLiveData<List<ShoppingCartListAdapter.ShoppingCartItemData>> = MutableLiveData()
    private val orderTotalPriceLiveData: MutableLiveData<Double> = MutableLiveData()

    fun fetchItems() {
        shoppingCartListItemsLiveData.value = shoppingCartService
            .items()
            .map {
                ShoppingCartListAdapter.ShoppingCartItemData(
                    productResponse = it.first,
                    productSKUIndex = it.second,
                    quantity = it.third
                )
            }

        refreshTotalPrice()
    }

    fun remove(position: Int) {

        shoppingCartListItemsLiveData.value?.get(position)?.let {
            shoppingCartService.remove(Pair(first = it.productResponse, second = it.productSKUIndex))
        }

        shoppingCartListItemsLiveData.value = shoppingCartService
            .items()
            .map {
                ShoppingCartListAdapter.ShoppingCartItemData(
                    productResponse = it.first,
                    productSKUIndex = it.second,
                    quantity = it.third
                )
            }

        refreshTotalPrice()
    }

    fun outputShoppingCartItems(): LiveData<List<ShoppingCartListAdapter.ShoppingCartItemData>> {
        return shoppingCartListItemsLiveData
    }

    fun outputTotalPrice(): LiveData<Double> {
        return orderTotalPriceLiveData
    }

    private fun refreshTotalPrice() {

        orderTotalPriceLiveData.value = shoppingCartService
            .items()
            .sumByDouble { it.first.skus.data[it.second].price ?: 0.0 }
    }
}
