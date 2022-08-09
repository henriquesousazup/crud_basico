package com.example.demo.repository;

import com.example.demo.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcidenteRepository extends JpaRepository<Acidente, Long> {
}
