/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author пк
 */
public class Procedura {
    
    private int id_proc;
    private String name;
    private double price;
    public int getId_proc() {
        return id_proc;
    }

    public void setId_proc(int id_proc) {
        this.id_proc = id_proc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
