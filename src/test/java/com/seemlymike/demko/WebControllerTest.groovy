package com.seemlymike.demko

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration
class WebControllerTest extends Specification {

    @Autowired
    private MockMvc mvc
    @Autowired
    private EventsRepo eventsRepo


    def "should return list of events"() {
        given:
        eventsRepo.save(Event.create(UUID.randomUUID().toString(),"title"))
        when:
        def result = mvc.perform(get("/events"))
        then:
        result
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.events').exists())
                .andExpect(jsonPath('$.events[*].id').isNotEmpty())
    }
}
