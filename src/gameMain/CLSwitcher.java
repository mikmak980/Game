/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mikołaj
 */
public class CLSwitcher extends CardLayout {
    
    int gameWidth=1024;
    int gameHeight=768;
        
    int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
    int xCenter=(screenWidth-gameWidth)/2;
    int yCenter=(screenHeight-gameHeight)/2;
    
    
    //gWindow window = new gWindow(gameWidth,gameHeight,xCenter,yCenter);
    
    //MainMenu mMenu = new MainMenu(gameWidth,gameHeight);
    //gamePanel nGame = new gamePanel(gameWidth,gameHeight);
    JPanel MainPanel = new JPanel();
    
    public CLSwitcher()
    {
        MainPanel.setLayout(this);
        
        //MainPanel.add(mMenu,"Menu");
        //MainPanel.add(nGame,"NGame");
        
        show(MainPanel,"Menu");
        //window.add(MainPanel);
    }
    
}
