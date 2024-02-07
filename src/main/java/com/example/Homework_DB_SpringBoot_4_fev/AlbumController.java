package com.example.Homework_DB_SpringBoot_4_fev;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/albums")
public class AlbumController {

    private final AlbumRepository albumRepository;

    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;

    public AlbumController(AlbumRepository albumRepository, GenreRepository genreRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.artistRepository = artistRepository;
    }

    @PostMapping("/add")
    public String addAlbum(@RequestParam String title, @RequestParam Integer year,
                          @RequestParam Double price, @RequestParam Integer numberOfSong,
                          @RequestParam String genre, @RequestParam String name,
                          @RequestParam String nationality, @RequestParam Integer yearOfBirth){
        Album album = new Album();
        album.setTitle(title);
        album.setYear(year);
        album.setPrice(price);
        album.setNumberOfSongs(numberOfSong);

        boolean[] isGenreExist = {false};
        genreRepository.findAll().iterator()
                .forEachRemaining(genre1 -> {
                    if (genre1.getName().contains(genre)){
                        isGenreExist[0] = true;
                        album.setGenre(genre1);
                        return;
                    }
                });

        if (!isGenreExist[0]){
            Genre newGenre = new Genre();
            newGenre.setName(genre);
            genreRepository.save(newGenre);
            album.setGenre(newGenre);
        }
        List<Album> albumList = new ArrayList<>();
        albumList.add(album);
        Artist artist = new Artist();
        artist.setName(name);
        artist.setNationality(nationality);
        artist.setYearOfBirth(yearOfBirth);
        artist.setAlbums(albumList);

        artist.getAlbums().add(album);

        albumRepository.save(album);

        artistRepository.save(artist);

        return "redirect:/";
    }

    @GetMapping("/get")
    public Iterable<Album> getAllAlbums(Model model){
        Iterable<Album> albums = albumRepository.findAll();

        model.addAttribute("albums", albums);
        return  albums;
    }




}
