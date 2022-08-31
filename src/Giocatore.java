import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Giocatore {


    public void dueGiocatori(String[][] matrice, Check check) {
        Map<String, String> valoriGiocatori = new HashMap<>();

        Scanner myObj = new Scanner(System.in);
        String valore1;
        while (true) {
            System.out.println("assegnare il valore al Giocatore 1 (# oppure o)");
            valore1 = myObj.nextLine();
            if (!valore1.equals("#") && !valore1.equals("o")) {
                System.out.println("valore non valido");

            } else {
                break;
            }
        }
        valoriGiocatori.put(valore1, "Giocatore 1");
        String valore2;

        if (valore1.equals("#")) valore2 = "o";
        else {
            valore2 = "#";
        }

        valoriGiocatori.put(valore2, "Giocatore 2");
        System.out.println(valoriGiocatori.get(valore1) + " ------> " + valore1);
        System.out.println(valoriGiocatori.get(valore2) + " ------> " + valore2);

        String turno = valore1;

        System.out.println("Tocca al " + valoriGiocatori.get(valore1));
        int riga;
        int colonna;
        while (true) {
            System.out.println("inserire prima il valore della riga: (1,2,3)");
            riga = myObj.nextInt();

            System.out.println("inserire prima il valore della colonna: (1,2,3)");
            colonna = myObj.nextInt();
            boolean flagRiga = riga == 1 || riga == 2 || riga == 3;
            boolean flagColonna = colonna == 1 || colonna == 2 || colonna == 3;
            if (!(flagRiga && flagColonna)) {
                System.out.println("valore delle coordinate non valide, riprovare :");
            } else {
                break;
            }
        }

        System.out.println("il " + valoriGiocatori.get(valore1) + " ha insericato le coordinate (" + riga + "," + colonna + ") " + "di valore " + valore1);
        matrice[riga - 1][colonna - 1] = valore1;

        TicTac.stampaTicTac(matrice);

        while (!(check.isFuel(matrice) || check.isWin(matrice))) {

            if (turno.equals(valore1)) turno = valore2;
            else {
                turno = valore1;
            }

            System.out.println("Tocca al " + valoriGiocatori.get(turno));
            int rigaTurno;
            int colonnaTurno;
            while (true) {
                System.out.println("inserire prima il valore della riga: (1,2,3)");
                rigaTurno = myObj.nextInt();

                System.out.println("inserire prima il valore della colonna:(1,2,3)");
                colonnaTurno = myObj.nextInt();

                boolean flagRiga = rigaTurno == 1 || rigaTurno == 2 || rigaTurno == 3;
                boolean flagColonna = colonnaTurno == 1 || colonnaTurno == 2 || colonnaTurno == 3;
                if (!(flagRiga && flagColonna)) {
                    System.out.println("valore delle coordinate non valide, riprovare :");
                } else {
                    break;
                }
            }
            if (matrice[rigaTurno - 1][colonnaTurno - 1].isEmpty()) {

                System.out.println("il " + valoriGiocatori.get(turno) + "ha insericato le coordinate (" + rigaTurno + "," + colonnaTurno + ") " + "di valore " + turno);
                matrice[rigaTurno - 1][colonnaTurno - 1] = turno;

                TicTac.stampaTicTac(matrice);
            } else {
                if (turno.equals(valore1)) turno = valore2;
                else {
                    turno = valore1;
                }
                System.out.println("casella già occupata riprovare con un'altra");

            }

        }

        if (check.isWin(matrice)) {
            if (check.isWinX(matrice)) {
                System.out.println(valoriGiocatori.get("o") + " ha vinto");
            } else {
                System.out.println(valoriGiocatori.get("#") + " ha vinto");
            }
        } else if (check.isFuel(matrice)) {

            System.out.println("Caselle tutte Piene");
        }
    }

    public void unGiocatore(String[][] matrice, Check check) {
        Map<String, String> valoriGiocatori = new HashMap<>();

        Scanner myObj = new Scanner(System.in);
        String valore1;
        while (true) {
            System.out.println("assegnare il valore al Giocatore 1 (# oppure o)");
            valore1 = myObj.nextLine();
            if (!valore1.equals("#") && !valore1.equals("o")) {
                System.out.println("valore non valido");

            } else {
                break;
            }
        }
        valoriGiocatori.put(valore1, "Giocatore Umano");
        String valore2;

        if (valore1.equals("#")) valore2 = "o";
        else {
            valore2 = "#";
        }

        valoriGiocatori.put(valore2, "Giocatore PC");
        System.out.println(valoriGiocatori.get(valore1) + " ------> " + valore1);
        System.out.println(valoriGiocatori.get(valore2) + " ------> " + valore2);

        String turno = valore1;

        System.out.println("Tocca al " + valoriGiocatori.get(valore1));
        int riga;
        int colonna;
        while (true) {

            System.out.println("inserire prima il valore della riga: (1,2,3)");
            riga = myObj.nextInt();

            System.out.println("inserire prima il valore della colonna: (1,2,3)");
            colonna = myObj.nextInt();
            boolean flagRiga = riga == 1 || riga == 2 || riga == 3;
            boolean flagColonna = colonna == 1 || colonna == 2 || colonna == 3;
            if (!(flagRiga && flagColonna)) {
                System.out.println("valore delle coordinate non valide, riprovare :");
            } else {
                break;
            }
        }

        System.out.println("il " + valoriGiocatori.get(valore1) + " ha insericato le coordinate (" + riga + "," + colonna + ") " + "di valore " + valore1);
        matrice[riga - 1][colonna - 1] = valore1;

        TicTac.stampaTicTac(matrice);

        while (!(check.isFuel(matrice) || check.isWin(matrice))) {

            if (turno.equals(valore1)) turno = valore2;
            else {
                turno = valore1;
            }
            System.out.println("Tocca al " + valoriGiocatori.get(turno));
            if (turno.equals(valore1)) {

                int rigaTurno;
                int colonnaTurno;
                while (true) {
                    System.out.println("inserire prima il valore della riga: (1,2,3)");
                    rigaTurno = myObj.nextInt();

                    System.out.println("inserire prima il valore della colonna:(1,2,3)");
                    colonnaTurno = myObj.nextInt();

                    boolean flagRiga = rigaTurno == 1 || rigaTurno == 2 || rigaTurno == 3;
                    boolean flagColonna = colonnaTurno == 1 || colonnaTurno == 2 || colonnaTurno == 3;
                    if (!(flagRiga && flagColonna)) {
                        System.out.println("valore delle coordinate non valide, riprovare :");
                    } else {
                        break;
                    }
                }
                if (matrice[rigaTurno - 1][colonnaTurno - 1].isEmpty()) {

                    System.out.println("il " + valoriGiocatori.get(turno) + "ha insericato le coordinate (" + rigaTurno + "," + colonnaTurno + ") " + "di valore " + turno);
                    matrice[rigaTurno - 1][colonnaTurno - 1] = turno;

                    TicTac.stampaTicTac(matrice);
                } else {
                    if (turno == valore1) turno = valore2;
                    else {
                        turno = valore1;
                    }
                    System.out.println("casella già occupata riprovare con un'altra");

                }
            }
            else {
                int rigaTurno;
                int colonnaTurno;

                while (true) {
                    Random random = new Random();
                    rigaTurno = random.nextInt(3);
                    colonnaTurno = random.nextInt(3);

                    if (matrice[rigaTurno][colonnaTurno].isEmpty()){
                        break;
                    }
                }
                matrice[rigaTurno][colonnaTurno] = turno;

                System.out.println("il " + valoriGiocatori.get(turno) + "ha insericato le coordinate (" + Integer.valueOf(rigaTurno+1) + "," + Integer.valueOf(colonnaTurno+1) + ") " + "di valore " + turno);
               TicTac.stampaTicTac(matrice);

            }
        }

        if (check.isWin(matrice)) {
            if (check.isWinX(matrice)) {
                System.out.println(valoriGiocatori.get("o") + " ha vinto");
            } else {
                System.out.println(valoriGiocatori.get("#") + " ha vinto");
            }
        } else if (check.isFuel(matrice)) {

            System.out.println("Caselle tutte Piene");
        }
    }
}
