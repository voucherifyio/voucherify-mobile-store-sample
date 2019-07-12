package io.voucherify.android.sample.store.ui.customer.products.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse
import kotlinx.android.synthetic.main.item_customer_product_details_sku.view.*

class CustomerProductDetailsSKUAdapter(private val productResponse: ProductResponse,
                                       private val itemBuyClick: (Pair<ProductSKUResponse, Int>) -> Unit
) :
    RecyclerView.Adapter<CustomerProductDetailsSKUItemViewHolder>() {

    private var items: List<ProductSKUResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerProductDetailsSKUItemViewHolder =
        CustomerProductDetailsSKUItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_customer_product_details_sku, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderProductDetailsSKU: CustomerProductDetailsSKUItemViewHolder, position: Int) {
        holderProductDetailsSKU.item = Pair(productResponse, items[position])
        holderProductDetailsSKU.view.item_product_details_sku_customer_buy_button.setOnClickListener {
            itemBuyClick(Pair(first = items[position], second = position))
        }
    }

    fun setData(data: List<ProductSKUResponse>) {
        items = data
    }
}