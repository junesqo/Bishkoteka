package kg.bishkoteka.data.models.post.events

data class RegularEventFilter(
    var keyword: String = "",
    var category: String = ""
) : java.io.Serializable
