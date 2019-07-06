package io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import kotlinx.android.synthetic.main.item_user_switch.view.*

class UserSwitchItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var item: CustomerResponse? = null
        set(value) {
            field = value

            view.item_user_switch_name.text = value?.name ?: value?.id
            view.item_user_switch_role.text = view.resources.getString(R.string.settings_switch_user_role_name)
        }
}