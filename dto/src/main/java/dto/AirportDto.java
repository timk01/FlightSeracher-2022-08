package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {
    @JsonProperty(value = "city_code")
    private String cityCode;
    @JsonProperty(value = "country_code")
    private String countryCode;
    private String code;
    private String name;

    private boolean flightable;
    @JsonProperty(value = "iata_type")
    private String iataType;
}
