package pl.stojeckilukasz.geolocation.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.stojeckilukasz.geolocation.dto.PositionCreateDTO;
import pl.stojeckilukasz.geolocation.dto.PositionDTO;
import pl.stojeckilukasz.geolocation.exception.NotFoundException;
import pl.stojeckilukasz.geolocation.mapper.PositionMapper;
import pl.stojeckilukasz.geolocation.model.Device;
import pl.stojeckilukasz.geolocation.model.Position;
import pl.stojeckilukasz.geolocation.repository.DeviceRepository;
import pl.stojeckilukasz.geolocation.repository.PositionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PositionService {

    private PositionRepository positionRepository;
    private PositionMapper positionMapper;
    private DeviceRepository deviceRepository;


    public List<PositionDTO> getAllPosition() {
        return positionRepository.findAll().stream()
                .map(position -> positionMapper.toPositionDTO(position))
                .collect(Collectors.toList());
    }

    public PositionDTO getPosition(Long id) throws NotFoundException {
        return positionRepository.findById(id)
                .map(position -> positionMapper.toPositionDTO(position))
                .orElseThrow(() -> new NotFoundException("Position of id " + id + ", doesn't exist"));
    }

    @Transactional
    public PositionDTO addPosition(PositionCreateDTO positionDTO) throws NotFoundException {
        Position position = new Position();

        Device device = deviceRepository.findById(positionDTO.getDeviceId())
                .orElseThrow(() -> new NotFoundException("Device not found"));

        position.setLatitude(positionDTO.getLatitude());
        position.setLongitude(positionDTO.getLongitude());
        position.setDevice(device);
        positionRepository.save(position);
        return positionMapper.toPositionDTO(position);
    }
}
