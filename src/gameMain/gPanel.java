/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Mikołaj
 */
public class gPanel extends JPanel implements KeyListener, MouseListener {    
public gWindow parent;   
    public gPanel (gWindow parent)
    {   
    this.parent=parent;
        gInit.restartGame();
        System.out.println(gInit.lives);
        this.setLayout(null);
        addMouseListener(this);
        addKeyListener(this);    
    }   
        
    
    
    
    @Override
    public void paintComponent (Graphics gs)
    {
        Graphics2D g=(Graphics2D)gs;        
        g.drawImage(gInit.new_game_bg, 0, 0, null);
        g.setFont(new Font("Sans", Font.BOLD, 28));
        g.setColor(Color.WHITE);
        g.drawString(Long.toString(gInit.lives), 312, 672);
        g.drawString(Long.toString(gInit.cur_LVL-1), 312, 715); 
        //gLevel.drawSteps(g);
    }
    
     
    
    
    @Override public void keyPressed (KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_A)  {
            gInit.player_beat = 1;
            gInit.kick.start();
        }
        if (e.getKeyCode()==KeyEvent.VK_D) {
            gInit.player_beat = 2;
            gInit.snare.start();
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE) gInit.GameStarted=true;

    }
    
    
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    
    
    @Override public void mouseClicked(MouseEvent me)
            {
                if(me.getX()>717 && me.getX()<937 && me.getY()>643 && me.getY()<728)  
                {
                    setVisible(false);
                    //parent.gPanel.setVisible(true);
                    //parent.setContentPane(parent.gPanel);
                }
                if(me.getX()>0 && me.getX()<512 && me.getY()>0 && me.getY()<385) gInit.player_answer="MOL";
                if(me.getX()>513 && me.getX()<1024 && me.getY()>0 && me.getY()<385) gInit.player_answer="DUR";
            }
    
    @Override public void mouseExited(MouseEvent me){}
    @Override public void mouseEntered(MouseEvent me){}
    @Override public void mouseReleased(MouseEvent me){}
    @Override public void mousePressed(MouseEvent me){}


}

