package io.voucherify.android.sample.store.ui.dashboard.admin.products.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.ProductSKUResponse
import kotlinx.android.synthetic.main.item_product_details_admin_sku.view.*

class ProductAdminDetailsSKUItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: ProductSKUResponse? = null
        set(value) {
            field = value

            view.item_product_admin_details_sku_name.text = value?.sku ?: ""
            view.item_product_admin_details_sku_id.text = value?.id ?: ""
            view.item_product_admin_details_sku_price.text = "${value?.price ?: "-"}"
        }
}