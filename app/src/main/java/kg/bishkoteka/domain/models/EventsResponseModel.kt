package kg.bishkoteka.domain.models

import android.provider.ContactsContract.CommonDataKinds.Organization
import kg.bishkoteka.core.network.paging.BaseDiffModel

data class EventsResponseModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<EventModel>,
)