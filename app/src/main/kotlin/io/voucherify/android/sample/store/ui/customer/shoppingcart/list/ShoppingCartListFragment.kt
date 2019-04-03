package io.voucherify.android.sample.store.ui.customer.shoppingcart.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseFragment
import io.voucherify.android.sample.store.ui.flow.Navigator
import io.voucherify.android.sample.store.utils.views.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.fragment_shopping_cart_list.*
import javax.inject.Inject

class ShoppingCartListFragment: BaseFragment() {

    companion object {
        const val TAG = "ShoppingCartListFragment"

        fun newInstance() = ShoppingCartListFragment()
    }

    @Inject
    lateinit var shoppingCartListViewModel: ShoppingCartListViewModel

    @Inject
    lateinit var navigator: Navigator

    private val shoppingCartAdapter = ShoppingCartListAdapter(object: ShoppingCartListAdapter.OnItemListener {

        override fun onItemClick(item: ShoppingCartListAdapter.ShoppingCartItemData) {
            activity?.let {
                navigator.openCustomerProductDetails(context = it, productResponse = item.productResponse)
            }
        }

        override fun onItemDelete(position: Int) {
            shoppingCartListViewModel.remove(position = position)
        }
    })

    private val dataObserver = Observer<List<ShoppingCartListAdapter.ShoppingCartItemData>> { data ->
        shoppingCartAdapter.setData(data)
        shoppingCartAdapter.notifyDataSetChanged()
    }

    override fun fragmentLayoutId(): Int = R.layout.fragment_shopping_cart_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setBindings()

        shoppingCartListViewModel.fetchItems()
    }

    private fun setViews() {
        shopping_cart_list.layoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        context?.let {
            SimpleDividerItemDecoration(
                AppCompatResources.getDrawable(it, R.drawable.divider_transparent)
            )
        }

        shopping_cart_list.adapter = shoppingCartAdapter
    }

    private fun setBindings() {

        shoppingCartListViewModel
            .outputShoppingCartItems()
            .observe(this, dataObserver)
    }
}