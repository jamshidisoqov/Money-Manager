package uz.uni_team.money_manager.domain.monem

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.uni_team.money_manager.data.models.dto.monem.MonemDto
import uz.uni_team.money_manager.data.repository.monem.MonemRepository
import java.util.Date

@ViewModelScoped
class MonemDataSource constructor(
    private val repository: MonemRepository,
    private val categoryIds: List<Int>,
    private val query: String,
    private val startDate: Date?,
    private val endDate: Date?
) : PagingSource<Int, MonemDto>() {
    override fun getRefreshKey(state: PagingState<Int, MonemDto>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MonemDto> {
        val page = params.key ?: PAGING_FIRST_POSITION
        return try {
            withContext(Dispatchers.IO) {
                val result = repository.getAllMonemTransactions(
                    categoryIds = categoryIds,
                    query = query,
                    startDate = startDate,
                    endDate = endDate,
                    page = page,
                    pageSize = PAGE_SIZE
                )
                LoadResult.Page(
                    data = result,
                    prevKey = if (page == PAGING_FIRST_POSITION) null else page - 1,
                    nextKey = if (result.isEmpty()) null else page + 1
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val PAGING_FIRST_POSITION = 1
        const val PAGE_SIZE = 15
    }
}