package pl.stojeckilukasz.geolocation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionCreateDTO {
    private Long deviceId;
    private Long latitude;
    private Long longitude;
}
