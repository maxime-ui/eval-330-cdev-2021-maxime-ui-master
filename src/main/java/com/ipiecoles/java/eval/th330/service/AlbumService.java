package com.ipiecoles.java.eval.th330.service;

import com.ipiecoles.java.eval.th330.model.Album;
import com.ipiecoles.java.eval.th330.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


    public Album creerAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
