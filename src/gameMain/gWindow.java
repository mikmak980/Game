/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Mikołaj
 */
public class gWindow extends JFrame {
    
        public gWindow(int width, int height, int x, int y)
    {
        super();
        gInit.loadData();
        setSize(width, height);
        setLocation(x,y);
        setResizable(false);
        setUndecorated(true);
        //setLayout(new CLSwitcher());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //initNewGame();
        //initTutorial();
        //initMainMenu();
    }
    
    
    private void initNewGame()
    {
        gPanel GPanel = new gPanel(this);
        GPanel.setFocusable(true);
        GPanel.requestFocusInWindow();
        add(GPanel);
        setVisible(true);
            while (gInit.lives!=0)
                {
                    gLevel s = new gLevel();
                    repaint();
                    s=null;
                }    
    }
    
    private void initTutorial()
    {
        Tutorial t = new Tutorial(this);
        t.setFocusable(true);
        t.requestFocusInWindow();
        add(t);
        setVisible(true);
    }
    
    private void initMainMenu()
    {
        MainMenu MM = new MainMenu(this);
        MM.setFocusable(true);
        MM.requestFocusInWindow();
        add(MM);
        setVisible(true);
    }
}
