package com.Genie.genetics.repository;

import com.Genie.genetics.entity.Variation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface VariationRepository extends JpaRepository<Variation, Long> {
    Optional<Variation> findByVariationId(String variationId);
}
