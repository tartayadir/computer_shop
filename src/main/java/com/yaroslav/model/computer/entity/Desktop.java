package com.yaroslav.model.computer.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "desktops")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Desktop extends Computer{

    @Column(name = "power_consumption")
    private double powerConsumption;
}
