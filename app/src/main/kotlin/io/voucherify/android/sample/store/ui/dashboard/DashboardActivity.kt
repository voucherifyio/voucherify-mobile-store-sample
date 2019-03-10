package io.voucherify.android.sample.store.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R

class DashboardActivity : DaggerAppCompatActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, DashboardActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)
    }
}