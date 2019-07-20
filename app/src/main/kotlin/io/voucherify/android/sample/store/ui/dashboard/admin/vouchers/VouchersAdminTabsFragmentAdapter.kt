package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.tabs.VouchersAdminListFragment.Companion.newInstance
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.tabs.VouchersAdminListFragment.VoucherFilter.ACTIVE
import io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.tabs.VouchersAdminListFragment.VoucherFilter.ALL

class VouchersAdminTabsFragmentAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val tabTitles = listOf(
        R.string.vouchers_admin_all_tab_title,
        R.string.vouchers_admin_active_tab_title
    )

    override fun getCount(): Int {
        return tabTitles.count()
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> newInstance(ALL)
            1 -> newInstance(ACTIVE)
            else -> {
                throw AssertionError(String.format("Unknown %s '%s'.", "VouchersAdminTabsFragmentAdapter", position))
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(tabTitles.get(position))
    }
}