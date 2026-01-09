package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Employe;
import com.taxi_brousse.project.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Optional<Employe> getEmployeById(Integer id) {
        return employeRepository.findById(id);
    }

    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe updateEmploye(Integer id, Employe employe) {
        if (employeRepository.existsById(id)) {
            employe.setIdEmploye(id);
            return employeRepository.save(employe);
        }
        return null;
    }

    public void deleteEmploye(Integer id) {
        employeRepository.deleteById(id);
    }
}
