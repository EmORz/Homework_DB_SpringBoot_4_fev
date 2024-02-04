package com.example.Homework_DB_SpringBoot_4_fev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping("/add")
    public Album addAlbum(){

        return null;
    }

    @GetMapping("/get")
    public Iterable<Album> getAllAlbums(){
        return  albumRepository.findAll();
    }


}
