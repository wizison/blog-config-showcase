package at.karriere.example.configshowcase.web

import at.karriere.example.configshowcase.config.properties.ConfigShowCaseProperties
import at.karriere.example.configshowcase.data.MessageResponse
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message", produces = [MediaType.APPLICATION_JSON_VALUE])
class MessageController(private val configShowCaseProperties: ConfigShowCaseProperties, private val environment: ConfigurableEnvironment) {

    @GetMapping
    fun showMessage(): MessageResponse {
        return MessageResponse(configShowCaseProperties.welcomeMessage, environment.activeProfiles.joinToString(","))
    }
}
