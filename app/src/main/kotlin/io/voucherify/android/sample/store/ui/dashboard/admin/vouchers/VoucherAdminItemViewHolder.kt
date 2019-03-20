package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import kotlinx.android.synthetic.main.item_voucher_admin.view.*

class VoucherAdminItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: VoucherResponse? = null
        set(value) {
            field = value

            view.item_voucher_admin_code.text = value?.code ?: ""
            view.item_voucher_admin_category.text = value?.category ?: ""
        }
}