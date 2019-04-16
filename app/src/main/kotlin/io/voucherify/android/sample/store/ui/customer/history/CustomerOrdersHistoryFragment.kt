package io.voucherify.android.sample.store.ui.customer.history

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_orders_history.*
import javax.inject.Inject

class CustomerOrdersHistoryFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomerOrdersHistoryFragment"

        fun newInstance() = CustomerOrdersHistoryFragment()
    }

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var viewModel: CustomerOrdersHistoryViewModel

    private val ordersAdapter = CustomerOrdersHistoryAdapter(itemClick = { item ->
        activity?.let {
            navigator.openCustomerOrderHistoryDetialsActivity(context = it, localOrder = item)
        }
    })

    private val dataObserver = Observer<List<LocalOrder>> { orders ->
        ordersAdapter.setData(orders)
        ordersAdapter.notifyDataSetChanged()
    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_orders_history

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchOrders()
    }

    private fun setViews() {
        orders_history_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        orders_history_list.adapter = ordersAdapter
    }

    private fun setBindings() {

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outputLocalOrders()
            .observe(this, dataObserver)
    }
}