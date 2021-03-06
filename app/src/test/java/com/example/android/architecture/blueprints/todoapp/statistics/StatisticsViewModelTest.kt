package com.example.android.architecture.blueprints.todoapp.statistics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.MainCorutineRule
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class StatisticsViewModelTest {

    // Executes each task synchronnously using architecture components
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Set the main coroutines dispatcher for unit tesing
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCorutineRule()

    // Subject under text
    private lateinit var statisticsViewModel: StatisticsViewModel

    // Use a fake repository to be injected into the view model
    private lateinit var tasksRepository: FakeTestRepository

    @Before
    fun setupStatisticsViewModel() {
        // Initialise the reposotory with no tasks
        tasksRepository = FakeTestRepository()
        statisticsViewModel = StatisticsViewModel(tasksRepository)
    }

}