package pl.stojeckilukasz.geolocation.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stojeckilukasz.geolocation.dto.DeviceCreateDto;
import pl.stojeckilukasz.geolocation.dto.DeviceDTO;
import pl.stojeckilukasz.geolocation.exception.ConflictException;
import pl.stojeckilukasz.geolocation.exception.NotFoundException;
import pl.stojeckilukasz.geolocation.service.DeviceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/geolocation")
public class DeviceController {

    private DeviceService deviceService;


    @GetMapping("/devices")
    @ResponseStatus(HttpStatus.OK)
    public List<DeviceDTO> getDevices() {
        return deviceService.getAllDevices();

    }

    @PostMapping("/addDevice")
    public ResponseEntity<String> create(@RequestBody DeviceCreateDto deviceDTO) throws ConflictException {
        deviceService.add(deviceDTO);
        return new ResponseEntity<>("Device created successful", HttpStatus.CREATED);

    }

    @GetMapping(value = "/device/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceDTO getById(@PathVariable("id") Long id) throws NotFoundException {
        return deviceService.getDeviceById(id);
    }


}
