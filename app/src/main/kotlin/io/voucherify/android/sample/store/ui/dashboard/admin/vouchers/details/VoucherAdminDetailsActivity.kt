package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class VoucherAdminDetailsActivity: BaseActivity() {

    companion object Factory {

        const val VOUCHER_DETAILS_KEY = "voucher_admin_details_key"

        @JvmStatic
        fun createIntent(context: Context, voucher: VoucherResponse) =
            Intent(context, VoucherAdminDetailsActivity::class.java).apply {
                putExtra(VOUCHER_DETAILS_KEY, voucher)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)
        }

        setContentView(R.layout.activity_voucher_admin_details)

        val voucher = intent.getParcelableExtra<VoucherResponse>(VOUCHER_DETAILS_KEY)

        ToolbarUtils.initActionBarWithTitle(
            activity = this,
            title = "",
            backArrow = true)

        if(savedInstanceState == null) {
            addFragment(
                R.id.voucher_admin_details_fragment_container,
                VoucherAdminDetailsFragment.newInstance(voucher = voucher),
                VoucherAdminDetailsFragment.TAG)
        }
    }
}