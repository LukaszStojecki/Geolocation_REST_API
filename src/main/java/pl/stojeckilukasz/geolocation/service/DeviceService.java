package pl.stojeckilukasz.geolocation.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.stojeckilukasz.geolocation.dto.DeviceCreateDto;
import pl.stojeckilukasz.geolocation.dto.DeviceDTO;
import pl.stojeckilukasz.geolocation.exception.ConflictException;
import pl.stojeckilukasz.geolocation.exception.NotFoundException;
import pl.stojeckilukasz.geolocation.mapper.DeviceMapper;
import pl.stojeckilukasz.geolocation.model.Device;
import pl.stojeckilukasz.geolocation.repository.DeviceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;
    private DeviceMapper deviceMapper;

    public DeviceDTO add(DeviceCreateDto deviceCreateDTO) throws ConflictException {
        deviceNameValidator(deviceCreateDTO);
        Device device = new Device();
        device.setName(deviceCreateDTO.getName());
        deviceRepository.save(device);
        return deviceMapper.toDeviceDto(device);
    }

    public List<DeviceDTO> getAllDevices() {
        return deviceRepository.findAll().stream()
                .map(device -> deviceMapper.toDeviceDto(device))
                .collect(Collectors.toList());
    }

    public DeviceDTO getDeviceById(Long id) throws NotFoundException {
        return deviceRepository.findById(id)
                .map(device -> deviceMapper.toDeviceDto(device))
                .orElseThrow(() -> new NotFoundException("Device of id " + id + ", doesn't exist"));
    }

    public void deviceNameValidator(DeviceCreateDto deviceDTO) throws ConflictException {
        if (deviceRepository.existsByName(deviceDTO.getName())) {
            throw new ConflictException("Device already exists");
        }
    }

}
