package com.yaroslav.controller.services.computer;

import com.yaroslav.controller.services.exceptions.NoSuchComputerException;
import com.yaroslav.model.computer.entity.Computer;

import java.util.List;

public interface ComputerService {

    List<Computer> findAll();

    Computer findById(Long id) throws NoSuchComputerException;

    Computer save(Computer Computer);

    void deleteById(Long id) throws NoSuchComputerException;

    Computer update(Computer Computer) throws NoSuchComputerException;
}
