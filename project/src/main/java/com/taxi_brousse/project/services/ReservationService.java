package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Reservation;
import com.taxi_brousse.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Integer id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Integer id, Reservation reservation) {
        if (reservationRepository.existsById(id)) {
            reservation.setIdReservation(id);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }
}
