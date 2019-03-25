package io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.ui.base.RoundedBottomSheetDialogFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_bottom_settings_admin_switch_user.*
import javax.inject.Inject

class UserSwitchBottomSheetDialogFragment : RoundedBottomSheetDialogFragment() {

    companion object {
        const val TAG = "UserSwitchBottomSheetDialogFragment"

        fun newInstance() = UserSwitchBottomSheetDialogFragment()
    }

    @Inject
    lateinit var viewModel: UserSwitchViewModel

    @Inject
    lateinit var navigator: Navigator

    private val userSwitchAdapter = UserSwitchAdapter(itemClick = { item ->
        activity?.let {
            viewModel.switchTo(customer = item)
            navigator.openDashboardCustomerActivity(it)
        }
    })

    private val dataObserver = Observer<DataResult<List<CustomerResponse>>> { result ->
        when (result.status) {
            DataResult.Status.ERROR -> {
                Toast.makeText(activity, R.string.common_error, Toast.LENGTH_SHORT).show()
            }

            DataResult.Status.SUCCESS -> {
                result.data?.let {
                    userSwitchAdapter.setData(it)
                    userSwitchAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private val loadingObserver = Observer<Boolean> { isLoading ->
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_settings_admin_switch_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        viewModel.fetchCustomers()
    }

    private fun setViews() {
        settings_admin_switch_user_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        settings_admin_switch_user_list.adapter = userSwitchAdapter
    }

    private fun setBindings() {

        viewModel
            .outputIsDataLoading()
            .observe(this, loadingObserver)

        viewModel
            .outputCustomersDataResponse()
            .observe(this, dataObserver)
    }
}