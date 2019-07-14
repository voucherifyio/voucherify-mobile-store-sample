package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_header_simple.view.*

class CustomerAdminItemHeaderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var title: String? = null
        set(value) {
            field = value

            view.item_header_title.text = value
        }
}