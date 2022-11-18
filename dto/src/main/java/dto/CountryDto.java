package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)

public class CountryDto {
    private String code;
    private String name;
    private String currency;

    public CountryDto(String code, String name, String currency) {
        this.code = code;
        this.name = name;
        this.currency = currency;
    }

    public CountryDto() {
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
