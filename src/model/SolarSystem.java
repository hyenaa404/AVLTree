/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class SolarSystem implements Comparable<SolarSystem> {
    private String name;
    private double equatorialDiameter;
    private double mass;
    private double semiMajorAxis;
    private double orbitalPeriod;

    public SolarSystem() {
    }

    public SolarSystem(String name, double equatorialDiameter, double mass, double semiMajorAxis, double orbitalPeriod) {
        this.name = name;
        this.equatorialDiameter = equatorialDiameter;
        this.mass = mass;
        this.semiMajorAxis = semiMajorAxis;
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEquatorialDiameter() {
        return equatorialDiameter;
    }

    public void setEquatorialDiameter(double equatorialDiameter) {
        this.equatorialDiameter = equatorialDiameter;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    @Override
    public String toString() {
        System.out.printf("%-20s|%-20.2f|%-15.2f|%-15.2f|%-15.2f|\n", this.name, this.equatorialDiameter,this.mass,this.semiMajorAxis, this.orbitalPeriod);
        return "";
    }

    @Override
    public int compareTo(SolarSystem o) {
        return Double.compare(this.mass, o.mass);
    }
    
}
