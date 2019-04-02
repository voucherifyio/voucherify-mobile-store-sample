package io.voucherify.android.sample.store.ui.customer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.customer.products.CustomerProductsFragment
import io.voucherify.android.sample.store.ui.customer.settings.SettingsCustomerFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.ToolbarUtils
import kotlinx.android.synthetic.main.activity_dashbobard_customer.*
import javax.inject.Inject

class DashboardCustomerActivity : BaseActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, DashboardCustomerActivity::class.java)
    }

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashbobard_customer)

        initActionBar(this)

        dashboard_customer_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard_customer_navigation_products -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_products)

                    replaceFragment(
                        containerId = R.id.dashboard_customer_fragment_container,
                        fragment = CustomerProductsFragment.newInstance(),
                        tag = SettingsCustomerFragment.TAG)
                }
                R.id.dashboard_customer_navigation_orders -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_orders)
                }
                R.id.dashboard_customer_navigation_settings -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_settings)

                    replaceFragment(
                        containerId = R.id.dashboard_customer_fragment_container,
                        fragment = SettingsCustomerFragment.newInstance(),
                        tag = SettingsCustomerFragment.TAG)
                }
                else -> {
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

        dashboard_customer_navigation_view.selectedItemId = R.id.dashboard_customer_navigation_products
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