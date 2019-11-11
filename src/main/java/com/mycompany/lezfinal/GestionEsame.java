/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lezfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class GestionEsame {

    // fare array che chiede i cognomi
    //prepare array
    //
    static String[] nomi;
    static String[] cognomi;
    static int listavoti[];
    static String nomeEsame;
    static int soglia;
    static String msgok;
    static String msgko;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herec
        //fase 1 richiamo prepara esame
        preparaEsame();
        // fase 2 inizio sessione chiedo i nomi e cognomi 
        sessioneEsame();
        //fase 3 correzione e assegno i voti
        correzioneEsame();
        //fase 4 preparazione tabellone risultati
        visTabellone();
      
        
                
    }

    static void preparaEsame() {
        //inizializza l esame ovvero il registro
        nomeEsame = JOptionPane.showInputDialog(null, "nome dell esame");
        int quanti = Utils.AskInt("inserisci numero alunni", 1, 100);
        // creo registro
        cognomi = new String[quanti];
        nomi = new String[quanti];
        listavoti = new int[quanti];
        soglia = Utils.AskInt("valore minimo promozione",0, 100);
        msgok= JOptionPane.showInputDialog(null,"promosso","promosso");
        msgok= msgok.toUpperCase();
        // composizione per messaggio di deafault
        msgko= JOptionPane.showInputDialog("bocciato");
        msgko= msgko.toLowerCase();
    }   

    static void sessioneEsame() {

        Utils.creaNamSur(cognomi, "dimmi un nome");
        Utils.creaNamSur(nomi, "dimmi un cognome");

    }

    static void correzioneEsame() {
        // docente fornisce indietro gli esami di carta conil suo voto
        // ogni esame ha sopra nome e cognom e
        //caricamento voti
        for (int i = 0; i < cognomi.length; i++) {
            String nom = nomi[i];
            String cog = cognomi[i];
            String msg = "inserisci il voto di " + nom + " " + cog;
            listavoti[i] = Utils.AskInt(msg, 0, 100);

        }

    }

    static void visTabellone() {
        String ris = "";
         ris +=" VOTAZIONI "+ nomeEsame.toUpperCase() +"\n" ;
        for (int i = 0; i < cognomi.length; i++) {
            // esempio regis andrea voto = 43
            ris += cognomi[i] + " " + nomi[i];
            ris += " - voto = " + listavoti[i] ;
            if (listavoti[i] >= soglia) {
                ris += " " + msgok;
                        
            } else {
                ris += " " + msgko;
            }
           ris +="\n";

        }
       
        JOptionPane.showMessageDialog(null, ris);

    }
   
}
