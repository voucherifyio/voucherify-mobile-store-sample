package io.voucherify.android.sample.store.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    @Inject
    lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var appNavigator: Navigator

    private val dataObserver = Observer<DataResult<LocalUser>> { result ->
        when (result.status) {
            DataResult.Status.ERROR -> {
                Toast.makeText(this, R.string.common_error, Toast.LENGTH_SHORT).show()
            }

            DataResult.Status.SUCCESS -> {
                appNavigator.openDashboardActivity(this)
            }
        }
    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
        btn_login_sign_in.isEnabled = !isLoading
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        setBindings()
    }

    private fun setBindings() {

        btn_login_sign_in.setOnClickListener {
            viewModel.login(
                loginOrEmail = et_login_email.text?.toString() ?: "",
                password = et_login_password.text?.toString() ?: ""
            )
        }

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outoutDataResponse()
            .observe(this, dataObserver)
    }
}