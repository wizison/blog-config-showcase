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

@Profile(BrandProfiles.KARRIERE_AT)
@Configuration
class KarriereAtConfig : InitializingBean {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(KarriereAtConfig::class.java)
    }

    @Bean
    fun objectMapper(): ObjectMapper = Jackson2ObjectMapperBuilder.json()
            .propertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE)
            .featuresToEnable(SerializationFeature.INDENT_OUTPUT)
            .featuresToDisable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .simpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .build()


    override fun afterPropertiesSet() {
        LOGGER.info("Brand configuration '{}' loaded.", BrandProfiles.KARRIERE_AT)
    }
}
