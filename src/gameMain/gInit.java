/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.sound.sampled.*;
import java.io.*;
/**
 *
 * @author Mikołaj
 */
public class gInit {

public final static long no_STEP=16;

public static int cur_LVL;

public static long lives;

public static String player_answer;

public static short player_beat;

public static boolean RoundStarted;

public static boolean GameStarted;

public static long actionTime;

public static long points;

public static boolean RoundCompleted;


public static Image main_menu_bg;

public static Image new_game_bg;

public static Image step_crcl;

public static Image step_crcl_comp;

public static Image tutorial;

public static Clip chord[];

public static Clip kick;

public static Clip snare;

public static Clip click;
    

public static void loadData()
{
    main_menu_bg = loadImage("images/MainMenu.png");
    new_game_bg = loadImage("images/GameBG.png");
    step_crcl = loadImage("images/step_crcl.png");
    step_crcl_comp = loadImage("images/step_crcl_comp.png");
    tutorial = loadImage("images/Tutorial.png");
    chord = new Clip[25];
    //akodry durowe
    chord[1] = loadClip("sounds/A.wav");
    chord[2] = loadClip("sounds/A#.wav");
    chord[3] = loadClip("sounds/B.wav");
    chord[4] = loadClip("sounds/C.wav");
    chord[5] = loadClip("sounds/C#.wav");
    chord[6] = loadClip("sounds/D.wav");
    chord[7] = loadClip("sounds/D#.wav");
    chord[8] = loadClip("sounds/E.wav");
    chord[9] = loadClip("sounds/F.wav");
    chord[10] = loadClip("sounds/F#.wav");
    chord[11] = loadClip("sounds/G.wav");
    chord[12] = loadClip("sounds/G#.wav");
    //akordy molowe
    chord[13] = loadClip("sounds/Am.wav");
    chord[14] = loadClip("sounds/A#m.wav");
    chord[15] = loadClip("sounds/Bm.wav");
    chord[16] = loadClip("sounds/Cm.wav");
    chord[17] = loadClip("sounds/C#m.wav");
    chord[18] = loadClip("sounds/Dm.wav");
    chord[19] = loadClip("sounds/D#m.wav");
    chord[20] = loadClip("sounds/Em.wav");
    chord[21] = loadClip("sounds/Fm.wav");
    chord[22] = loadClip("sounds/F#m.wav");
    chord[23] = loadClip("sounds/Gm.wav");
    chord[24] = loadClip("sounds/G#m.wav");
    //perkusja
    kick = loadClip("sounds/Kick.wav");
    snare = loadClip("sounds/Snare.wav");
    click = loadClip("sounds/Hihat.wav");
    
}



public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

public static Clip loadClip( String filename )
{
    Clip input = null;
    File f = new File(filename);
    try
    {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f);
        input = AudioSystem.getClip();
        input.open(audioIn);
    }
    catch( Exception e )
    {
        e.printStackTrace();
    }
    return input;
}

    public static void restartGame()
    {
       cur_LVL=1;
       player_answer="NULL";
       lives=10;
       RoundStarted=true;
       GameStarted=false;
       player_beat=0;
    }
    
    public static void reload(Clip c) {
    c.stop();
    c.flush();
    c.setFramePosition(0);
}
    
}
