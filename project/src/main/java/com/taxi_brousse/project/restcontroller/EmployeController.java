package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Employe;
import com.taxi_brousse.project.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return ResponseEntity.ok(employes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Integer id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        return employe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return ResponseEntity.ok(createdEmploye);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Integer id, @RequestBody Employe employe) {
        Employe updatedEmploye = employeService.updateEmploye(id, employe);
        if (updatedEmploye != null) {
            return ResponseEntity.ok(updatedEmploye);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Integer id) {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
