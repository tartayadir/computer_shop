package com.yaroslav.controller.services.computer.impl;


import com.yaroslav.controller.services.computer.ComputerService;
import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.model.computer.entity.Computer;
import com.yaroslav.model.computer.repository.ComputerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findById(Long id) throws NoSuchComputerException {

        if (id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        return computerRepository.findById(id).orElseThrow(
                () -> new NoSuchComputerException(format("Cannot find car with id %d", id)));
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public void deleteById(Long id) throws NoSuchComputerException {

        if (id == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        computerRepository.delete(computerRepository.findById(id).orElseThrow(
                () -> new NoSuchComputerException(format("Cannot find car with id %d", id))));
    }

    @Override
    public Computer update(Computer computer) throws NoSuchComputerException {

        if (computer.getId() == null){
            throw new IllegalArgumentException("Id cannot be null");
        }

        Long id = computer.getId();

        computerRepository.findById(id).orElseThrow(
                () -> new NoSuchComputerException(format("Cannot find car with id %d", id)));

        return computerRepository.save(computer);
    }
}
