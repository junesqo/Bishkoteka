package kg.bishkoteka.data.remote.dto.events

data class FilterModel(
    var query: String = "",
    var category: String = "",
//    var organization: String = "",
//    var complexity: String = "",
//    var duration: String = "",
//    var price: String = "",
) : java.io.Serializable