package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

class Base {
    @Autowired
    ObjectMapper objectMapper;

    BeerDto getBeerDto() {
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyle("Ale")
                .createdDate(OffsetDateTime.now())
                .id(UUID.randomUUID())
                .lastUpdatedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(123456789L)
                .build();
    }
}
