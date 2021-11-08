package softing.ubah4ukdev.robolectric

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import softing.ubah4ukdev.robolectric.presenter.details.DetailsPresenter
import softing.ubah4ukdev.robolectric.view.details.ViewDetailsContract

/**
 *   Project: Robolectric
 *
 *   Package: softing.ubah4ukdev.robolectric
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
class DetailsPresenterTest {
    @Mock
    private lateinit var viewDetailsContract: ViewDetailsContract

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    //Проверим, что при вызове onIncrement запускается setCount и устанавливает верное значение
    @Test
    fun detailsPresenter_Incrementing_ReturnsTrue() {
        val presenter = DetailsPresenter(EXPECTED_DEFAULT_VALUE)
        presenter.onAttach(viewDetailsContract)
        presenter.onIncrement()
        verify(viewDetailsContract).setCount(ArgumentMatchers.eq(ACTUAL_DEFAULT_INCREMENT_VALUE))
        presenter.onDetach()
    }

    //Проверим, что при вызове onDecrement запускается setCount и устанавливает верное значение
    @Test
    fun detailsPresenter_Decrementing_ReturnsTrue() {
        val presenter = DetailsPresenter(EXPECTED_DEFAULT_VALUE)
        presenter.onAttach(viewDetailsContract)
        presenter.onDecrement()
        verify(viewDetailsContract).setCount(ArgumentMatchers.eq(ACTUAL_DEFAULT_DECREMENT_VALUE))
        presenter.onDetach()
    }

    //Проверим, что onIncrement не срабатывает и не запускает setCount, до вызова
    //presenter.onAttach
    @Test
    fun detailsPresenter_IncrementingNotWorkingBeforeAttach_ReturnsTrue() {
        val presenter = DetailsPresenter(EXPECTED_DEFAULT_VALUE)
        presenter.onIncrement()
        presenter.onAttach(viewDetailsContract)
        Mockito.verify(viewDetailsContract, times(0))
            .setCount(ArgumentMatchers.eq(ACTUAL_DEFAULT_INCREMENT_VALUE))
        presenter.onDetach()
    }

    //Проверим, что onIncrement не срабатывает и не запускает setCount, после вызова
    //presenter.onDetach
    @Test
    fun detailsPresenter_IncrementingNotWorkingAfterDetach_ReturnsTrue() {
        val presenter = DetailsPresenter(EXPECTED_DEFAULT_VALUE)
        presenter.onAttach(viewDetailsContract)
        presenter.onDetach()
        presenter.onIncrement()
        Mockito.verify(viewDetailsContract, times(0))
            .setCount(ArgumentMatchers.eq(ACTUAL_DEFAULT_INCREMENT_VALUE))
    }

    companion object {
        private const val EXPECTED_DEFAULT_VALUE = 3
        private const val ACTUAL_DEFAULT_INCREMENT_VALUE = 4
        private const val ACTUAL_DEFAULT_DECREMENT_VALUE = 2
    }
}