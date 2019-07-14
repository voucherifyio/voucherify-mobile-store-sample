package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import io.voucherify.android.sample.store.utils.views.StickyHeaderItemDecorator
import kotlinx.android.synthetic.main.fragment_customers_admin.*
import javax.inject.Inject

class CustomersAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomersAdminFragment"

        fun newInstance() = CustomersAdminFragment()
    }

    @Inject
    lateinit var viewModel: CustomersAdminViewModel

    @Inject
    lateinit var navigator: Navigator

    private val searchQueryTextListener = object: SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            customersAdapter.filter.filter(query)
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            customersAdapter.filter.filter(newText)
            return false
        }
    }

    private val customersAdapter = CustomerAdminAdapter(itemClick = { item ->
        activity?.let {
            navigator.openCustomerDetails(it, customerResponse = item)
        }
    })

    private val dataObserver = Observer<DataResult<ArrayList<Section>>> { result ->
        when (result.status) {
            DataResult.Status.ERROR -> {
                Toast.makeText(activity, io.voucherify.android.sample.store.R.string.common_error, Toast.LENGTH_SHORT).show()
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

    override fun fragmentLayoutId(): Int = io.voucherify.android.sample.store.R.layout.fragment_customers_admin

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.dashboard_admin_customers_search, menu)
        super.onCreateOptionsMenu(menu, inflater)

        val searchItem =  menu.findItem(R.id.dashboard_admin_customers_search_action)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(searchQueryTextListener)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.dashboard_admin_customers_search_action -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchCustomers()
    }

    private fun setViews() {
        customers_admin_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = RecyclerView.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                getDrawable(it, io.voucherify.android.sample.store.R.drawable.divider_transparent)
            )
        }

        customers_admin_list.adapter = customersAdapter

        val decorator = StickyHeaderItemDecorator(customersAdapter)
        decorator.attachToRecyclerView(customers_admin_list)
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