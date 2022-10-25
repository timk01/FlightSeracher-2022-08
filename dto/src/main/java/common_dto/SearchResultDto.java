package common_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")*/
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormatter.ISO_DATE_TIME)
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormatter.ISO_DATE_TIME)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //private LocalDate localDate;

    /*    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")*/
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate departDate;

    /*    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")*/
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private int numberOfChanges;
    private long duration;
    private long distance;

    /*
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
     */


    /*@DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
         */
}
