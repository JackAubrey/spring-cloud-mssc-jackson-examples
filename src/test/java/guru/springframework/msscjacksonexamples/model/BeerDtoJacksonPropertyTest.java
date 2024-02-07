package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("jcp")
@Slf4j
@JsonTest
class BeerDtoJacksonPropertyTest extends Base {

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        log.info("JSON String: {}", jsonString);
    }

    @Test
    void testDeserializeJson() throws JsonProcessingException {
        String jsonString = """
                {
                  "id" : "a3c0a704-d7a7-4ae3-929e-79fde2bcda6f",
                  "beer_name" : "BeerName",
                  "beer_style" : "Ale",
                  "upc" : 123456789,
                  "price" : 12.99,
                  "created_date" : "2024-02-07T11:58:05.878356784+01:00",
                  "last_updated_date" : "2024-02-07T11:58:05.878748765+01:00"
                }
                """;

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        log.info("DTO Beer: {}", beerDto);
    }
}