package pl.stojeckilukasz.geolocation.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.stojeckilukasz.geolocation.dto.DeviceDTO;
import pl.stojeckilukasz.geolocation.model.Device;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mapping(target = "name", source = "name")
    DeviceDTO toDeviceDto(Device device);
}
