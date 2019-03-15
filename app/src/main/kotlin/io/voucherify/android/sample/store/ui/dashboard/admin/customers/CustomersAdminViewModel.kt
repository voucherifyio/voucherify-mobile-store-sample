package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.CustomerResponse
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomersAdminViewModel(private val customersService: CustomersService) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val customersLiveData: MutableLiveData<DataResult<List<CustomerResponse>>> = MutableLiveData()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

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
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ data ->
                    isLoadingLiveData.postValue(false)
                    customersLiveData.postValue(DataResult.succes(data.customers))
                }, { error ->
                    isLoadingLiveData.postValue(false)
                    customersLiveData.postValue(DataResult.error(error))
                })
        )
    }

    fun outputCustomersDataResponse(): LiveData<DataResult<List<CustomerResponse>>> {
        return customersLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}
