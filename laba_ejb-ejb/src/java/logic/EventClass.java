/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;

/**
 *
 * @author пк
 */
public class EventClass implements Serializable {
    
    private int count;

    public int getCount() {
        return count;
    }

    public EventClass(int count) {
        this.count = count;
    }
}
