package com.hitema.jee.services;

import com.hitema.jee.entities.Picture;

import java.util.List;

public interface PictureService {
    Picture create(Picture picture);
    Picture read(Long id);
    Picture update(Picture picture);
    void delete(Long id);
    List<Picture> readAll();
}
