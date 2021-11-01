package softing.ubah4ukdev.robolectric.presenter.details

import softing.ubah4ukdev.robolectric.presenter.PresenterContract
import softing.ubah4ukdev.robolectric.view.details.ViewDetailsContract

/**
 *   Project: Robolectric
 *
 *   Package: softing.ubah4ukdev.robolectric.presenter.details
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
internal interface PresenterDetailsContract : PresenterContract<ViewDetailsContract> {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}