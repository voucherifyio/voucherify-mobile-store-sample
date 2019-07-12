package io.voucherify.android.sample.store.ui.customer.products.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse
import kotlinx.android.synthetic.main.item_customer_product_details_sku.view.*

class CustomerProductDetailsSKUItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: Pair<ProductResponse, ProductSKUResponse>? = null
        set(value) {
            field = value

            val product = field?.first
            val productSku = field?.second

            view.item_product_details_sku_customer_name.text = product?.name ?: ""
            view.item_product_details_sku_customer_sku.text = productSku?.sku ?: ""
        }
}