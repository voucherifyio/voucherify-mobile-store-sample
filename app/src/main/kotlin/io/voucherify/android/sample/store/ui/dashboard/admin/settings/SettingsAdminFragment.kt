package io.voucherify.android.sample.store.ui.dashboard.admin.settings

import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment

class SettingsAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "SettingsAdminFragment"

        fun newInstance() = SettingsAdminFragment()
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_settings_admin

}