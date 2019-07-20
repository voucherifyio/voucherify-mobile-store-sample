package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
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
        voucher_details_admin_id.text = result.id
        voucher_details_admin_code.text = result.code
        voucher_details_admin_category.text = result.category
        voucher_details_admin_type.text = result.type.name
        voucher_details_admin_is_active.text = result.active.toString()
        voucher_details_admin_discount_type.text = result.discount?.type?.name ?: ""
        voucher_details_admin_discount_value.text = "${result.discount?.discount}"
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