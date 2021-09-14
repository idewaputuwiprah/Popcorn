package com.idputuwiprah.core

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.model.Detail
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.repository.IPopcornRepository
import com.idputuwiprah.core.domain.usecase.PopcornInteractor
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import com.idputuwiprah.core.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.CountDownLatch

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PopcornUseCaseTest {
    private lateinit var popcornUseCase: PopcornUseCase

    @Mock private lateinit var popcornRepository: IPopcornRepository

    private val testDispatcher = TestCoroutineDispatcher()

    private val dummyRemoteMovieList = DataDummy.generateDummyRemoteMovie()
    private val dummyRemoteTvShowList = DataDummy.generateDummyRemoteTVShow()
    private val dummyMovieDetail = DataDummy.generateDummyMovieDetail()
    private val dummyTVShowDetail = DataDummy.generateDummyTVShowDetail()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        val dummyMovieResponse: Flow<Resource<List<Movie>>> = flow { emit(Resource.Success(DataDummy.generateDummyRemoteMovie())) }
        val dummyTVShowResponse: Flow<Resource<List<Movie>>> = flow { emit(Resource.Success(DataDummy.generateDummyRemoteTVShow())) }
        val dummyMovieDetailResponse: Flow<Resource<Detail>> = flow { emit(Resource.Success(DataDummy.generateDummyMovieDetail())) }
        val dummyTVShowDetailResponse: Flow<Resource<Detail>> = flow { emit(Resource.Success(DataDummy.generateDummyTVShowDetail())) }
        popcornUseCase = PopcornInteractor(popcornRepository)
        `when`(popcornRepository.getRemoteMovies()).thenReturn(dummyMovieResponse)
        `when`(popcornRepository.getRemoteTVShows()).thenReturn(dummyTVShowResponse)
        `when`(popcornRepository.getDetailMovie(dummyMovieDetail.movieId.toInt())).thenReturn(dummyMovieDetailResponse)
        `when`(popcornRepository.getDetailTVShows(dummyTVShowDetail.movieId.toInt())).thenReturn(dummyTVShowDetailResponse)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `get data from remote movie api`() = runBlocking {
        val latch = CountDownLatch(1)
        val job = launch(Dispatchers.IO) {
            popcornUseCase.getRemoteMovies().collect { response->
                response.data?.forEachIndexed { index, movies ->
                    assertThat(movies, equalTo(dummyRemoteMovieList[index]))
                }
                latch.countDown()
            }
        }

        latch.await()
        job.cancel()
        verify(popcornRepository).getRemoteMovies()
        verifyNoMoreInteractions(popcornRepository)
    }

    @Test
    fun `get data from remote tv show api`() = runBlocking {
        val latch = CountDownLatch(1)
        val job = launch(Dispatchers.IO) {
            popcornUseCase.getRemoteTVShows().collect { response->
                response.data?.forEachIndexed { index, tvShows ->
                    assertThat(tvShows, equalTo(dummyRemoteTvShowList[index]))
                }
                latch.countDown()
            }
        }

        latch.await()
        job.cancel()
        verify(popcornRepository).getRemoteTVShows()
        verifyNoMoreInteractions(popcornRepository)
    }

    @Test
    fun `get movie detail`() = runBlocking {
        val latch = CountDownLatch(1)
        val job = launch(Dispatchers.IO) {
            popcornUseCase.getDetailMovie(dummyMovieDetail.movieId.toInt()).collect { response->
                response.data?.let { movie ->
                    assertThat(movie, equalTo(dummyMovieDetail))
                }
                latch.countDown()
            }
        }
        latch.await()
        job.cancel()
        verify(popcornRepository).getDetailMovie(dummyMovieDetail.movieId.toInt())
        verifyNoMoreInteractions(popcornRepository)
    }

    @Test
    fun `get tv show detail`() = runBlocking {
        val latch = CountDownLatch(1)
        val job = launch(Dispatchers.IO) {
            popcornUseCase.getDetailTVShows(dummyTVShowDetail.movieId.toInt()).collect { response->
                response.data?.let { tvShow->
                    assertThat(tvShow, equalTo(dummyTVShowDetail))
                }
                latch.countDown()
            }
        }
        latch.await()
        job.cancel()
        verify(popcornRepository).getDetailTVShows(dummyTVShowDetail.movieId.toInt())
        verifyNoMoreInteractions(popcornRepository)
    }
}