/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrm.ieslaencanta.com.spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import java.awt.Toolkit;

/**
 *
 * @author DAWTarde
 */
public class Ship {

    private Point2D position;
    private TextColor color;
    private TextColor backgroundcolor;
    private int width = 7;
    private int height = 2;
    private Bullet bullets[];
    private static int max_bullets = 3;
    private String cartoon[] = {
        " ⢀⣀⣾⣷⣀⡀ ",
        " ⣿⣿⣿⣿⣿⣿ "
    };

    public Ship() {
        this.position = new Point2D();
        this.bullets = new Bullet[Ship.max_bullets];
    }

    public Ship(Point2D position) {
        this.position = position;
        this.bullets = new Bullet[Ship.max_bullets];
    }

    public Ship(int x, int y) {
        this.position = new Point2D(x, y);
        this.bullets = new Bullet[Ship.max_bullets];
    }

    /**
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    public void moveHorizontal(int incx, int min_x, int max_x) {
        if (this.getPosition().getX() + incx - this.getWidth() / 2 >= min_x
                && this.getPosition().getX() + incx + this.getWidth() / 2 < max_x) {
            
            this.getPosition().addX(incx);
            
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void paint(Screen s) {
        char c;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                c = this.cartoon[i].charAt(j);
                s.setCharacter(this.getPosition().getX() + j,
                        this.getPosition().getY() + i,
                        new TextCharacter(c,
                                TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));

            }
        }
        for (int i= 0;i<this.bullets.length;i++){
            if(this.bullets[i] != null){
                this.bullets[i].paint(s);
            }
        }
    }
    public void movebullets(){
        for (int i= 0;i<this.bullets.length;i++){
            if (this.bullets[i] != null){
                this.bullets[i].moveVertical(-1, 0,Game.ROWS);
            }
        }
    }

    public void shoot() {
        this.bullets[0] = new Bullet(
                this.position.getX() + this.width / 2,
                this.position.getY() - 2);
    }
}
