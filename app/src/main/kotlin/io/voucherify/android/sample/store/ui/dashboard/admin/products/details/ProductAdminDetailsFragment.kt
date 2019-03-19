package io.voucherify.android.sample.store.ui.dashboard.admin.products.details

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
import io.voucherify.android.sample.store.ui.dashboard.admin.products.ProductsAdminAdapter
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_product_details_admin.*
import kotlinx.android.synthetic.main.fragment_products_admin.*
import javax.inject.Inject

class ProductAdminDetailsFragment : BaseFragment() {

    companion object {
        const val TAG = "ProductAdminDetailsFragment"

        fun newInstance(product: ProductResponse) = ProductAdminDetailsFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable(ProductAdminDetailsActivity.PRODUCT_DETAILS_KEY, product)
            arguments = bundle
        }
    }

    @Inject
    lateinit var viewModel: ProductAdminDetailsViewModel

    private val dataObserver = Observer<ProductResponse> { result ->
        product_admin_details_id.text = result.name ?: "-"
        product_admin_details_created_at.text = result.createdAt.toString()

        skuAdapter.setData(result.skus.data)
        skuAdapter.notifyDataSetChanged()
    }

    private val skuAdapter = ProductsAdminDetailsSKUAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<ProductResponse>(ProductAdminDetailsActivity.PRODUCT_DETAILS_KEY)?.let {
            viewModel.setData(
                productDetails = it
            )
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_product_details_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()
    }

    private fun setViews() {
        product_admin_details_sku_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        product_admin_details_sku_list.adapter = skuAdapter
    }

    private fun setBindings() {

        viewModel
            .outputProductDetailsData()
            .observe(this, dataObserver)
    }
}