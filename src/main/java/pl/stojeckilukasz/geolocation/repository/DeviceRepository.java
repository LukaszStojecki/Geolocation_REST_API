package pl.stojeckilukasz.geolocation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stojeckilukasz.geolocation.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    boolean existsByName(String name);
}
