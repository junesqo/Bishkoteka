package kg.bishkoteka.data.remote.dto.events

data class FilterModel(
    var keyword: String = "",
    var category: Int = 3,
//    var organization: String = "",
//    var complexity: String = "",
//    var duration: String = "",
//    var price: String = "",
) : java.io.Serializable