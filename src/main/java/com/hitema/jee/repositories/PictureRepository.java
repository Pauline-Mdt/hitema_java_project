package com.hitema.jee.repositories;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
