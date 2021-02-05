package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import com.example.android.architecture.blueprints.todoapp.getOrAwaiteValue
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var tasksViewModel: TasksViewModel

    // Use a fake repository to be injected into the viewmodel
    private lateinit var tasksRepository: FakeTestRepository

    @Before
    fun setupViewModel() {

        tasksRepository = FakeTestRepository()
        val task1 = Task("title1", "description1")
        val task2 = Task("title2", "description2", true)
        val task3 = Task("title3", "description3", true)
        tasksRepository.addTasks(task1, task2, task3)

        tasksViewModel = TasksViewModel(tasksRepository)
    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel
//        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
//        tasksViewModel.setFiltering(TasksFilterType.ACTIVE_TASKS)
//        tasksViewModel.setFiltering(TasksFilterType.COMPLETED_TASKS)

        // Then the "Add task" action is visible
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaiteValue(), `is`(true))
    }

    @Test
    fun addNewTask_setsNewTaskEvent() {

        // Given a fresh TaskViewModel
//        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new Task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaiteValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))

//        // + Create oberver - no need for it to do anything!
//        val observer = Observer<Event<Unit>>{}
//
//        try {
//            // Observe the LiveData forever
//            tasksViewModel.newTaskEvent.observeForever(observer)
//
//            // When addiing a new Task
//            tasksViewModel.addNewTask()
//
//            // Then the new Task event is triggered
//            val value = tasksViewModel.newTaskEvent.getOrAwaiteValue()
//            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))
//        } finally {
//            // Watever happens, don't forget to remove the observer!
//            tasksViewModel.newTaskEvent.removeObserver(observer)
//        }
//
////        // When adding a new task
////        tasksViewModel.addNewTask()
//
//        // Then the new task event is triggered
//        // TODO test LiveData

    }
}