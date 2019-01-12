/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;
import java.awt.*;

/**
 *
 * @author Mikołaj
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int gameWidth=1024;
    int gameHeight=768;
        
    int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    int xCenter=(screenWidth-gameWidth)/2;
    int yCenter=(screenHeight-gameHeight)/2;
        gWindow window=new gWindow(gameWidth,gameHeight,xCenter,yCenter);
        //CLSwitcher CLS = new CLSwitcher();
    }
    
}
