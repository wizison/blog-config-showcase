package at.karriere.example.configshowcase.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Profile(BrandProfiles.JOBS_AT)
@Configuration
class JobsAtConfig : InitializingBean {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(JobsAtConfig::class.java)
    }

    @Bean
    fun objectMapper(): ObjectMapper = Jackson2ObjectMapperBuilder.json()
            .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
            .featuresToEnable(SerializationFeature.INDENT_OUTPUT)
            .featuresToDisable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .simpleDateFormat("yyyy-MM-dd HH:mm")
            .build()


    override fun afterPropertiesSet() {
        LOGGER.info("Brand configuration '{}' loaded.", BrandProfiles.JOBS_AT)
    }
}
