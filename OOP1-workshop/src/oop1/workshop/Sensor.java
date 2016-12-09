/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.UUID;

/**
 *
 * @author Danieln Johansen
 */
public abstract class Sensor {

    private final UUID id;
    private String name;

    public Sensor(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public abstract double getCurrentValue();

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
