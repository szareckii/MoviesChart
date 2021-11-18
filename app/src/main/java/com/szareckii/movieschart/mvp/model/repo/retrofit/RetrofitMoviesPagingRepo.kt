package com.szareckii.movieschart.mvp.model.repo.retrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.szareckii.movieschart.mvp.model.api.IDataSource
import com.szareckii.movieschart.mvp.model.entity.Movies

/*
class RetrofitMoviesPagingRepo(private val api: IDataSource) : PagingSource<Int, Movies>() {
    override fun getRefreshKey(state: PagingState<Int, Movies>): Int? {

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movies> {
        return try {
            val nextPage = params.key ?: 1
            val response = api.getMovies(apiKey = "1", "ru", nextPage)

            LoadResult.Page(
                data = response.movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = response.page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}*/
