package be.movie36.repository;

import be.movie36.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScreenId(Long screenId);
    Optional<Seat> findByScreenIdAndName(Long screenId, String name);
    boolean existsByScreenId(Long screenId);
}
