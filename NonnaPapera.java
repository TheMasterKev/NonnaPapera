package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Es10.
 * Creare una classe java di nome “NonnaPapera” che gestisca le scommesse tra due giocatori A e B
 * sul lancio della moneta lanciata 5 volte per ciascun giocatore. Funzionamento:
 * 1. Giocatore A budget scommesse 20€ - Giocatore B budget scommesse 20€.
 * 2. Controllare che A e B abbiano soldi per giocare.
 * 3. Ripetere i punti da 4 a 15 per 5 volte.
 * 4. Giocatore A sceglie se testa o croce. Al giocatore B toccherà quello che avanza.
 * 5. Giocatore A sceglie l’importo della scommessa (un valore compreso tra 1 e 10€ - usare solo
 * valori interi).
 * 6. Giocatore B sceglie l’importo della scommessa (un valore compreso tra 1 e 10€ - usare solo
 * valori interi).
 * 7. Lancio moneta (testa=0 croce=1).
 * 8. Indicare il vincitore e quanti soldi ha vinto.
 * 9. Controllare che A e B abbiano soldi per giocare.
 * 10. Giocatore B sceglie se testa o croce. Al giocatore A toccherà quello che avanza.
 * 11. Giocatore B sceglie l’importo della scommessa (un valore compreso tra 1 e 10€ - usare solo
 * valori interi).
 * 12. Giocatore A sceglie l’importo della scommessa (un valore compreso tra 1 e 10€ - usare solo
 * valori interi).
 * 13. Lancio moneta (testa=0 croce=1).
 * 14. Indicare il vincitore e quanti soldi ha vinto.
 * 15. Controllare che A e B abbiano soldi per giocare.
 */
public class NonnaPapera {
    private int portafoglioA = 20;
    private int portafoglioB = 20;
    private int scommessaA, scommessaB;
    private int sceltaA, sceltaB;
    private int sorteggio;
    private Scanner kb = new Scanner(System.in);
    private Random random = new Random();

    public void gioco(){

        for(int i = 0; i <5;i++){
            if(portafoglioA == 0 || portafoglioB == 0){
                System.out.println("Soldi finiti.");
                if (portafoglioB == 0) {
                    System.out.println("Ha vinto A con " + portafoglioA + " € rimanenti.");
                }
                else{
                    System.out.println("Ha vinto B con " + portafoglioB + " € rimanenti.");
                }
                break;
            }
            else {
                do {
                    inserimentoA();
                    if (scommessaA > portafoglioA) System.out.println("Non hai abbastanza fondi, devi puntare meno");
                } while (scommessaA > portafoglioA);
                portafoglioA -= scommessaA;
                do {
                    sceltaA = scelta();
                }while(sceltaA != 1 && sceltaA != 0);
                if(sceltaA == 1) sceltaB = 0;
                else sceltaB = 1;

                do {
                    inserimentoB();
                    if (scommessaB > portafoglioB) System.out.println("Non hai abbastanza fondi, devi puntare meno");
                } while (scommessaB > portafoglioB);
                portafoglioB -= scommessaB;
                sorteggio = random.nextInt(2);
                System.out.println("Lancio moneta....");
                if(sorteggio == 1) System.out.println("E' uscito croce");
                if(sorteggio == 0) System.out.println("E' uscito testa");

                if(sorteggio == sceltaA) {
                    System.out.println("Ha vinto il Giocatore 1.\nImporto vinto: "+ scommessaB +"€");
                    portafoglioA += scommessaA + scommessaB;
                }
                else {
                    System.out.println("Ha vinto il Giocatore 2.\nImporto vinto: "+ scommessaA +"€");
                    portafoglioB += scommessaB + scommessaA;
                }

                //System.out.println("Pa = "+portafoglioA);
                //System.out.println("Pb = "+portafoglioB);
                do {
                    inserimentoB();
                    if (scommessaB > portafoglioB) System.out.println("Non hai abbastanza fondi, devi puntare meno");
                } while (scommessaB > portafoglioB);
                portafoglioB -= scommessaB;
                do {
                    sceltaB = scelta();
                }while(sceltaB != 1 && sceltaB != 0);
                if(sceltaB == 1) sceltaB = 0;
                else sceltaA = 1;

                do {
                    inserimentoA();
                    if (scommessaA > portafoglioA) System.out.println("Non hai abbastanza fondi, devi puntare meno");
                } while (scommessaA > portafoglioA);
                portafoglioA -= scommessaA;
                sorteggio = random.nextInt(2);
                System.out.println("Lancio moneta....");
                if(sorteggio == 1) System.out.println("E' uscito croce");
                if(sorteggio == 0) System.out.println("E' uscito testa");

                if(sorteggio == sceltaA) {
                    System.out.println("Ha vinto il Giocatore 1.\nImporto vinto: "+ scommessaB +"€");
                    portafoglioA += scommessaA + scommessaB;
                }
                else {
                    System.out.println("Ha vinto il Giocatore 2.\nImporto vinto: "+ scommessaA +"€");
                    portafoglioB += scommessaB + scommessaA;
                }
            }

        }
        if(portafoglioA>portafoglioB){
            System.out.println("Ha vinto il Giocatore 1 con: "+portafoglioA+"€ rimanenti.");
        }
        else System.out.println("Ha vinto il Giocatore 2 con: "+portafoglioB+"€ rimanenti.");
    }

    private void inserimentoA() {
        String str;
        try {
            System.out.println("Giocatore 1 quanto vuoi scommettere?");
            str = kb.nextLine();
            scommessaA = Integer.parseInt(str);
        } catch (Exception e) {

        }
    }

    private void inserimentoB() {
        String str;
        try {
            System.out.println("Giocatore 2 quanto vuoi scommettere?");
            str = kb.nextLine();
            scommessaB = Integer.parseInt(str);
        } catch (Exception e) {

        }
    }

    private int scelta(){
        int Scelta = 3;
        String str;
        String testa = "testa";
        try {
            System.out.println("Inserire scelta:");
            str = kb.nextLine();
            if(str.equals("testa") || str.equals("Testa")){
                Scelta = 0;
            }
            else {
                if (str.equals("croce") || str.equals("Croce")) {
                    Scelta = 1;
                }

            }

        } catch (Exception e) {

        }
        return Scelta;
    }
}
