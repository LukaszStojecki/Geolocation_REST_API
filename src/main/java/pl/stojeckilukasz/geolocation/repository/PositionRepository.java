package pl.stojeckilukasz.geolocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stojeckilukasz.geolocation.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
