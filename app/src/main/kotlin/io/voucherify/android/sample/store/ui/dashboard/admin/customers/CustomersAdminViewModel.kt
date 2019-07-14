package io.voucherify.android.sample.store.ui.dashboard.admin.customers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.voucherify.android.sample.store.data.remote.api.DataResult
import io.voucherify.android.sample.store.data.service.customers.CustomersService
import io.voucherify.android.sample.store.ui.base.BaseViewModel

class CustomersAdminViewModel(private val customersService: CustomersService) : BaseViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val customersLiveData: MutableLiveData<DataResult<ArrayList<Section>>> = MutableLiveData()
    private val isLoadingLiveData = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }

    fun fetchCustomers() {

        compositeDisposable.add(
            customersService
                .list()
                .map { response ->
                    response.customers.sortedBy { it.name }
                }
                .map {customers ->
                    var sections = ArrayList<Section>()
                    var lastHeader: String? = null
                    var section = -1

                    for(customer in customers) {
                        if (lastHeader == null) {
                            section += 1
                            sections.add(CustomerHeaderSectionItem(section, customer.name?.take(1) ?: ""))
                        } else {
                            if(lastHeader != customer.name?.take(1) ?: "") {
                                section += 1
                                sections.add(CustomerHeaderSectionItem(section, customer.name?.take(1) ?: ""))
                            }
                        }

                        lastHeader = customer.name?.take(1) ?: ""
                        sections.add(CustomerSectionItem(section, customer))
                    }

                     sections
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoadingLiveData.postValue(true)
                }
                .subscribe({ customers ->
                    isLoadingLiveData.postValue(false)
                    customersLiveData.postValue(DataResult.succes(customers))
                }, { error ->
                    isLoadingLiveData.postValue(false)
                    customersLiveData.postValue(DataResult.error(error))
                })
        )
    }

    fun outputCustomersDataResponse(): LiveData<DataResult<ArrayList<Section>>> {
        return customersLiveData
    }

    fun outputIsDataLoading(): LiveData<Boolean> {
        return isLoadingLiveData
    }
}
