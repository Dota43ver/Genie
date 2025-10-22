package com.Genie.genetics.repository;

import com.Genie.genetics.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RequestRepository extends JpaRepository<Request, Long> {
    Optional<Request> findByRequestId(String requestId);
}
