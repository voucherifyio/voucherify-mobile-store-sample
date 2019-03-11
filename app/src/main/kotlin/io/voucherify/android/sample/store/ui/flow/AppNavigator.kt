package io.voucherify.android.sample.store.ui.flow

import android.content.Context
import android.content.Intent
import io.voucherify.android.sample.store.ui.dashboard.admin.DashboardAdminActivity
import io.voucherify.android.sample.store.ui.login.LoginActivity

class AppNavigator : Navigator {

    companion object {
        private const val FLAGS_HOME_CLEAR_STACK = Intent.FLAG_ACTIVITY_SINGLE_TOP or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK
    }

    override fun openLoginActivity(context: Context) {
        context.startActivity(createLoginActivityIntent(context))
    }

    override fun openDashboardAdminActivity(context: Context) {
        context.startActivity(DashboardAdminActivity.createIntent(context).addFlags(FLAGS_HOME_CLEAR_STACK))
    }

    private fun createLoginActivityIntent(context: Context) = LoginActivity.createIntent(context)
        .apply {
            addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
            )
        }

}