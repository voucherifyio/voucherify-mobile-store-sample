package io.voucherify.android.sample.store.ui.customer.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_products_customer.*
import javax.inject.Inject

class CustomerProductsFragment : BaseFragment() {

    companion object {
        const val TAG = "CustomerProductsFragment"

        fun newInstance() = CustomerProductsFragment()
    }

    @Inject
    lateinit var productsViewModel: CustomerProductsViewModel

    @Inject
    lateinit var navigator: Navigator

    private val customersAdapter = CustomerProductsAdapter(itemClick = { item ->
        activity?.let {
            navigator.openCustomerProductDetails(context = it, productResponse = item)
        }
    })

    private val dataObserver = Observer<DataResult<List<ProductResponse>>> { result ->
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

    override fun fragmentLayoutId(): Int = R.layout.fragment_products_customer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        productsViewModel.fetchProducts()
    }

    private fun setViews() {
        products_customer_list.layoutManager = GridLayoutManager(
            activity,
            2,
            RecyclerView.VERTICAL,
            false
        )

        products_customer_list.adapter = customersAdapter
    }

    private fun setBindings() {

        productsViewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        productsViewModel
            .outputProductsDataResponse()
            .observe(this, dataObserver)
    }

}
