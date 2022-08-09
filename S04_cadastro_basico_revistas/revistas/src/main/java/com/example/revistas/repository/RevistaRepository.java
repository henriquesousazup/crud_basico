package com.example.revistas.repository;

import com.example.revistas.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevistaRepository extends JpaRepository<Revista, Long> {
}
