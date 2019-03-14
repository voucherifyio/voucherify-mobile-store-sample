package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomersAdminViewModel(private val customersService: CustomersService) : BaseViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun fetchCustomers() {

        compositeDisposable.add(
            customersService
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                }
                .subscribe({ data ->
                }, { error ->
                })
        )
    }
}