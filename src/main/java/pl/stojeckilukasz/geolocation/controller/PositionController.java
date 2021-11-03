package pl.stojeckilukasz.geolocation.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stojeckilukasz.geolocation.dto.PositionCreateDTO;
import pl.stojeckilukasz.geolocation.dto.PositionDTO;
import pl.stojeckilukasz.geolocation.exception.NotFoundException;
import pl.stojeckilukasz.geolocation.service.PositionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/geolocation")
public class PositionController {

    private PositionService positionService;


    @GetMapping("/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionDTO> getPositions() {
        return positionService.getAllPosition();

    }

    @PostMapping("/addPosition")
    public ResponseEntity<String> create(@RequestBody PositionCreateDTO positionDTO) throws NotFoundException {
        positionService.addPosition(positionDTO);
        return new ResponseEntity<>("Position created successful", HttpStatus.CREATED);

    }

    @GetMapping(value = "/position/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionDTO getById(@PathVariable("id") Long id) throws NotFoundException {
        return positionService.getPosition(id);
    }

}
