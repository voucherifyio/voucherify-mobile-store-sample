package io.voucherify.android.sample.store.ui.customer.history.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_order_history_details_customer.*
import javax.inject.Inject

class CustomerOrderHistoryDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomerOrderHistoryDetailsFragment"

        fun newInstance(order: LocalOrder) = CustomerOrderHistoryDetailsFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable(CustomerOrderHistoryDetailsActivity.ORDER_HISTORY_DETAILS_KEY, order)
            arguments = bundle
        }
    }

    @Inject
    lateinit var viewModel: CustomerOrderHistoryDetailsViewModel

    private val dataObserver = Observer<LocalOrder> { data ->
        order_history_details_customer_created_at.text = data.createdAt.toString()
        order_history_details_customer_delivery_at.text = data.plannedDeliveryAt.toString()

        adapter.setData(data.items)
        adapter.notifyDataSetChanged()
    }

    private val adapter = CustomerOrderHistoryDetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<LocalOrder>(CustomerOrderHistoryDetailsActivity.ORDER_HISTORY_DETAILS_KEY)?.let {
            viewModel.setData(
                order = it
            )
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_order_history_details_customer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()
    }

    private fun setViews() {
        order_history_details_customer_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        order_history_details_customer_list.adapter = adapter
    }

    private fun setBindings() {

        viewModel
            .outputOrderHistoryDetailsData()
            .observe(this, dataObserver)
    }
}