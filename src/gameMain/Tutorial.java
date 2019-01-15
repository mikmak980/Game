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
 *
 * @author Mikołaj
 */
public class Tutorial extends JPanel implements KeyListener, MouseListener {
    int i;
    Random generator = new Random(); 
    public gWindow parent;   
    public Tutorial (gWindow parent)
    {   
    this.parent=parent;
    addMouseListener(this);
    addKeyListener(this);
        
    }
    
    @Override
    public void paintComponent (Graphics gs)
    {
        Graphics2D g=(Graphics2D)gs;        
        g.drawImage(gInit.tutorial, 0, 0, null);
    }
    
    @Override public void keyPressed (KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_A)  {
            gInit.kick.start();
                  try {
                    Thread.sleep(200);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
            gInit.reload(gInit.kick);
        }
        if (e.getKeyCode()==KeyEvent.VK_D) {
            gInit.snare.start();
                  try {
                    Thread.sleep(200);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
            gInit.reload(gInit.snare);
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE) gInit.GameStarted=true;

    }
    
    
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    
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
              if(me.getX()>60 && me.getX()<250 && me.getY()>663 && me.getY()<750)  System.exit(1);
            }
    
    @Override public void mouseExited(MouseEvent me){}
    @Override public void mouseEntered(MouseEvent me){}
    @Override public void mouseReleased(MouseEvent me){}
    @Override public void mousePressed(MouseEvent me){}
}
