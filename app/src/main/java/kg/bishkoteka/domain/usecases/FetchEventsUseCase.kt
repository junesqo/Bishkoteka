package kg.bishkoteka.domain.usecases

import kg.bishkoteka.domain.repositories.EventsRepository
import javax.inject.Inject

class FetchEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    operator fun invoke(title: String?) =
        eventsRepository.fetchAllOneTimeEvents(title)
}