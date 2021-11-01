package softing.ubah4ukdev.robolectric.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import softing.ubah4ukdev.robolectric.model.SearchResponse

/**
 *   Project: Robolectric
 *
 *   Package: softing.ubah4ukdev.robolectric.repository
 *
 *   Created by Ivan Sheynmaer
 *
 *   Description:
 *
 *
 *   2021.11.01
 *
 *   v1.0
 */
internal interface GitHubApi {

    @Headers("Accept: application/vnd.github.mercy-preview+json")
    @GET("search/repositories")
    fun searchGithub(@Query("q") term: String?): Call<SearchResponse?>?
}