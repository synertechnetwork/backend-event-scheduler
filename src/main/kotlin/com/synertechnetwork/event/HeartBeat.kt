package com.synertechnetwork.event

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component


@Component
class HeartBeat {
    companion object {
        @JvmStatic
        private val log = LoggerFactory.getLogger(HeartBeat::class.java)
    }

    /*	@PostConstruct
        fun beat(){
            log.info("Beating")
        }*/

    //	Scheduled Annotation is used to defined methods that should be executed periodically
//    @Scheduled(fixedDelay = 1_000L)
//    @Scheduled(fixedRate = 1_000L, initialDelay = 2_000L)
//    @Scheduled(fixedDelayString = "1000")
//    @Scheduled(fixedDelayString = "PT1S")
//    @Scheduled(fixedDelayString = "\${heartbeat.rate}")
    @Scheduled(cron = "* * * * * *", zone = "Europe/Berlin")
    fun beat(){
        log.info("Beating...")
    }

}