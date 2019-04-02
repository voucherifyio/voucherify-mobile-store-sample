package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shopping_cart.view.*

class ShoppingCartListItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: ShoppingCartListAdapter.ShoppingCartItemData? = null
        set(value) {
            field = value

            val index = value?.productSKUIndex ?: 0
            val data = value?.productResponse?.skus?.data?.get(index)

            view.item_shopping_cart_name.text = data?.sku ?: ""
            view.item_shopping_cart_price.text = "${data?.price ?: 0.0} ${data?.currency ?: ""}"
        }
}