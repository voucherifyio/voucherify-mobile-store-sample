package io.voucherify.android.sample.store.ui.customer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.customer.settings.SettingsCustomerFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminFragment
import io.voucherify.android.sample.store.utils.views.ToolbarUtils
import kotlinx.android.synthetic.main.activity_dashbobard_customer.*

class DashboardCustomerActivity : BaseActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, DashboardCustomerActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashbobard_customer)

        dashboard_customer_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard_customer_navigation_products -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_products)
                }
                R.id.dashboard_customer_navigation_orders -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_orders)
                }
                R.id.dashboard_customer_navigation_settings -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_settings)
                    val fragment = SettingsCustomerFragment.newInstance()

                    replaceFragment(
                        containerId = R.id.dashboard_customer_fragment_container,
                        fragment = fragment,
                        tag = SettingsCustomerFragment.TAG)
                }
                else -> {
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

        dashboard_customer_navigation_view.selectedItemId = R.id.dashboard_customer_navigation_products
    }
}