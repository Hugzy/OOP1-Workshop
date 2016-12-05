/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1.workshop.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import oop1.workshop.Backend;
import oop1.workshop.Building;
import oop1.workshop.IFrontend;

/**
 * FXML Controller class
 *
 * @author JV
 */
public class controller implements Initializable {
    
    private IFrontend backend;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backend = new Backend();
        
        backend.addBuilding(new Building("test"));
    }    
    
}
