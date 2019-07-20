package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.tabs

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminViewModel
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_vouchers_admin_list.*
import javax.inject.Inject

class VouchersAdminListFragment : BaseFragment() {

    enum class VoucherFilter {
        ALL,
        ACTIVE
    }

    companion object {

        const val TAG = "VouchersAdminListFragment"
        private const val VOUCHERS_FILTER_KEY = "vouchers_filter_key"

        fun newInstance(filter: VoucherFilter) = VouchersAdminListFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(VOUCHERS_FILTER_KEY, filter)
            arguments = bundle
        }
    }

    @Inject
    lateinit var navigator: Navigator

    lateinit var viewModel: VouchersAdminViewModel

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

    private val vouchersAdapter = VouchersAdminAdapter(itemClick = { item ->
        activity?.let {
            navigator.openVoucherAdminDetails(it, voucherResponse = item)
        }
    })

    override fun fragmentLayoutId(): Int = R.layout.fragment_vouchers_admin_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val filter: VoucherFilter =
            ((arguments?.getSerializable(VOUCHERS_FILTER_KEY) ?: VoucherFilter.ALL) as VoucherFilter)
        vouchersAdapter.setFilteringBy(filter = filter)

        viewModel = fragmentManager?.findFragmentByTag(VouchersAdminFragment.TAG)?.run {
            ViewModelProviders.of(this)[VouchersAdminViewModel::class.java]
        } ?: throw Exception("Invalid Fragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()
    }

    private fun setViews() {

        vouchers_admin_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = RecyclerView.VERTICAL
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
            .outputVouchersDataResponse()
            .observe(this, dataObserver)
    }
}