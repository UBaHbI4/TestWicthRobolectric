package softing.ubah4ukdev.robolectric.presenter.search

import softing.ubah4ukdev.robolectric.presenter.PresenterContract
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
internal interface PresenterSearchContract : PresenterContract<ViewSearchContract> {
    fun searchGitHub(searchQuery: String)
}