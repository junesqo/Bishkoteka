package kg.bishkoteka.ui.models

import android.provider.ContactsContract.CommonDataKinds.Organization
import kg.bishkoteka.core.network.paging.BaseDiffModel
import kg.bishkoteka.core.network.paging.DataMapper

data class EventsResponseUi(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<EventUi>,
)








