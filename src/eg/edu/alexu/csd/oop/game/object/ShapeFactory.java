/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.object;

import java.awt.Color;
/**
 *
 * @author Jana Gh
 */
public class ShapeFactory {
  
    public static Shape createShape(String shape) {
        switch (shape) {
            case "Bomb" -> {
                return new Bomb((int)(Math.random()*1000), 0,0, "/bomb.png");
            }
            case"Bonus" ->{
                return new Bonus((int)(Math.random()*1000), 0,0, "/bonus.png");
            }
            case "Plate" -> {
                int c=(int)(1+Math.random()*3);
                Plate p= new Plate((int)(Math.random()*1000), 0,2, "/plate"+c+".png");
            switch (c) {
                case 1 -> p.setColour(Color.red);
                case 2 -> p.setColour(Color.green);
                default -> p.setColour(Color.blue);
            }
                return p;
            }
            case "Ball" -> {
                int c=(int)(1+Math.random()*3);
                Ball b= new Ball((int)(Math.random()*1000),0,2, "/ball"+c+".png");
                switch (c) {
                case 1 -> b.setColour(Color.red);
                case 2 -> b.setColour(Color.green);
                default -> b.setColour(Color.blue);
            }
                return b;
            }
           
            default -> throw new IllegalArgumentException("Invalid shape type");
        }
    }
}
