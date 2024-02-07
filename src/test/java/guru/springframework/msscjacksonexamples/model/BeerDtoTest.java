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
        String jsonString = "{\"id\":\"35040a3f-9a63-410c-addc-b8fd1ad63026\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123456789,\"price\":12.99,\"createdDate\":\"2024-02-07T11:28:01.305818911+01:00\",\"lastUpdatedDate\":\"2024-02-07T11:28:01.306154416+01:00\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        log.info("DTO Beer: {}", beerDto);
    }
}