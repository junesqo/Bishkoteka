package kg.bishkoteka.core.network.paging

interface DataMapper<T> {
    fun responseToModel(): List<T>
}