package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_vouchers_admin.*
import javax.inject.Inject

class VouchersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "VouchersAdminFragment"

        fun newInstance() = VouchersAdminFragment()
    }

    @Inject
    lateinit var viewModel: VouchersAdminViewModel

    @Inject
    lateinit var navigator: Navigator

    private val vouchersAdapter = VouchersAdminAdapter(itemClick = { item ->
        activity?.let {
            navigator.openVoucherAdminDetails(it, voucherResponse = item)
        }
    })

    private val dataObserver = Observer<DataResult<List<VoucherResponse>>> { result ->
        when (result.status) {
            DataResult.Status.ERROR -> {
                Toast.makeText(activity, R.string.common_error, Toast.LENGTH_SHORT).show()
            }

            DataResult.Status.SUCCESS -> {
                result.data?.let {
                    vouchersAdapter.setData(it)
                    vouchersAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_vouchers_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchVouchers()
    }

    private fun setViews() {
        vouchers_admin_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        vouchers_admin_list.adapter = vouchersAdapter
    }

    private fun setBindings() {

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outputVouchersDataResponse()
            .observe(this, dataObserver)
    }
}