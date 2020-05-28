package at.karriere.example.configshowcase.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("config-show-case")
class ConfigShowCaseProperties(
        /**
         * A simple welcome message
         */
        val welcomeMessage: String
)
