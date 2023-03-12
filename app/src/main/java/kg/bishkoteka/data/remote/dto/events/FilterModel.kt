package kg.bishkoteka.data.remote.dto.events

data class FilterModel(
    var category: String = "",
    var date_departure: String = "",
    var complexity: String = "",
    var duration: String = "",
    var price_max: String = "",
) : java.io.Serializable