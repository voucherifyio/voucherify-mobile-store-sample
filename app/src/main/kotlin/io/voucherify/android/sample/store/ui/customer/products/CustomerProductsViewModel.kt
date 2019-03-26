package io.voucherify.android.sample.store.ui.customer.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.remote.api.response.ProductResponse
import io.voucherify.android.sample.store.data.service.customers.ProductsService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomerProductsViewModel(private val productsService: ProductsService) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val productsLiveData: MutableLiveData<DataResult<List<ProductResponse>>> = MutableLiveData()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun fetchProducts() {

        compositeDisposable.add(
            productsService
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ data ->
                    isLoadingLiveData.postValue(false)
                    productsLiveData.postValue(DataResult.succes(data.products))
                }, { error ->
                    isLoadingLiveData.postValue(false)
                    productsLiveData.postValue(DataResult.error(error))
                })
        )
    }

    fun outputProductsDataResponse(): LiveData<DataResult<List<ProductResponse>>> {
        return productsLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}
