import java.util.Scanner;

public class TicTacToe {

    protected static void stampaTicTac(String[][] matrice) {
        System.out.println("-------------");
        System.out.println("| " + matrice[0][0] + " | " + matrice[0][1] + " | " + matrice[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + matrice[1][0] + " | " + matrice[1][1] + " | " + matrice[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + matrice[2][0] + " | " + matrice[2][1] + " | " + matrice[2][2] + " |");
        System.out.println("-------------");
    }

    public void ticTacGame() {
        String[][] matrice = {{"", "", ""}, {"", "", ""}, {"", "", ""}};

        Check check = new Check();
        Giocatore giocatore = new Giocatore();

        stampaTicTac(matrice);
        Scanner myObj = new Scanner(System.in);
        int numerogiocatori;
        while (true) {
            System.out.println("inserire numero giocatori (1 o 2) :");
            numerogiocatori = myObj.nextInt();
            if (numerogiocatori == 2) {
                giocatore.dueGiocatori(matrice, check);
                break;

            } else if (numerogiocatori == 1) {
                giocatore.unGiocatore(matrice, check);
                break;
            } else {
                System.out.println("numero giocatori non valido");

            }
        }


    }

}
