/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;

import javax.swing.JFrame;

/**
 * Klasa okna gry.&nbsp; 
 * Niestety, prawdopodobnie z powodu źle zaprojektowanej architektury, albo działa sama gra, albo przełączanie okien, wraz z samouczkiem.&nbsp;
 * W tej drugiej wersji należy wykomentować linie "NewGame.setFocusable(true);", "NewGame.requestFocusInWindow();" oraz "initNewGame();"&nbsp;
 * a także odkomentować zaznaczone linie.&nbsp;
 * Pola paneli są publiczne w celu ich przełączania
 * @author Mikołaj
 */
public class gWindow extends JFrame {
    public gPanel NewGame;
    public MainMenu MM;
    public Tutorial TT;   
    /** 
     * Metody Focusable pozwalają przejąć kontrolę nad KeyListenerem
     * Parametry określają miejsce i rozdzielczość rysowania okna
     */
        public gWindow(int width, int height, int x, int y)
    {
        super();
        gInit.loadData();
        setSize(width, height);
        setLocation(x,y);
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        NewGame = new gPanel(this);
        add(NewGame);
        //TT = new Tutorial(this);
        //add(TT);
        //MM = new MainMenu(this);
        //add(MM);
        NewGame.setFocusable(true);
        NewGame.requestFocusInWindow();
        setVisible(true);
        initNewGame();
    }
    
    /** Metoda uruchamiająca logikę gry*/
    private void initNewGame()
    {
        while (gInit.lives!=0)
            {
                gLevel s = new gLevel();
                repaint();
                s=null;
            }
        System.exit(1);
    }
}
