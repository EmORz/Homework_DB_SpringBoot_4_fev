package com.example.Homework_DB_SpringBoot_4_fev;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Integer year;

    private Double price;

    private Integer numberOfSongs;

    @ManyToOne(optional = true)
    @JoinColumn(name = "genre_id", nullable = true)
    private Genre genre;

    @ManyToMany()
    private List<Artist> artist;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }



    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(Integer numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }




}
