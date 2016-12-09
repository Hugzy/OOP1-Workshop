/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop;

import java.util.Date;

/**
 *
 * @author Danieln Johansen
 */
public class AirSensor extends Sensor {
    
    public AirSensor(String name){
        super(name);
    }

    @Override
    public double getCurrentValue() {
        return Math.random() * 100000;
    }
	
}
