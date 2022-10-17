package flightsearch.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class SearchResultDto {
    private String departCity; //origin
    private String arriveCity; //destination
    private String site; //gate
    private float price; //value
    private LocalDate localDateTime; //found_at
    private LocalDate departDate;
    private LocalDate returnDate;
    private int numberOfChanges;
    private long duration;
    private long distance;
}
