package at.karriere.example.configshowcase.web

import at.karriere.example.configshowcase.data.TimeResponse
import at.karriere.example.configshowcase.service.KarriereAtTimeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/time", produces = [MediaType.APPLICATION_JSON_VALUE])
class TimeController(private val karriereAtTimeService: KarriereAtTimeService?) {

    @GetMapping
    fun showTime(): TimeResponse = TimeResponse(karriereAtTimeService?.getCurrentTime() ?: LocalDateTime.now())
}
