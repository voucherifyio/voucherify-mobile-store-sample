package io.voucherify.android.sample.store.ui.dashboard.admin.settings.pickers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse

class UserSwitchAdapter(private val itemClick: (item: CustomerResponse) -> Unit) : RecyclerView.Adapter<UserSwitchItemViewHolder>() {

    private var items: List<CustomerResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSwitchItemViewHolder =
        UserSwitchItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_swtich, parent, false)
        )

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: UserSwitchItemViewHolder, position: Int) {
        holder.item = items[position]

        holder.view.setOnClickListener {
           itemClick(items[position])
        }
    }

    fun setData(data: List<CustomerResponse>) {
        items = data
    }
}