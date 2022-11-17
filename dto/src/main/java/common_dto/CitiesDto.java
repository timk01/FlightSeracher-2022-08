package common_dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CitiesDto {
    private String country_code;
    private String code;
    private String name;

    public CitiesDto(String country_code, String code, String name) {
        this.country_code = country_code;
        this.code = code;
        this.name = name;
    }

    public CitiesDto(){

    }
}

