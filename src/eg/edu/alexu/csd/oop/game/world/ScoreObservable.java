/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.world;

/**
 *
 * @author Jana Gh
 */
public interface ScoreObservable {
    public  void addObserver(ScoreObserver observer);
    public void removeObserver(ScoreObserver observer);
    public  void notifyObservers();
}