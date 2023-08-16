package com.synertechnetwork.event


import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class ShutdownService : ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

    fun initiateShutdown() {
        val exitCode = SpringApplication.exit(applicationContext, { 0 })
        System.exit(exitCode)
    }
}
