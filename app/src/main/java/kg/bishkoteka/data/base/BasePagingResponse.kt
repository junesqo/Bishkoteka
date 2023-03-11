package kg.bishkoteka.data.base

data class BasePagingResponse<T>(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<T>
)

//Дефолтный запрос на пагинацию
