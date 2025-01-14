package com.example.swiggyappdev

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.swiggyappdev.models.Movie
import com.example.swiggyappdev.models.MovieDetails
import com.example.swiggyappdev.models.MovieResponse
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals


@OptIn(ExperimentalCoroutinesApi::class)
class MovieViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule() // Ensures LiveData runs on the same thread

    private val testDispatcher = UnconfinedTestDispatcher() // For controlling coroutine execution

    private lateinit var movieViewModel: MovieViewModel
    private val mockMovieRepository: MovieRepository = mockk()
    private val observer: Observer<List<Movie>> = mockk(relaxed = true) // Mock LiveData observer

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher) // Set the main dispatcher for coroutines
        movieViewModel = MovieViewModel(mockMovieRepository)
        movieViewModel.movieList.observeForever(observer) // Observe LiveData for changes
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the main dispatcher
        movieViewModel.movieList.removeObserver(observer) // Clean up LiveData observer
    }

    @Test
    fun `searchMovies should update movieList LiveData on successful API response`() = runTest {
        // Arrange
        val mockMovies = listOf(
            Movie("1", "Movie 1", "2020", "Thriller", "Poster1"),
            Movie("2", "Movie 2", "2021", "Comedy", "Poster2")
        )

        coEvery { mockMovieRepository.searchMovies("query", 1) } returns MovieResponse(
            Response = "True",
            Search = mockMovies,
            totalResults = "5"
        )

        // Act
        movieViewModel.searchMovies("query")

        // Assert
        assertEquals(mockMovies, movieViewModel.movieList.value)
        verify { observer.onChanged(mockMovies) } // Verify observer was notified
    }

    @Test
    fun `searchMoviesPagination should append data to movieList LiveData`() = runTest {
        // Arrange
        val mockMovies = listOf(
            Movie("1", "Movie 1", "2020", "Thriller", "Poster1"),
            Movie("2", "Movie 2", "2021", "Comedy", "Poster2")
        )

        coEvery { mockMovieRepository.searchMovies("query", 2) } returns MovieResponse(
            Response = "True",
            Search = mockMovies,
            totalResults = "5"
        )

        // Act
        movieViewModel.searchMoviesPagination("query")

        // Assert
        assertEquals(mockMovies, movieViewModel.movieList.value)
        verify { observer.onChanged(mockMovies) } // Verify observer was notified
    }

    @Test
    fun `getMovieDetails should update movieDetails LiveData`() = runTest {
        // Arrange
        val mockDetails = MovieDetails("Galaxy", "2020", "Action", "James", "John", "Adventure","Poster")
        coEvery { mockMovieRepository.getMovieDetails("1") } returns mockDetails

        // Act
        movieViewModel.getMovieDetails("1")

        // Assert
        assertEquals(mockDetails, movieViewModel.movieDetails.value)
    }

}
