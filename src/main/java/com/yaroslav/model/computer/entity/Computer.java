package com.yaroslav.model.computer.entity;

import com.yaroslav.model.computer.enums.OperationSystem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Computer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected Long id;

    @Column(name = "price")
    protected double price;

    @Column(name = "operation_system")
    @Enumerated(EnumType.STRING)
    protected OperationSystem operationSystem;
}
