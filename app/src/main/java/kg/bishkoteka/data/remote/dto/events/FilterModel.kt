package kg.bishkoteka.data.remote.dto.events

data class FilterModel(
    var keyword: String = "",
    var category: String = "",
    var starttime: String = ""
//    var organization: String = "",
//    var complexity: String = "",
//    var duration: String = "",
//    var price: String = "",
) : java.io.Serializable