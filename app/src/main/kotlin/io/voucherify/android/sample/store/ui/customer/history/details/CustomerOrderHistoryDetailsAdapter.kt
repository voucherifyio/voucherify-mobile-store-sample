package io.voucherify.android.sample.store.ui.customer.history.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalOrderItem

class CustomerOrderHistoryDetailsAdapter : RecyclerView.Adapter<CustomerOrderHistoryDetailsItemViewHolder>() {

    private var items: List<LocalOrderItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerOrderHistoryDetailsItemViewHolder =
        CustomerOrderHistoryDetailsItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order_history_details_customer, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderOrderHistoryDetails: CustomerOrderHistoryDetailsItemViewHolder, position: Int) {
        holderOrderHistoryDetails.item = items[position]
    }

    fun setData(data: List<LocalOrderItem>) {
        items = data
    }
}