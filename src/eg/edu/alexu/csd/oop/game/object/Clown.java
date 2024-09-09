/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javax.imageio.ImageIO;

/**
 *
 * @author Jana Gh
 */
public class Clown implements GameObject {

    private int x;
    private int y;
    private boolean visible;
    private boolean horizontalOnly;
    private static final int MAX_MSTATE = 1;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private static Clown clown = new Clown(400, 420, true, "/clown.png");
    private static CareTaker careTaker = new CareTaker();

    private Clown(int x, int y, boolean horizontalOnly, String path) {
        this.x = x;
        this.y = y;
        this.horizontalOnly = horizontalOnly;
        this.visible = true;
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));

        } catch (IOException e) {
        }
    }

    public static Clown getInstance() {
        return clown;
    }

    public static CareTaker getCareTaker() {
        return careTaker;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        if (horizontalOnly) {
            return;
        }
        this.y = y;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}
