package com.tech5.test.people.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tech5.test.people.data.mapper.toPerson
import com.tech5.test.people.domain.model.Person

class PersonPagingSource(
    private val personApi: PersonApi
) : PagingSource<Int, Person>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        val page = params.key ?: 1
        return try {
            val response = personApi.getPopularPeople(page = page)
            val people = response.results?.map { it.toPerson() } ?: emptyList()
            LoadResult.Page(
                data = people,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (people.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Person>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
