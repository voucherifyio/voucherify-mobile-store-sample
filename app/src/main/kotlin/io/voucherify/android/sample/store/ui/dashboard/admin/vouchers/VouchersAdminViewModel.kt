package io.voucherify.android.sample.store.ui.dashboard.admin.vouchers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.VoucherResponse
import io.voucherify.android.sample.store.data.service.vouchers.VouchersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class VouchersAdminViewModel(private val vouchersService: VouchersService) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val productsLiveData: MutableLiveData<DataResult<List<VoucherResponse>>> = MutableLiveData()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun fetchVouchers() {

        compositeDisposable.add(
            vouchersService
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ data ->
                    isLoadingLiveData.postValue(false)
                    productsLiveData.postValue(DataResult.succes(data.vouchers))
                }, { error ->
                    isLoadingLiveData.postValue(false)
                    productsLiveData.postValue(DataResult.error(error))
                })
        )
    }

    fun outputVouchersDataResponse(): LiveData<DataResult<List<VoucherResponse>>> {
        return productsLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}
