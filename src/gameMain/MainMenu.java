/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mikołaj
 */
public class MainMenu extends JPanel implements MouseListener {
public gWindow parent;    
    public MainMenu (gWindow parent)
    {
        this.parent=parent;
        addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.drawImage(gInit.main_menu_bg, 0, 0, null);
    }
    
    @Override public void mouseClicked(MouseEvent me)
            {
              if(me.getX()>300 && me.getX()<700 && me.getY()>613 && me.getY()<724)  System.exit(1);
              
              if(me.getX()>300 && me.getX()<700 && me.getY()>260 && me.getY()<390)  {
                setVisible(false);
                //parent.gPanel.setVisible(true);
                //parent.setContentPane(parent.NewGame);
              }
            }
    
    @Override public void mouseExited(MouseEvent me){}
    @Override public void mouseEntered(MouseEvent me){}
    @Override public void mouseReleased(MouseEvent me){}
    @Override public void mousePressed(MouseEvent me){}
    
}
