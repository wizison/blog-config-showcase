package at.karriere.example.configshowcase.data

import java.time.LocalDateTime

data class MessageResponse(val message: String,
                           val currentProfiles: String,
                           val currentDate: LocalDateTime = LocalDateTime.now())
