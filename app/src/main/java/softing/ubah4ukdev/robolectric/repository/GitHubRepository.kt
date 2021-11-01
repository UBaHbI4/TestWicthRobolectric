package softing.ubah4ukdev.robolectric.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
internal class GitHubRepository(private val gitHubApi: GitHubApi) {

    fun searchGithub(
        query: String,
        callback: GitHubRepositoryCallback
    ) {
        val call = gitHubApi.searchGithub(query)
        call?.enqueue(object : Callback<SearchResponse?> {

            override fun onResponse(
                call: Call<SearchResponse?>,
                response: Response<SearchResponse?>
            ) {
                callback.handleGitHubResponse(response)
            }

            override fun onFailure(
                call: Call<SearchResponse?>,
                t: Throwable
            ) {
                callback.handleGitHubError()
            }
        })
    }

    interface GitHubRepositoryCallback {
        fun handleGitHubResponse(response: Response<SearchResponse?>?)
        fun handleGitHubError()
    }
}