package com.businesssolutionslabtestapp.api.service

import com.businesssolutionslabtestapp.model.response.GetProvidersResponse
import io.reactivex.Single
import retrofit2.http.GET

interface BSLabTestService {

    @GET("/")
    fun getProviders(): Single<GetProvidersResponse>
}