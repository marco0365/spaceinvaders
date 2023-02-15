/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mrm.ieslaencanta.com.spaceinvaders;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAWTarde
 */
public class Spaceinvaders {

    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.loop();
        } catch (InterruptedException ex) {
            Logger.getLogger(Spaceinvaders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
