package uz.uni_team.money_manager.data.models.dto.category

data class CategoryDto(
    val id: Int,
    val categoryName: String,
    val parentId: Int?,
    val childCategories: List<Long>,
    val accountId: Int
)
