package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Place;
import com.taxi_brousse.project.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Optional<Place> getPlaceById(Integer id) {
        return placeRepository.findById(id);
    }

    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(Integer id, Place place) {
        if (placeRepository.existsById(id)) {
            place.setIdPlace(id);
            return placeRepository.save(place);
        }
        return null;
    }

    public void deletePlace(Integer id) {
        placeRepository.deleteById(id);
    }
}
