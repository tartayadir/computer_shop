package com.yaroslav.controller.controllers;

import com.yaroslav.controller.services.computer.ComputerService;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.model.computer.entity.Computer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
@Slf4j
public class ComputerController {

    private final ComputerService computerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Computer>> getAllCars() {

        log.info("Http method - Get, all computers");
        List<Computer> dtoList = computerService.findAll();

        return ResponseEntity.ok().body(dtoList);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> getComputer(@PathVariable Long id) throws NoSuchComputerException {

        log.info("Http method - Get, computer with id {}", id);
        Computer computer = computerService.findById(id);

        return ResponseEntity.ok().body(computer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer) {

        log.info("Http method - Post, post computer");

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentContextPath().
                path("/computer").
                toUriString());

        computer = computerService.save(computer);

        return ResponseEntity.created(uri).body(computer);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> updateComputer(@RequestBody Computer computer) throws NoSuchComputerException {

        log.info("Http method - Put, update computer with id {}", computer.getId());
        computer = computerService.update(computer);

        return ResponseEntity.ok().body(computer);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> removeComputer(@PathVariable Long id) throws NoSuchComputerException {

        log.info("Http method - Delete, delete computer with id {}", id);
        computerService.deleteById(id);


        return ResponseEntity.ok().build();
    }
}
