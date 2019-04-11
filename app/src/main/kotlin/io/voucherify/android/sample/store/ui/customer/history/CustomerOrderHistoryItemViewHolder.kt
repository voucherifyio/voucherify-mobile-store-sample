package io.voucherify.android.sample.store.ui.customer.history

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import kotlinx.android.synthetic.main.item_order_history_customer.view.*

class CustomerOrderHistoryItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: LocalOrder? = null
        set(value) {
            field = value

            view.item_order_history_customer_name.text = value?.id ?: ""
        }
}