package io.voucherify.android.sample.store.ui.customer.products.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.dashboard.admin.products.details.ProductAdminDetailsFragment
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class CustomerProductDetailsActivity: BaseActivity() {

    companion object Factory {

        val PRODUCT_DETAILS_KEY = "product_details_key"

        @JvmStatic
        fun createIntent(context: Context, product: ProductResponse) =
            Intent(context, CustomerProductDetailsActivity::class.java).apply {
                putExtra(PRODUCT_DETAILS_KEY, product)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_details_customer)

        val product = intent.getParcelableExtra<ProductResponse>(PRODUCT_DETAILS_KEY)

        ToolbarUtils.initActionBarWithTitle(activity = this, title = product.name ?: "")

        if(savedInstanceState == null) {
            addFragment(
                R.id.product_details_customer_fragment_container,
                ProductAdminDetailsFragment.newInstance(product = product),
                ProductAdminDetailsFragment.TAG)
        }
    }
}