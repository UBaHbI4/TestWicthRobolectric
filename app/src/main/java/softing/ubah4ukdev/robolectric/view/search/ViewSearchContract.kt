package softing.ubah4ukdev.robolectric.view.search

import softing.ubah4ukdev.robolectric.model.SearchResult
import softing.ubah4ukdev.robolectric.view.ViewContract

/**
 *   Project: Robolectric
 *
 *   Package: softing.ubah4ukdev.robolectric.view.search
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
internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}