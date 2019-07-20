package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.tabs

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.data.remote.api.response.VoucherType
import kotlinx.android.synthetic.main.item_voucher_admin.view.*

class VoucherAdminItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: VoucherResponse? = null
        set(value) {
            field = value

            setVoucherInfo(value)
            setVoucherTypeIcon()
            setVoucherActiveCircleIndicator()
            setVoucherStatusName()
            setVoucherTypeName()
        }

    private fun setVoucherInfo(value: VoucherResponse?) {

        view.item_voucher_admin_title.text = value?.code ?: ""
        view.item_voucher_admin_description.text = value?.category ?: ""
    }

    private fun setVoucherTypeName() {

        view.item_voucher_admin_type_name.text = when (item?.type) {
            VoucherType.DISCOUNT_VOUCHER -> view.resources.getString(R.string.voucher_discount_type_label)
            VoucherType.GIFT_VOUCHER -> view.resources.getString(R.string.voucher_gift_type_label)
            else -> view.resources.getString(R.string.common_empty)
        }
    }

    private fun setVoucherStatusName() {

        view.item_voucher_admin_status.text = if (item?.active == true) {
            view.resources.getString(R.string.voucher_active_label)
        } else {
            view.resources.getString(R.string.voucher_inactive_label)
        }
    }

    private fun setVoucherActiveCircleIndicator() {

        val tempDrawable = getDrawable(view.context, R.drawable.circle)
        val bubble: LayerDrawable = tempDrawable as LayerDrawable
        val solidColor: GradientDrawable = bubble?.findDrawableByLayerId(R.id.circle) as GradientDrawable
        solidColor.setColor(
            if (item?.active == true)
                getColor(view.context, R.color.voucherify_color_accent)
            else getColor(view.context, R.color.voucherify_grey)
        )

        view.item_voucher_admin_active_indicator.setImageDrawable(tempDrawable)
    }

    private fun setVoucherTypeIcon() {

        val voucherTypeDrawable = when (item?.type) {
            VoucherType.DISCOUNT_VOUCHER -> R.drawable.ic_voucher
            VoucherType.GIFT_VOUCHER -> R.drawable.ic_giftcard
            else -> R.drawable.ic_voucher
        }

        view.item_voucher_type_image.setImageDrawable(getDrawable(view.context, voucherTypeDrawable))
    }
}