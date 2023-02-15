/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrm.ieslaencanta.com.spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;

/**
 *
 * @author DAWTarde
 */
public class Wall {

    private Point2D position;
    int width = 7;
    int height = 2;
    private char cartoon[][] = {
        {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'},
        {'⣿', '⣿', '⣿', '⣿', '⣿', '⣿', '⣿'}
    };

    public Wall() {
        this.position = new Point2D();
    }

    public Wall(int x, int y) {
        this.position = new Point2D(x, y);
    }

    public Wall(Point2D position) {
        this.position = position;
    }

    public void Paint(Screen s) {
        char c;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                c = this.cartoon[i][j];
                s.setCharacter(this.getPosition().getX() + j,
                        this.getPosition().getY() + i,
                        new TextCharacter(c,
                                TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));

            }
        }
    }

    public boolean collission(Bullet b) {
        return true;
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
}
