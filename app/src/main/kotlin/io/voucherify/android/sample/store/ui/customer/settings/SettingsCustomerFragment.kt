package io.voucherify.android.sample.store.ui.customer.settings

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.voucherify.android.sample.store.BuildConfig
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.local.model.LocalCustomer
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import kotlinx.android.synthetic.main.fragment_settings_customer.*
import javax.inject.Inject

class SettingsCustomerFragment : BaseFragment() {

    companion object {
        const val TAG = "SettingsCustomerFragment"

        fun newInstance() = SettingsCustomerFragment()
    }

    @Inject
    lateinit var viewModel: SettingsCustomerViewModel

    @Inject
    lateinit var navigator: Navigator

    private val localCustomerObserver = Observer<LocalCustomer?> { customer ->
        activity?.let { activity ->
            if (customer == null) {
                navigator.openDashboardAdminActivity(activity)
            }
        }
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_settings_customer

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

        settings_customer_app_version.text = versionInfo
    }

    private fun setBindings() {

        settings_customer_change_to_admin_item_container.setOnClickListener {
            viewModel.switchToAdmin()
        }

        viewModel
            .outputLocalCustomerChanged()
            .observe(this, localCustomerObserver)
    }
}