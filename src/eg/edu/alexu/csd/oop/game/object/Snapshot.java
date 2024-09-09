/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Jana Gh
 */
public class Snapshot {
    private GameObject object;
    public Snapshot(GameObject o){
        this.object=o;
    }
    public GameObject getObject(){
        return object;
    }
}
