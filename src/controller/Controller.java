/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.AVLNode;
import model.SolarSystem;
import model.SolarSystemTree;
import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Controller {
    public static void main(String[] args) {
         int choice;
        SolarSystemTree st = new SolarSystemTree();
        SolarSystem s1 = new SolarSystem("A1", 0.43, 6, 1.42, 0.41);
        SolarSystem s2 = new SolarSystem("B2", 0.34, 7, 1.52, 0.24);
        SolarSystem s3 = new SolarSystem("C3", 0.32, 9, 1.27, 0.45);
        SolarSystem s4 = new SolarSystem("D4", 0.32, 3, 1.25, 0.74);
        SolarSystem s5 = new SolarSystem("E5", 0.93, 5, 1.62, 0.44);
        addPlanet(s5, st);
        addPlanet(s4, st);
        addPlanet(s3, st);
        addPlanet(s2, st);
        addPlanet(s1, st);
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    addPlanet(inputPlanet(), st);
                }
                case 2 -> {
                    searchPlanetByMass(st);
                }
                case 3 -> {
                    deletePlanet(st);
                }
                case 4 -> {
                    viewAllSolarSystemInf(st);
                }
                case 5 ->
                    System.exit(0);
            }
        }
    }
    
    public static void addPlanet(SolarSystem ss, SolarSystemTree ssTree){
        ssTree.insert(ss);
    }
    
    public static SolarSystem inputPlanet(){
        System.out.print("Enter name: ");
        String name = InputUtils.inputName();
        System.out.print("Enter equatorial diameter: ");
        double ed = InputUtils.inputDouble();
        System.out.print("Enter mass: ");
        double mass = InputUtils.inputDouble();
        System.out.print("Enter semi major axis: ");
        double sma = InputUtils.inputDouble();
        System.out.print("Enter orbital period: ");
        double op = InputUtils.inputDouble();
        SolarSystem ss = new SolarSystem(name, ed, mass, sma, op);
        return ss;
    }
    
    public static void viewAllSolarSystemInf(SolarSystemTree ssTree){
        ssTree.displaySolarSystemInf(ssTree.getRoot());
    }
    
    public static AVLNode<SolarSystem> searchPlanetByMass(SolarSystemTree ssTree){
        System.out.println("Enter mass: ");
        double mass = InputUtils.inputDouble();
        SolarSystem ss = new SolarSystem(null,0, mass, 0, 0);
        AVLNode<SolarSystem> result = ssTree.search(ssTree.getRoot(), ss);
        if (result!= null){
        result.toString();
        }else{
            System.out.println("not found!");
        }
        return result;
    }
    
//    public static AVLNode<SolarSystem>  searchPlanetByName(SolarSystemTree ssTree){
//        System.out.println("Enter name: ");
//        String name = InputUtils.inputName();
//        SolarSystem ss = new SolarSystem(name, 0, 0, 0, 0);
//        AVLNode<SolarSystem> result = ssTree.search(ssTree.getRoot(), ss);
//        return result;
//    }
    
    public static void deletePlanet(SolarSystemTree ssTree){
        AVLNode<SolarSystem> rs = searchPlanetByMass(ssTree);
        if(rs!= null){
            ssTree.deleteByCopying(rs.getData());
            System.out.println("Successfully.");
        }
    }
}
