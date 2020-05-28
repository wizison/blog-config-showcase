package at.karriere.example.configshowcase.service

import at.karriere.example.configshowcase.config.BrandProfiles
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Profile(BrandProfiles.KARRIERE_AT)
@Service
class KarriereAtTimeService {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(KarriereAtTimeService::class.java)
    }

    fun getCurrentTime(): LocalDateTime = LocalDateTime.now().also {
        LOGGER.info("service '{}' called at '{}'.", javaClass.simpleName, it)
    }
}
