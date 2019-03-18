package io.voucherify.android.sample.store.ui.dashboard.admin.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import kotlinx.android.synthetic.main.item_product_admin.view.*

class ProductAdminItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: ProductResponse? = null
        set(value) {
            field = value

            view.item_product_admin_name.text = value?.name ?: ""
            view.item_product_admin_id.text = value?.id ?: ""
        }
}