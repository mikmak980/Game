/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;
/**
 * Klasa okna samouczka.&nbsp; Tak jak w MainMenu, również przekazuję tu parametry do klasy ramki
 * @author Mikołaj
 */
public class Tutorial extends JPanel implements  MouseListener {
    int i;
    /** Generator potrzebny do losowania przykładowych akordów*/
    Random generator = new Random(); 
    /** Referencje do obiektu ramki*/  
    public gWindow parent;   
    /** W konstruktorze następuje dodanie referencji do obiektu ramki */
    public Tutorial (gWindow parent)
    {   
    this.parent=parent;
    setVisible(false);
    addMouseListener(this);
        
    }
    
    /** Rysowanie tła*/
    @Override public void paintComponent (Graphics gs)
    {
        Graphics2D g=(Graphics2D)gs;        
        g.drawImage(gInit.tutorial, 0, 0, null);
    }
    
    /** Obsługa zdarzeń ekranu, można odtworzyć przykładowe dźwieki, a także dostępną perkusję*/
    @Override public void mouseClicked(MouseEvent me){
              if(me.getX()>60 && me.getX()<250 && me.getY()>500 && me.getY()<600)  
              {
                  i=generator.nextInt(12)+1;
                  gInit.chord[i].start();
                  try {
                    Thread.sleep(800);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                  gInit.reload(gInit.chord[i]);
              }
              if(me.getX()>327 && me.getX()<530 && me.getY()>500 && me.getY()<600)  
              {
                  i=generator.nextInt(12)+13;
                  gInit.chord[i].start();
                  try {
                    Thread.sleep(800);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                  gInit.reload(gInit.chord[i]);
              }
              if(me.getX()>611 && me.getX()<766 && me.getY()>500 && me.getY()<600)  
              {
                  gInit.kick.start();
                  try {
                    Thread.sleep(200);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                  gInit.reload(gInit.kick);
              }
              if(me.getX()>820 && me.getX()<985 && me.getY()>500 && me.getY()<600)  
              {
                  gInit.snare.start();
                  try {
                    Thread.sleep(200);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                  gInit.reload(gInit.snare);
              }
              if(me.getX()>60 && me.getX()<250 && me.getY()>663 && me.getY()<750)  
              {
                setVisible(false);
                parent.MM.setVisible(true);
                parent.setContentPane(parent.MM);
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
