package at.karriere.example.configshowcase.config

import at.karriere.example.configshowcase.config.properties.ConfigShowCaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@EnableConfigurationProperties(ConfigShowCaseProperties::class)
@Configuration
class ConfigShowCaseConfig
