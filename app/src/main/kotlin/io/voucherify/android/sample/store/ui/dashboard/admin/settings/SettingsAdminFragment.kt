package io.voucherify.android.sample.store.ui.dashboard.admin.settings

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.BuildConfig
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_settings_admin.*
import javax.inject.Inject

class SettingsAdminFragment : BaseFragment() {

    companion object {
        const val TAG = "SettingsAdminFragment"

        fun newInstance() = SettingsAdminFragment()
    }

    @Inject
    lateinit var viewModel: SettingsAdminViewModel

    @Inject
    lateinit var navigator: Navigator

    private val localUserObserver = Observer<LocalUser> {
        activity?.let {
            navigator.openSplashActivity(it)
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_settings_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        render()
        setBindings()
    }

    private fun render() {

        val versionInfo = String.format(
            resources.getString(R.string.settings_admin_version_template),
            BuildConfig.VERSION_NAME,
            BuildConfig.VERSION_CODE
        )

        settings_admin_app_version.text = versionInfo
    }

    private fun setBindings() {

        settings_admin_logout_button.setOnClickListener {
            viewModel.logout()
        }

        viewModel
            .outputLocalUserChanged()
            .observe(this, localUserObserver)
    }
}