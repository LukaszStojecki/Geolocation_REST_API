package pl.stojeckilukasz.geolocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long latitude;
    private Long longitude;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;
}
