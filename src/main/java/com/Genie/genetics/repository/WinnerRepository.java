package com.Genie.genetics.repository;

import com.Genie.genetics.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface WinnerRepository extends JpaRepository<Winner, Long> {
    Optional<Winner> findByWinnerId(String winnerId);
}
