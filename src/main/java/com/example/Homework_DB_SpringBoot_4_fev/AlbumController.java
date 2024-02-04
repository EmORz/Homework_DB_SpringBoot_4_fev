package com.example.Homework_DB_SpringBoot_4_fev;

import org.springframework.stereotype.Controller;

@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


}
