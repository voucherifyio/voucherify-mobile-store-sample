package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse

class VouchersAdminAdapter(private val itemClick: (item: VoucherResponse) -> Unit) :
    RecyclerView.Adapter<VoucherAdminItemViewHolder>() {

    private var items: List<VoucherResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherAdminItemViewHolder =
        VoucherAdminItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_voucher_admin, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: VoucherAdminItemViewHolder, position: Int) {
        holder.item = items[position]

        holder.view.setOnClickListener {
            itemClick(items[position])
        }
    }

    fun setData(data: List<VoucherResponse>) {
        items = data
    }
}