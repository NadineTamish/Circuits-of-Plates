/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eg.edu.alexu.csd.oop.game.object;

import java.awt.Color;
import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.world.Circus;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Jana Gh
 */
    public abstract class Shape implements GameObject{
    public static final int SPRITE_WIDTH = 40;
    private static final int MAX_MSTATE = 1;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    public Color color; //ig its true
    private int x;
    private int y;
    private int type;
    private boolean visible;
    private boolean horizontalOnly;

    public Shape (int posX, int posY, int type, String path){
        this.x = posX;
        this.y = posY;
        this.visible = true;
    this.type=type;
    this.horizontalOnly=false;
    
    //0 bomb 1 plate 2 ball 
try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void setHorizontal(boolean h){
        this.horizontalOnly=h;
    }
    
    public void setColour(Color c){
        color=c;
    }
    
     public Color getColour(){
        return this.color;
    }
     
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        if(Circus.getControl().contains(this) && (Circus.getClown().getX()<=0||Circus.getClown().getX()>=850))
			return;
        this.x=x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        if(Circus.getControl().contains(this))
			return;
        this.y=y;
    }

    @Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
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
        public void setVisible(boolean visible){
		this.visible = visible;
	}
}
