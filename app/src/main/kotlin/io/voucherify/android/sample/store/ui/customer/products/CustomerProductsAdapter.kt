package io.voucherify.android.sample.store.ui.customer.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse

class CustomerProductsAdapter(private val itemClick: (item: ProductResponse) -> Unit) :
    RecyclerView.Adapter<CustomerProductItemViewHolder>() {

    private var items: List<ProductResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerProductItemViewHolder =
        CustomerProductItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_customer, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderProduct: CustomerProductItemViewHolder, position: Int) {
        holderProduct.item = items[position]

        holderProduct.view.setOnClickListener {
            itemClick(items[position])
        }
    }

    fun setData(data: List<ProductResponse>) {
        items = data
    }
}