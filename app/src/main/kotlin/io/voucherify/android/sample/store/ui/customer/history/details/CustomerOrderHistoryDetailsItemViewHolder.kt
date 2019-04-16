package io.voucherify.android.sample.store.ui.customer.history.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.local.model.LocalOrderItem
import kotlinx.android.synthetic.main.item_order_history_details_customer.view.*

class CustomerOrderHistoryDetailsItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: LocalOrderItem? = null
        set(value) {
            field = value

            view.item_order_history_details_customer_name.text = value?.productName ?: ""
            view.item_order_history_details_customer_sku.text = value?.sku?.sku ?: "-"
            view.item_order_history_details_customer_price.text = "${value?.sku?.price ?: "-"}"
        }
}