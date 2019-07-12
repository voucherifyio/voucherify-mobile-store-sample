package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import kotlinx.android.synthetic.main.item_shopping_cart.view.*

class ShoppingCartListAdapter(private val listener: OnItemListener) :
    RecyclerView.Adapter<ShoppingCartListItemViewHolder>() {

    interface OnItemListener {

        fun onItemClick(item: ShoppingCartItemData)
        fun onItemDelete(position: Int)
    }

    data class ShoppingCartItemData(
        val productResponse: ProductResponse,
        val productSKUIndex: Int,
        val quantity: Int
    )

    private var items: List<ShoppingCartItemData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartListItemViewHolder =
             ShoppingCartListItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shopping_cart, parent, false)
            )
    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderShoppingCartList: ShoppingCartListItemViewHolder, position: Int) {
        holderShoppingCartList.item = items[position]

        holderShoppingCartList.view.setOnClickListener {
            listener.onItemClick(item = items[position])
        }

        holderShoppingCartList.view.item_shopping_cart_remove_button.setOnClickListener {
            listener.onItemDelete(position = position)
        }
    }

    fun setData(data: List<ShoppingCartListAdapter.ShoppingCartItemData>) {
        items = data
    }
}