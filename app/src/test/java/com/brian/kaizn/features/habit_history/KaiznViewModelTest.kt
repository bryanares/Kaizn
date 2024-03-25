package com.brian.kaizn.features.habit_history


import com.brian.kaizn.data.repository.KaiznRepository
import com.brian.kaizn.features.habit_history.domain.viewmodel.KaiznViewModel
import com.brian.kaizn.repository.MockKaiznRepositoryImplementation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class KaiznViewModelTest {

    private lateinit var testRepository : KaiznRepository
    private lateinit var testViewModel : KaiznViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    val unconfinedTestDispatcher = UnconfinedTestDispatcher(StandardTestDispatcher().scheduler)

    @Before
    fun setUpTest(){
        val testRepository = MockKaiznRepositoryImplementation()
        val testViewModel = KaiznViewModel(
            testRepository,
            unconfinedTestDispatcher,
            unconfinedTestDispatcher,
            unconfinedTestDispatcher
        )
    }
    @Test
    fun test_test(){
        assertEquals(2, 2*1)
    }


}