package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import kotlinx.android.synthetic.main.item_shopping_cart.view.*

class ShoppingCartListItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: ShoppingCartListAdapter.ShoppingCartItemData? = null
        set(value) {
            field = value

            val index = value?.productSKUIndex ?: 0
            val data = value?.productResponse?.skus?.data?.get(index)

            view.item_shopping_cart_name.text = value?.productResponse?.name ?: ""
            view.item_shopping_cart_details.text = data?.sku ?: ""
            view.item_shopping_cart_quantity.text = view
                .resources
                .getString(R.string.shopping_cart_item_quantity_template, value?.quantity)
        }
}