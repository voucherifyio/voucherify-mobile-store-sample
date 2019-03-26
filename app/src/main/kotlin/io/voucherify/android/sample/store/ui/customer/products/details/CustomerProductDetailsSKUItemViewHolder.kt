package io.voucherify.android.sample.store.ui.customer.products.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse
import kotlinx.android.synthetic.main.item_customer_product_details_sku.view.*

class CustomerProductDetailsSKUItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: ProductSKUResponse? = null
        set(value) {
            field = value

            view.item_product_details_sku_customer_name.text = value?.sku ?: ""
            view.item_product_details_sku_customer_id.text = value?.id ?: ""
            view.item_product_details_sku_customer_price.text = "${value?.price ?: "-"}"
        }
}