package kg.bishkoteka.core.network.paging

import com.google.gson.annotations.SerializedName

data class BasePagingResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<T>
)

//Дефолтный запрос на пагинацию
