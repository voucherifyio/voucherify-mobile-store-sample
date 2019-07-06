package io.voucherify.android.sample.store.ui.dashboard.admin.settings

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.BuildConfig
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalUser
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers.UserSwitchBottomSheetDialogFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_settings_admin.*
import kotlinx.android.synthetic.main.view_settings_user_profile.*
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
        user_profile_name_text.text = "${it.firstName} ${it.lastName}"
        user_profile_email_text.text = "${it.email}"
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_settings_admin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        render()
        setBindings()
    }

    private fun render() {

        val versionInfo = String.format(
            resources.getString(R.string.settings_version_template),
            BuildConfig.VERSION_NAME,
            BuildConfig.VERSION_CODE
        )

        settings_admin_app_version.text = versionInfo
    }

    private fun setBindings() {

        settings_admin_change_user_logout_container.setOnClickListener {
            viewModel.logout()
        }

        settings_admin_change_user_item_container.setOnClickListener {
            viewModel.switchUser()
        }

        viewModel
            .outputLocalUser()
            .observe(this, localUserObserver)

        viewModel
            .outputViewCommand()
            .subscribe {
                when (it) {
                    is SettingsAdminViewModel.ViewCommand.UserChangePicker -> {

                        val bottomSheetFragment = UserSwitchBottomSheetDialogFragment.newInstance(
                            customers = it.customers)

                        activity?.let {
                            bottomSheetFragment.show(
                                activity!!.supportFragmentManager,
                                UserSwitchBottomSheetDialogFragment.TAG
                            )
                        }
                    }
                    is SettingsAdminViewModel.ViewCommand.Logout -> {
                        activity?.let {
                            navigator.openSplashActivity(it)
                        }
                    }
                }
            }
    }
}