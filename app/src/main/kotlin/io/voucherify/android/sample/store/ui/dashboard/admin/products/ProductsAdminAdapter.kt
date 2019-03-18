package io.voucherify.android.sample.store.ui.dashboard.admin.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

class ProductsAdminAdapter(private val itemClick: (item: ProductResponse) -> Unit) :
    RecyclerView.Adapter<ProductAdminItemViewHolder>() {

    private var items: List<ProductResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdminItemViewHolder =
        ProductAdminItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_admin, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ProductAdminItemViewHolder, position: Int) {
        holder.item = items[position]

        holder.view.setOnClickListener {
            itemClick(items[position])
        }
    }

    fun setData(data: List<ProductResponse>) {
        items = data
    }
}