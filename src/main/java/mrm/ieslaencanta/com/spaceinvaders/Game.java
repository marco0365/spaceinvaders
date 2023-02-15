/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrm.ieslaencanta.com.spaceinvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Attribute.ROWS;

/**
 *
 * @author DAWTarde
 */
public class Game {

    //private static int frecuency;
    private static int COLUMNS;
    static int ROWS;

    private Terminal terminal;
    private Screen screen;
    private boolean exit_key;
    //private boolean key_left_pressed;
    //private boolean key_right_pressed;
    private Ship ship;
    //private final boolean key_exit;
    //private final boolean key_shoot;
    private Bullet bala;
    private Wall walls[];
    private Wall w1;
    private Wall w2;
    private Wall w3;
    private Wall w4;
    public Game() {
        //this.key_left_pressed = false;
        //this.key_right_pressed = false;
        this.exit_key = false;
        //this.key_shoot = false;
        //this.ship = new Ship(Game.COLUMNS / 2, Game.ROWS - 3);
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(this.terminal);
            this.screen.setCursorPosition(null);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        ship = new Ship(20, 20);
        bala = new Bullet(24, 19);
        
        w1= new Wall(65,15);
        w2= new Wall(45,15);
        w3= new Wall(25,15);
        w4= new Wall(5,15);
    }
    
    public void loop() throws InterruptedException {

        try {

            screen.startScreen();
            screen.clear();

            while (!this.exit_key) {
                process_input();
//se actualiza el juego
                update();
//se pinta
                paint(this.screen);

                //se procesa la entrada
                
                Thread.sleep((1 / 60) * 1000);

            }
            //al pulsar escape se cierra la ventana
            screen.close();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void update(){
        this.ship.movebullets();
    }

    private void process_input() throws IOException {
        KeyStroke keyStroke = null;
        try {
            keyStroke = screen.pollInput();

        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        //si la tecla es la de escape
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape) {
                this.exit_key = true;
            }
            if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                //this.bala.moveVertical(-1,0,24);
            }
            if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                //this.bala.moveVertical(-1,0,24);
            }
        }
    }

    private void paint(Screen s) {
        try {
            TerminalSize terminalSize = screen.getTerminalSize();
            for (int column = 0; column < terminalSize.getColumns(); column++) {
                for (int row = 0; row < terminalSize.getRows(); row++) {
                    s.setCharacter(column, row, new TextCharacter(
                            ' ',
                            TextColor.ANSI.DEFAULT,
                            TextColor.ANSI.BLACK));
                }
            }
            this.bala.paint(s);
            this.ship.paint(s);
            
            this.w1.Paint(s);
            this.w2.Paint(s);
            this.w3.Paint(s);
            this.w4.Paint(s);
            screen.refresh();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*private void update() {
        if (this.key_left_pressed) {
            this.ship.moveHorizontal(-1, 0, COLUMNS - 1);
        }
        if (this.key_right_pressed) {
            this.ship.moveHorizontal(1, 0, COLUMNS - 1);
        }
//se mueven las balas
        this.ship.moveBullets(0, ROWS);
//se dispara si se ha pulsado la tecla
        if (this.key_shoot) {
            this.ship.shoot();
        }
    }*/
}
