package io.voucherify.android.sample.store.data.service.customers

import io.reactivex.Flowable
import io.voucherify.android.sample.store.data.remote.api.response.ProductPageListResponse
import io.voucherify.android.sample.store.data.repository.products.ProductsRepository

class VoucherifyProductsService(private val productsRepository: ProductsRepository): ProductsService {

    override fun list(): Flowable<ProductPageListResponse> {
        return productsRepository.list()
    }

}