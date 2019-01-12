/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Mikołaj
 */
public class MainMenu extends JPanel {
public gWindow parent;    
    public MainMenu (gWindow parent)
    {
        this.parent=parent;
        addMouseListener(new MouseAdapter()
        {
        public void mouseClicked(MouseEvent me){
              if(me.getX()>300 && me.getX()<700 && me.getY()>613 && me.getY()<724)  System.exit(1);
              
              if(me.getX()>300 && me.getX()<700 && me.getY()>260 && me.getY()<390)  {
              setVisible(false);
              
              }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.drawImage(gInit.main_menu_bg, 0, 0, null);
    }
    
    
}
