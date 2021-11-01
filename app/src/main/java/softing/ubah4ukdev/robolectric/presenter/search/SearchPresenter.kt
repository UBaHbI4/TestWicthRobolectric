package softing.ubah4ukdev.robolectric.presenter.search

import retrofit2.Response
import softing.ubah4ukdev.robolectric.model.SearchResponse
import softing.ubah4ukdev.robolectric.repository.GitHubRepository
import softing.ubah4ukdev.robolectric.repository.GitHubRepository.GitHubRepositoryCallback
import softing.ubah4ukdev.robolectric.view.search.ViewSearchContract

/**
 *   Project: Robolectric
 *
 *   Package: softing.ubah4ukdev.robolectric.presenter.search
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
internal class SearchPresenter internal constructor(
    private val repository: GitHubRepository
) : PresenterSearchContract, GitHubRepositoryCallback {

    private var viewContract: ViewSearchContract? = null

    override fun searchGitHub(searchQuery: String) {
        viewContract?.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun onAttach(viewContract: ViewSearchContract) {
        this.viewContract = viewContract
    }

    override fun onDetach() {
        viewContract = null
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        viewContract?.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                viewContract?.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                viewContract?.displayError("Search results or total count are null")
            }
        } else {
            viewContract?.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        viewContract?.displayLoading(false)
        viewContract?.displayError()
    }
}