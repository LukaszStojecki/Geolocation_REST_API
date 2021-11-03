package pl.stojeckilukasz.geolocation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.stojeckilukasz.geolocation.dto.PositionDTO;
import pl.stojeckilukasz.geolocation.model.Device;
import pl.stojeckilukasz.geolocation.model.Position;

@Mapper(componentModel = "spring", uses = {Device.class})
public interface PositionMapper {

    @Mapping(source = "device", target = "deviceId")
    PositionDTO toPositionDTO(Position position);
}
