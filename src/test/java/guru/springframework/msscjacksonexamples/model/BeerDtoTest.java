package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@Slf4j
@JsonTest
class BeerDtoTest extends Base {
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        log.info("JSON String: {}", jsonString);
    }

    @Test
    void testDeserializeJson() throws JsonProcessingException {
        String jsonString = """
                {"beerId":"8a8d653d-5f30-492d-8ee2-68508990a005","beerName":"BeerName","beerStyle":"Ale","upc":123456789,"price":12.99,"createdDate":"2024-02-07T11:57:12+0100","lastUpdatedDate":"2024-02-07T11:57:12.82097965+01:00"}
                """;

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        log.info("DTO Beer: {}", beerDto);
    }
}