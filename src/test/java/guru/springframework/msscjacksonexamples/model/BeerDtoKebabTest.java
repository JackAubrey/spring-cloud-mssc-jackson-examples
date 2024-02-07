package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@Slf4j
@JsonTest
class BeerDtoKebabTest extends Base {
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
                  "beerId" : "beba3d65-d217-469a-8831-3a4d69950bdb",
                  "beer-name" : "BeerName",
                  "beer-style" : "Ale",
                  "upc" : 123456789,
                  "price" : 12.99,
                  "created-date" : "2024-02-07T12:03:06+0100",
                  "last-updated-date" : "2024-02-07T12:03:06.94512635+01:00",
                  "my-local-date" : "20240207"
                }
                """;

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        log.info("DTO Beer: {}", beerDto);
    }
}