package io.voucherify.android.sample.store.ui.customer.products.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse

class CustomerProductDetailsSKUAdapter : RecyclerView.Adapter<CustomerProductDetailsSKUItemViewHolder>() {

    private var items: List<ProductSKUResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerProductDetailsSKUItemViewHolder =
        CustomerProductDetailsSKUItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_customer_product_details_sku, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderProductDetailsSKU: CustomerProductDetailsSKUItemViewHolder, position: Int) {
        holderProductDetailsSKU.item = items[position]
    }

    fun setData(data: List<ProductSKUResponse>) {
        items = data
    }
}