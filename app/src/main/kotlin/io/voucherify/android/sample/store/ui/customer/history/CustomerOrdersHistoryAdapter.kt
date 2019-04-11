package io.voucherify.android.sample.store.ui.customer.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalOrder

class CustomerOrdersHistoryAdapter(private val itemClick: (item: LocalOrder) -> Unit) :
    RecyclerView.Adapter<CustomerOrderHistoryItemViewHolder>() {

    private var items: List<LocalOrder> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerOrderHistoryItemViewHolder =
        CustomerOrderHistoryItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order_history_customer, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holderOrderHistory: CustomerOrderHistoryItemViewHolder, position: Int) {
        holderOrderHistory.item = items[position]

        holderOrderHistory.view.setOnClickListener {
            itemClick(items[position])
        }
    }

    fun setData(data: List<LocalOrder>) {
        items = data
    }
}