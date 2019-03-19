package io.voucherify.android.sample.store.ui.dashboard.admin.products

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_products_admin.*
import javax.inject.Inject

class ProductsAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "ProductsAdminFragment"

        fun newInstance() = ProductsAdminFragment()
    }

    @Inject
    lateinit var viewModel: ProductsAdminViewModel

    @Inject
    lateinit var navigator: Navigator

    private val customersAdapter = ProductsAdminAdapter(itemClick = { item ->
        activity?.let {
            navigator.openProductAdminDetails(it, productResponse = item)
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

    override fun fragmentLayoutId(): Int = R.layout.fragment_products_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchProducts()
    }

    private fun setViews() {
        products_admin_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        products_admin_list.adapter = customersAdapter
    }

    private fun setBindings() {

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outputProductsDataResponse()
            .observe(this, dataObserver)
    }

}
