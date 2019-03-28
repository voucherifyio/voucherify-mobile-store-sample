package io.voucherify.android.sample.store.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.flow.Navigator
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, SplashActivity::class.java)
    }

    @Inject
    lateinit var viewModel: SplashViewModel

    @Inject
    lateinit var appNavigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        bindVMOutputs()

        Handler().postDelayed({
            viewModel.loginUserIfPossible()
        }, 500)
    }

    private fun bindVMOutputs() {
        viewModel.outputViewAction().observe(this, Observer<SplashViewModel.ViewAction> { viewAction ->

            when(viewAction) {
                SplashViewModel.ViewAction.openOnboarding -> appNavigator.openOnboardingActivity(this)
                SplashViewModel.ViewAction.openLogin -> appNavigator.openLoginActivity(this)
                SplashViewModel.ViewAction.openDashboard -> appNavigator.openDashboardAdminActivity(this)
            }
        })
    }
}