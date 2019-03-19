package io.voucherify.android.sample.store.ui.dashboard.admin.products.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse

class ProductsAdminDetailsSKUAdapter : RecyclerView.Adapter<ProductAdminDetailsSKUItemViewHolder>() {

    private var items: List<ProductSKUResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdminDetailsSKUItemViewHolder =
        ProductAdminDetailsSKUItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_details_admin_sku, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ProductAdminDetailsSKUItemViewHolder, position: Int) {
        holder.item = items[position]
    }

    fun setData(data: List<ProductSKUResponse>) {
        items = data
    }
}