package io.voucherify.android.sample.store.ui.dashboard.admin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.dashboard.admin.customers.CustomersAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.products.ProductsAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.SettingsAdminFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.VouchersAdminFragment
import io.voucherify.android.sample.store.utils.views.ToolbarUtils
import kotlinx.android.synthetic.main.activity_dashboard_admin.*

class DashboardAdminActivity : DaggerAppCompatActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, DashboardAdminActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard_admin)

        dashboard_admin_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dashboard_admin_navigation_vouchers -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_vouchers)
                    val fragment = VouchersAdminFragment.newInstance()
                    add(fragment = fragment, withTag = VouchersAdminFragment.TAG)
                }
                R.id.dashboard_admin_navigation_customers -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_customers)
                    val fragment = CustomersAdminFragment.newInstance()
                    add(fragment = fragment, withTag = CustomersAdminFragment.TAG)
                }
                R.id.dashboard_admin_navigation_products -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_products)
                    val fragment = ProductsAdminFragment.newInstance()
                    add(fragment = fragment, withTag = ProductsAdminFragment.TAG)
                }
                R.id.dashboard_admin_navigation_settings -> {
                    ToolbarUtils.initActionBarWithTitle(activity = this, titleRes = R.string.title_settings)
                    val fragment = SettingsAdminFragment.newInstance()
                    add(fragment = fragment, withTag = SettingsAdminFragment.TAG)
                }
                else -> {
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

        dashboard_admin_navigation_view.selectedItemId = R.id.dashboard_admin_navigation_vouchers
    }

    private fun add(fragment: Fragment, withTag: String) {

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.dashboard_admin_fragment_container, fragment, withTag)
            .commit()
    }
}