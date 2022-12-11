package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SearchResultDto {
    private String departCity;
    private String arriveCity;
    private String site;
    private float price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate departDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private int numberOfChanges;
    private long duration;
    private long distance;
}
