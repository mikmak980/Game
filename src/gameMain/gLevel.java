/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMain;
import java.util.*;
/**
 * Klasa operująca logiką gry.&nbsp; Następuje tutaj wygenerowanie obiektu ze wszystkimi potrzebnymi danymi, a następnie ich obsługa przez metody.
 * @author Mikołaj
 */
public class gLevel {
/** Zmienna pomocnicza, która określa zagęszczenie wygenerowanej tablicy z oczekiwanymi uderzeniami perkusji*/    
int difficulty;
/** Tablica określająca żądane uderzenia - 0 oznacza pauzę, 1 stopę, 2 werbel*/
int DrumTable[] = new int[16]; 
/** Tablica akordów.&nbsp; W każdym poziomie odtwarzane są tylko cztery akordy, ale dla uproszczenia i równoległego przetwarzania, również ma 16 miejsc*/
int ChordTable[] = new int[16];
/** Tablica analogiczna do DrumTable, przy czym zawiera wejście wprowadzane przez gracza*/
short player_beat_table[] = new short[16];
/** Z góry zdefiniowana tablica - wszystkie akordy w serii muszą być albo durowe, albo molowe.*/
String [] KeyTable = {"DUR", "MOL"};
/** Tonacja będzie losowo generowana, po to ta zmienna*/
String key;

/**
     * Konstruktor obiektu - wyznaczenie poziomu trudności, losowanie akordów, uderzeń perkusji oraz tonacji. Na koniec odtwarzana jest metoda
     */

public gLevel () 
{ 
    if(gInit.cur_LVL<30) difficulty = 1;
    if(gInit.cur_LVL<20) difficulty = 2;
    if(gInit.cur_LVL<10) difficulty = 4;
    
    Random generator = new Random();
    for (int i=0; i<16; i++)
    {
        if (i % difficulty == 0)  DrumTable[i] = generator.nextInt(2)+1;
        if (i % 4 == 0) ChordTable[i] = generator.nextInt(12)+1;//W zachodniej współczesnej muzyce wyróżniamy 12 dźwięków na oktawę. By zapobiec konfliktom, wartość 0 oznacza pauzę
    }
    key = KeyTable[generator.nextInt(KeyTable.length)];//losowanie tonacji, wykorzystywanej później w metodach
    
    testPlay(this);
    mainPlay(this);
} 
/**Metoda odtwarzająca pełną sekwencję, perkusję z melodią*/
    public void testPlay(gLevel s)
    {
        for (int i=0; i<16; i++)
        {
            gInit.click.start();
            if (s.DrumTable[i] == 1) gInit.kick.start();
            if (s.DrumTable[i] == 2) gInit.snare.start();
            if (s.ChordTable[i] != 0) {
                if(s.key == "DUR") gInit.chord[s.ChordTable[i]].start();
                else gInit.chord[s.ChordTable[i]+12].start();//W przypadku tonacji molowej przeskakujemy do kolejnych dwunastu dźwięków. Tonacja molowa jest załadowana jako druga
            }
            try { // wstrzymuję wątek, by dźwięk mógł wybrzmieć
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
    
    /**
     * Główna metoda logiki gry, która równolegle z odtwarzaniem ścieżki, zapisuje informacje o ruchach gracza, a następnie je analizuje i dodaje, lub odbiera punkty
     * 
     * 
     */
    public void mainPlay(gLevel s)
    {
            for (int i=0; i<16; i++)
            {
                gInit.player_beat=0; //jeśli gracz nie wciśnie przycisku w danym kroku, zostanie mu to uznane jako pauza
                gInit.RoundCompleted=true; //zmienna przechodzi na false, jeżeli gracz popełni błąd
                gInit.click.start();
                if (s.ChordTable[i] != 0) 
                    {
                        if(s.key == "DUR") gInit.chord[s.ChordTable[i]].start();
                        else gInit.chord[s.ChordTable[i]+12].start();
                    }
                
                gInit.actionTime = System.currentTimeMillis(); 
                while ((System.currentTimeMillis()-gInit.actionTime)<600) //nie można tutaj wstrzymać wątku, ponieważ blokują się listenery. Dlatego pojawia się pusta pętla
                    { }   
                s.player_beat_table[i]=gInit.player_beat; //wybór z listenera przechodzi do tablicy odpowiedzi
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
                if (s.DrumTable[i]!=s.player_beat_table[i]) gInit.RoundCompleted=false; //jeżeli odpowiedź nie pasuje do wzorca, runda staje się przegrana
                s.player_beat_table[i]=0;
            }
            if (gInit.player_answer!=s.key) gInit.RoundCompleted=false; //jeżeli odpowiedź na melodię jest zła, również runda jest przegrana
            
            if (gInit.RoundCompleted==false) {
                gInit.lives--; //tracimy życie
                gInit.cur_LVL--; //zostajemy na tym samym poziomie
            }
            gInit.RoundCompleted=true;
            gInit.cur_LVL++; 
    }
    
    
      

}


