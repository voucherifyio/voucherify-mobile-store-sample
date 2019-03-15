package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse

class CustomerAdminAdapter() : RecyclerView.Adapter<CustomerAdminItemViewHolder>() {

    private var items: List<CustomerResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerAdminItemViewHolder =
        CustomerAdminItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_customer_admin, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: CustomerAdminItemViewHolder, position: Int) {
        holder.item = items[position]
        holder.view.setOnClickListener {
            //TODO Handle item click
        }
    }

    fun setData(data: List<CustomerResponse>) {
        items = data
    }
}