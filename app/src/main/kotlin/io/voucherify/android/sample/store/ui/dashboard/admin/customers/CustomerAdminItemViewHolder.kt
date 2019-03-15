package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import kotlinx.android.synthetic.main.item_customer_admin.view.*

class CustomerAdminItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: CustomerResponse? = null
        set(value) {
            field = value

            view.item_customer_admin_name.text = value?.name ?: value?.id
            view.item_customer_admin_email.text = value?.email ?: ""
        }
}