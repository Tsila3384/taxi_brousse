package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Genre;
import com.taxi_brousse.project.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Integer id, Genre genre) {
        if (genreRepository.existsById(id)) {
            genre.setIdGenre(id);
            return genreRepository.save(genre);
        }
        return null;
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
