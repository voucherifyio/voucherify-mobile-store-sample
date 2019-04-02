package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

class ShoppingCartListAdapter(private val itemClick: (item: ShoppingCartItemData) -> Unit) :
    RecyclerView.Adapter<ShoppingCartListItemViewHolder>() {

    data class ShoppingCartItemData(
        val productResponse: ProductResponse,
        val productSKUIndex: Int
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
            itemClick(items[position])
        }
    }

    fun setData(data: List<ShoppingCartItemData>) {
        items = data
    }
}