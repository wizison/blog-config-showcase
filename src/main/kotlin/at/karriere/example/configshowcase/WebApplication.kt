package at.karriere.example.configshowcase

import at.karriere.example.configshowcase.config.BrandProfiles
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.core.env.ConfigurableEnvironment

@SpringBootApplication
class WebApplication(private val env: ConfigurableEnvironment) : InitializingBean {
    override fun afterPropertiesSet() {
        if (env.activeProfiles.all { it != BrandProfiles.KARRIERE_AT && it != BrandProfiles.JOBS_AT }) {
            throw RuntimeException("Cannot find brand profile!")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}
