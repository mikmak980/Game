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
        initGUI();
        //setLayout(new CLSwitcher());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true); //pokaĹĽ okno
        System.out.println(gInit.lives);
    }
    
    private void initGUI(){
        //setLayout(new GridLayout(1,1)); //ustaw rozkład 
    gPanel GPanel = new gPanel(this);
    GPanel.setFocusable(true);
    GPanel.requestFocusInWindow();
    add(GPanel);
    //Tutorial t = new Tutorial(this);
    //t.setFocusable(true);
    //t.requestFocusInWindow();
    //add(t);
    //MainMenu MM = new MainMenu(this);
    //add(MM);
    }
}
