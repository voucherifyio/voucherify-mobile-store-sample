package io.voucherify.android.sample.store.ui.customer.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.voucherify.android.sample.store.R
import io.voucherify.android.sample.store.ui.base.BaseActivity
import io.voucherify.android.sample.store.ui.customer.shoppingcart.list.ShoppingCartListFragment
import io.voucherify.android.sample.store.utils.views.ToolbarUtils

class ShoppingCartActivity : BaseActivity() {

    companion object Factory {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, ShoppingCartActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_shopping_cart)

        ToolbarUtils.initActionBarWithTitle(
            activity = this,
            titleRes = R.string.title_shopping_cart,
            backArrow = true
        )

        if (savedInstanceState == null) {
            addFragment(
                R.id.shopping_cart_fragment_container,
                ShoppingCartListFragment.newInstance(),
                ShoppingCartListFragment.TAG
            )
        }
    }

}