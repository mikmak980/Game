/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;
import java.awt.Graphics2D;
import java.util.*;
/**
 *
 * @author Mikołaj
 */
public class gLevel {
int difficulty;
int DrumTable[] = new int[16]; 
int ChordTable[] = new int[16];
short player_beat_table[] = new short[16];
String [] KeyTable = {"DUR", "MOL"};
String key;

public gLevel () 
{ 
    if(gInit.cur_LVL<30) difficulty = 1;
    if(gInit.cur_LVL<20) difficulty = 2;
    if(gInit.cur_LVL<10) difficulty = 4;
    
    Random generator = new Random();
    for (int i=0; i<16; i++)
    {
        if (i % difficulty == 0)  DrumTable[i] = generator.nextInt(2)+1;
        if (i % 4 == 0) ChordTable[i] = generator.nextInt(12)+1;
    }
    key = KeyTable[generator.nextInt(KeyTable.length)];
} 

    public static void testPlay(gLevel s)
    {
        //new Thread(new Runnable() {
        //@Override
        //public void run() {
        //try {
        for (int i=0; i<16; i++)
        {
            gInit.click.start();
            if (s.DrumTable[i] == 1) gInit.kick.start();
            if (s.DrumTable[i] == 2) gInit.snare.start();
            if (s.ChordTable[i] != 0) {
                if(s.key == "DUR") gInit.chord[s.ChordTable[i]].start();
                else gInit.chord[s.ChordTable[i]+12].start();
            }
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            gInit.reload(gInit.kick);
            gInit.reload(gInit.snare);
            gInit.reload(gInit.click);
            if (i % 4 == 0)
                {
                    gInit.reload(gInit.chord[s.ChordTable[i]]);
                    gInit.reload(gInit.chord[s.ChordTable[i]+12]);
                }
            
        }
        } 
            //catch (Exception e) {
            //  System.err.println(e.getMessage());
            //}
        //  }
        //}).start();
    
    
    
    public static void mainPlay(gLevel s)
    {
        //new Thread(new Runnable() {
        //@Override
        //public void run() {
        //try {
            for (int i=0; i<16; i++)
            {
                gInit.player_beat=0;
                gInit.RoundCompleted=true;
                gInit.click.start();
                if (s.ChordTable[i] != 0) 
                    {
                        if(s.key == "DUR") gInit.chord[s.ChordTable[i]].start();
                        else gInit.chord[s.ChordTable[i]+12].start();
                    }
                
                gInit.actionTime = System.currentTimeMillis(); 
                while ((System.currentTimeMillis()-gInit.actionTime)<600)
                    {
                       // if (gInit.player_beat == 1) gInit.kick.start();
                       // if (gInit.player_beat == 2) gInit.snare.start();
                   }   
                s.player_beat_table[i]=gInit.player_beat;
                gInit.reload(gInit.kick);
                gInit.reload(gInit.snare);
                gInit.reload(gInit.click);
                
                if (i % 4 == 0)
                {
                    gInit.reload(gInit.chord[s.ChordTable[i]]);
                    gInit.reload(gInit.chord[s.ChordTable[i]+12]);
                }
            }
            for (int i=0; i<16;i++) {
                if (s.DrumTable[i]!=s.player_beat_table[i]) gInit.RoundCompleted=false;
                s.player_beat_table[i]=0;
            }
            if (gInit.RoundCompleted==false) {
                gInit.lives--;
                gInit.cur_LVL--;
            }
            gInit.RoundCompleted=true;
            gInit.cur_LVL++;
            
            
        //} catch (Exception e) {
        //      System.err.println(e.getMessage());
        //   }
        //  }
        //}).start();  
    }
    
    
      
      
    public static void drawSteps(Graphics2D g) { 
        {
            try {
              if (gInit.RoundStarted==false){
            for (int i=0; i<16; i++)
            {            
                g.drawImage(gInit.step_crcl, 360+(i*20), 550, null);
            }
        }
        
            if (gInit.RoundStarted==true)
            {
                for (int i=0; i<16; i++)
               {            
                    g.drawImage(gInit.step_crcl_comp, 360+(i*20), 550, null);
                    Thread.sleep(600);
               }   
            }
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
        }
    }

}


