package io.voucherify.android.sample.store.ui.customer.products.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.ToolbarUtils
import javax.inject.Inject

class CustomerProductDetailsActivity: BaseActivity() {

    companion object Factory {

        const val PRODUCT_DETAILS_KEY = "product_details_key"

        @JvmStatic
        fun createIntent(context: Context, product: ProductResponse) =
            Intent(context, CustomerProductDetailsActivity::class.java).apply {
                putExtra(PRODUCT_DETAILS_KEY, product)
            }
    }

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_details_customer)

        val product = intent.getParcelableExtra<ProductResponse>(PRODUCT_DETAILS_KEY)

        ToolbarUtils.initActionBarWithTitle(activity = this, title = product.name ?: "", backArrow = true)

        if(savedInstanceState == null) {
            addFragment(
                R.id.product_details_customer_fragment_container,
                CustomerProductDetailsFragment.newInstance(product = product),
                CustomerProductDetailsFragment.TAG)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(io.voucherify.android.sample.store.R.menu.shopping_cart_customer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_shopping_card_customer -> {
                navigator.openShoppingCardActivity(this)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}