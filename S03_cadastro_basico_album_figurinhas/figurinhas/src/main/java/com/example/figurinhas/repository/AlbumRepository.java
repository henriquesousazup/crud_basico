package com.example.figurinhas.repository;

import com.example.figurinhas.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
