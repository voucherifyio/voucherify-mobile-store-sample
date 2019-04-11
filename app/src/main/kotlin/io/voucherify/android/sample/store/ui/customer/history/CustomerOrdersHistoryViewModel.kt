package io.voucherify.android.sample.store.ui.customer.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.local.model.LocalOrder
import io.voucherify.android.sample.store.data.service.orders.OrdersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerOrdersHistoryViewModel(private val ordersService: OrdersService) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val ordersLiveData: MutableLiveData<List<LocalOrder>> = MutableLiveData()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun fetchOrders() {

        compositeDisposable.add(
            ordersService
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.value = true
                }
                .subscribe({ orders ->
                    isLoadingLiveData.postValue(false)
                    ordersLiveData.postValue(orders)
                }, {
                    isLoadingLiveData.value = false
                })
        )
    }

    fun outputLocalOrders(): LiveData<List<LocalOrder>> {
        return ordersLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}
