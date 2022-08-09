package com.example.zupper.repository;

import com.example.zupper.model.Zupper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZupperRepository  extends JpaRepository<Zupper, Long> {
}
