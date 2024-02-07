package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@Slf4j
@JsonTest
class BeerDtoTest extends Base {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        log.info("JSON String: {}", jsonString);
    }

    @Test
    void testDeserializeJson() throws JsonProcessingException {
        String jsonString = """
                {"id":"8a8d653d-5f30-492d-8ee2-68508990a005","beerName":"BeerName","beerStyle":"Ale","upc":123456789,"price":12.99,"createdDate":"2024-02-07T11:57:12.820648305+01:00","lastUpdatedDate":"2024-02-07T11:57:12.82097965+01:00"}
                """;

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        log.info("DTO Beer: {}", beerDto);
    }
}