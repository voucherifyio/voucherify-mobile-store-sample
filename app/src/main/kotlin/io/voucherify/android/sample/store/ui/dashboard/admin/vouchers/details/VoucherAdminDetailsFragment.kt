package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.data.remote.api.response.VoucherType
import io.voucherify.android.sample.store.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_voucher_details_admin.*
import javax.inject.Inject

class VoucherAdminDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "VoucherAdminDetailsFragment"

        fun newInstance(voucher: VoucherResponse) = VoucherAdminDetailsFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable(VoucherAdminDetailsActivity.VOUCHER_DETAILS_KEY, voucher)
            arguments = bundle
        }
    }

    @Inject
    lateinit var viewModel: VoucherAdminDetailsViewModel

    private val dataObserver = Observer<VoucherResponse> { result ->
        setVoucherMetadata(result)
        setVoucherTypeData(result)
        setVoucherActiveCircleIndicator(voucher = result)
        setVoucherStatusName(voucher = result)
    }

    private fun setVoucherMetadata(result: VoucherResponse) {
        voucher_details_admin_code.text = result.code
        voucher_details_admin_category.text = result.category
    }

    private fun setVoucherTypeData(result: VoucherResponse) {
        when (result.type) {
            VoucherType.DISCOUNT_VOUCHER -> {
                voucher_details_admin_type.text = resources.getString(R.string.voucher_discount_type_label)
                voucher_details_admin_discount_value.text = "${result.discount?.discount}"
            }
            VoucherType.GIFT_VOUCHER -> {
                voucher_details_admin_type.text = resources.getString(R.string.voucher_gift_type_label)
                result.gift?.let {
                    val value: Long = if (it.amount > 0) {
                        it.amount
                    } else {
                        it.balance
                    }
                    voucher_details_admin_discount_value.text = "$value"
                }
            }
        }
    }

    private fun setVoucherStatusName(voucher: VoucherResponse) {

        voucher_details_admin_subheader_status.text = if (voucher.active) {
            resources.getString(R.string.voucher_active_label)
        } else {
            resources.getString(R.string.voucher_inactive_label)
        }
    }

    private fun setVoucherActiveCircleIndicator(voucher: VoucherResponse) {

        activity?.let {
            val tempDrawable = ContextCompat.getDrawable(it, R.drawable.circle)
            val bubble: LayerDrawable = tempDrawable as LayerDrawable
            val solidColor: GradientDrawable = bubble.findDrawableByLayerId(R.id.circle) as GradientDrawable

            solidColor.setColor(
                    if (voucher.active)
                        ContextCompat.getColor(it, R.color.voucherify_color_primary)
                    else ContextCompat.getColor(it, R.color.voucherify_grey)
            )

            voucher_details_admin_subheader_status_indicator.setImageDrawable(tempDrawable)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<VoucherResponse>(VoucherAdminDetailsActivity.VOUCHER_DETAILS_KEY)?.let {
            viewModel.setData(
                    voucher = it
            )
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_voucher_details_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBindings()
    }

    private fun setBindings() {

        viewModel
                .outputCustomerDetailsData()
                .observe(this, dataObserver)
    }
}