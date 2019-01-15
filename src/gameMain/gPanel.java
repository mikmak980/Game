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
 * Klasa głównego okna gry.&nbsp; Tak jak w MainMenu, również przekazuję tu parametry do klasy ramki.&nbsp; By przełączać panele w tym niedziałającym trybie należy odkomentować setVisible(false);
 * @author Mikołaj
 */
public class gPanel extends JPanel implements KeyListener, MouseListener {
/** Referencje do obiektu ramki*/    
public gWindow parent;
/** W konstruktorze następuje dodanie referencji do obiektu ramki */
    public gPanel (gWindow parent)
    {   
    this.parent=parent;
        //setVisible(false);
        gInit.restartGame();
        this.setLayout(null);
        addMouseListener(this);
        addKeyListener(this);           
    }   
        
    
    
    /** Rysowanie tła gry, a także liczników życ i punktów*/
    @Override public void paintComponent (Graphics gs)
    {
        Graphics2D g=(Graphics2D)gs;        
        g.drawImage(gInit.new_game_bg, 0, 0, null);
        g.setFont(new Font("Sans", Font.BOLD, 28));
        g.setColor(Color.WHITE);
        g.drawString(Long.toString(gInit.lives), 312, 672);
        g.drawString(Long.toString(gInit.cur_LVL-1), 312, 715); 
    }
    
     
    
    /** Obsługa zdarzeń klawiatury.&nbsp; Klawisze A i D zmieniają parametry zmiennej kontrolnej, a także odtwarzają dźwięki*/
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

    }
    
    /** Nadpisanie interfejsu KeyListener*/
    @Override public void keyReleased(KeyEvent e) {}
    /** Nadpisanie interfejsu KeyListener*/
    @Override public void keyTyped(KeyEvent e) {}
    
    /**Obsługa zdarzenia kliknięcia.&nbsp; kliknięcia w odpowiednie pola wyłączają grę, bądź zmieniają odpowiedź gracza na pytanie o melodię*/
    @Override public void mouseClicked(MouseEvent me)
            {
                if(me.getX()>717 && me.getX()<937 && me.getY()>643 && me.getY()<728)  
                {
                    //setVisible(false);
                    //parent.MM.setVisible(true);
                    //parent.setContentPane(parent.MM);
                    System.exit(1);
                }
                if(me.getX()>0 && me.getX()<512 && me.getY()>0 && me.getY()<385) gInit.player_answer="MOL";
                if(me.getX()>513 && me.getX()<1024 && me.getY()>0 && me.getY()<385) gInit.player_answer="DUR";
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

