package com.synertechnetwork.event

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@EnableAsync
@EnableScheduling
@SpringBootApplication
class EventApplication

fun main(args: Array<String>) {
	runApplication<EventApplication>(*args)
}

