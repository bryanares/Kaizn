package com.brian.kaizn.features.habit_history


import com.brian.kaizn.data.repository.KaiznRepository
import com.brian.kaizn.features.habit_history.domain.model.KaiznUiEvents
import com.brian.kaizn.features.habit_history.domain.model.KaiznUiStates
import com.brian.kaizn.features.habit_history.domain.viewmodel.KaiznViewModel
import com.brian.kaizn.repository.MockKaiznRepositoryImplementation
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class KaiznViewModelTest {

    private lateinit var testRepository: KaiznRepository
    private lateinit var testViewModel: KaiznViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    val unconfinedTestDispatcher = UnconfinedTestDispatcher(StandardTestDispatcher().scheduler)

    @Before
    fun setUpTest() {
        testRepository = MockKaiznRepositoryImplementation()
        testViewModel = KaiznViewModel(
            testRepository,
            unconfinedTestDispatcher,
            unconfinedTestDispatcher,
            unconfinedTestDispatcher
        )
    }

    @Test
    fun test_test() {
//        assertEquals(2, 2 * 1)
       assertThat(false).isFalse()
    }


    @Test
    fun test_get_single_habit_return_habit_with_goal_entity_model() = runTest() {

        val states = mutableListOf<KaiznUiStates>()
        val events = mutableListOf<KaiznUiEvents>()

        backgroundScope.launch(unconfinedTestDispatcher) {
            testViewModel.getSingleHabit(1)
        }

        val result = testViewModel.kaiznUiState.value.habitId
        backgroundScope.launch(unconfinedTestDispatcher) {
            testViewModel.kaiznUiState.toList(states)
        }

        println("The states are $states")
        assertThat(states.last().isLoading).isFalse()
        assertThat(states.last().singleSelectedHabit == null).isFalse()
    }

}