package kg.bishkoteka.data.models.post.events

data class EventFilterModel(
    var keyword: String = "",
    var category: String = "",
    var starttime: String = ""
) : java.io.Serializable