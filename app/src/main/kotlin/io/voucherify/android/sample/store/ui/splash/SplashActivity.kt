package io.voucherify.android.sample.store.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.flow.Navigator
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {

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
        viewModel.outputUserLogged().observe(this, Observer<Boolean> { isUserLogged ->

            if (isUserLogged) {
                appNavigator.openDashboardActivity(this)
            } else {
                appNavigator.openLoginActivity(this)
            }
        })
    }
}