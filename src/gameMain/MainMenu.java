/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

/**
 * Klasa głównego menu.&nbsp; Przekazuje swoje parametry "do góry" do klasy gWindow, 
 * by potem w łatwy sposób ukrywać i wyświetlać pozostałe panele.
 * * @author Mikołaj
 */

public class MainMenu extends JPanel implements MouseListener {
/** Referencje do obiektu ramki*/    
public gWindow parent;  
/** W konstruktorze następuje dodanie referencji do obiektu ramki */
    public MainMenu (gWindow parent)
    {
        this.parent=parent;
        setVisible(true);
        addMouseListener(this);
    }
    /**Rysowanie tła menu*/
    @Override protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.drawImage(gInit.main_menu_bg, 0, 0, null);
    }
    /**Obsługa zdarzenia kliknięcia.&nbsp; Ponieważ implementuję interfejs, nadpisuję również pozostałe zdarzenia z MouseListenera */
    @Override public void mouseClicked(MouseEvent me)
            {
              if(me.getX()>300 && me.getX()<700 && me.getY()>613 && me.getY()<724)  System.exit(1);
              
              if(me.getX()>300 && me.getX()<700 && me.getY()>260 && me.getY()<390)  {
                setVisible(false);
                parent.NewGame.setVisible(true);
                parent.setContentPane(parent.NewGame);
              }
              
              if(me.getX()>300 && me.getX()<700 && me.getY()>443 && me.getY()<567)  {
                setVisible(false);
                parent.TT.setVisible(true);
                parent.setContentPane(parent.TT);
              }
            }
    /** Nadpisanie interfejsu MouseListener*/
    @Override public void mouseExited(MouseEvent me){}
    /** Nadpisanie interfejsu MouseListener*/
    @Override public void mouseEntered(MouseEvent me){}
    /** Nadpisanie interfejsu MouseListener*/
    @Override public void mouseReleased(MouseEvent me){}
    /** Nadpisanie interfejsu MouseListener*/
    @Override public void mousePressed(MouseEvent me){}
    
}
