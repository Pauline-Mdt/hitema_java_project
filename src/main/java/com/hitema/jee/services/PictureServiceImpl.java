package com.hitema.jee.services;

import com.hitema.jee.entities.Picture;
import com.hitema.jee.repositories.PictureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    private static final Logger log = LoggerFactory.getLogger(PictureServiceImpl.class);
    private PictureRepository repository;

    public PictureServiceImpl(PictureRepository repository) {
        this.repository = repository;
    }


    @Override
    public Picture create(Picture picture) {
        return repository.save(picture);
    }

    @Override
    public Picture read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Picture update(Picture picture) {
        return repository.save(picture);
    }

    @Override
    public void delete(Long id) {
        repository.delete(read(id));
    }

    @Override
    public List<Picture> readAll() {
        return repository.findAll();
    }
}
