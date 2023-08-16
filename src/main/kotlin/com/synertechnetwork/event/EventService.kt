package com.synertechnetwork.event

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class EventService(private val publisher: ApplicationEventPublisher) {
//    Spring has different lifecycle events to hook into

    companion object{
        private val log = LoggerFactory.getLogger(EventService::class.java)
    }

    @EventListener
    fun onReady(event: ApplicationReadyEvent){
        log.info("Application is ready to start receiving request")
        publisher.publishEvent(UserSubscribedEvent("marcusdashe.developer@gmail.com"))
        log.info("Finished publishing event")
    }

    @EventListener
    fun onUserSubscribed(event: UserSubscribedEvent): UserOptInEvent{
        log.info("New subscriber: ${event.email}")
        return UserOptInEvent(event.email, confirmed = true)
    }

    @Async
    @EventListener(condition = "#event.confirmed eq true")
    fun onUserOptIn(event: UserOptInEvent){
        log.info("Subscriber Opt-in: ${event.email} - ${event.confirmed}")
        TimeUnit.SECONDS.sleep(5)
        log.info("Added ${event.email} to the newsletter!")
    }
}

data class UserSubscribedEvent(val email: String)
data class UserOptInEvent(val email: String, val confirmed: Boolean)