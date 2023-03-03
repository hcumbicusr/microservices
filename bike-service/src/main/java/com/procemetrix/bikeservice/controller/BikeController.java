package com.procemetrix.bikeservice.controller;

import com.procemetrix.bikeservice.entity.Bike;
import com.procemetrix.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id) {
        Bike Bike = bikeService.getBikeById(id);
        if (Bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Bike);
    }

    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike bike) {
        Bike bikeNew = bikeService.save(bike);
        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("/byuser/{userid}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userid") int userid) {
        List<Bike> bikes = bikeService.byUserById(userid);
        //if (bikes.isEmpty())
        //    return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bikes);
    }
}
