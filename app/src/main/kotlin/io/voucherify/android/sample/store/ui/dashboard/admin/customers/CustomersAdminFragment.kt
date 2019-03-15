package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_customers_admin.*
import javax.inject.Inject

class CustomersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomersAdminFragment"

        fun newInstance() = CustomersAdminFragment()
    }

    @Inject
    lateinit var viewModel: CustomersAdminViewModel

    private val customersAdapter = CustomerAdminAdapter()

    private val dataObserver = Observer<DataResult<List<CustomerResponse>>> { result ->
        when (result.status) {
            DataResult.Status.ERROR -> {
                Toast.makeText(activity, R.string.common_error, Toast.LENGTH_SHORT).show()
            }

            DataResult.Status.SUCCESS -> {
                result.data?.let {
                    customersAdapter.setData(it)
                    customersAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_customers_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchCustomers()
    }

    private fun setViews() {
        customers_admin_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                getDrawable(it, R.drawable.divider_transparent)
            )
        }

        customers_admin_list.adapter = customersAdapter
    }

    private fun setBindings() {

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outputCustomersDataResponse()
            .observe(this, dataObserver)
    }

}