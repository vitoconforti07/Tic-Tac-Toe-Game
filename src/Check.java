import java.util.Arrays;

public class Check {
    protected boolean isFuel(String[][] matrice) {
        boolean flag = true;
        for (int i = 0; i < matrice.length; i++) {
            String[] riga = matrice[i];
            for (int j = 0; j < riga.length; j++) {
                if (riga[j].isEmpty()) flag = false;
            }
        }
        return flag;
    }

    private boolean isRigaWinParamentro(String[][] matrice, String paramento) {
        boolean flag = false;
        for (int i = 0; i < matrice.length; i++) {
            String[] riga = matrice[i];
            boolean b = Arrays.stream(riga).allMatch(s -> s.equals(paramento));
            if (b == true) flag = true;
        }
        return flag;
    }


    private boolean isColonnaWinV(String[][] matrice) {
        return isRigaWinParamentro(matriceTrasposta(matrice), "#");
    }

    private boolean isColonnaWinX(String[][] matrice) {
        return isRigaWinParamentro(matriceTrasposta(matrice), "o");
    }

    private boolean isDiagolaneWin(String[][] matrice, String paramentro) {

        return isDiagolanePrincipaleWin(matrice, paramentro) || isDiagolaneSecondariaWin(matrice,paramentro);
    }

    private boolean isDiagolanePrincipaleWin(String[][] matrice, String paramentro) {

        String[] array = new String[3];
        for (int i = 0; i < matrice.length; i++) {
            array[i] = matrice[i][i];
        }
        return Arrays.stream(array).allMatch(s -> s.equals(paramentro));
    }

   private boolean isDiagolaneSecondariaWin(String[][] matrice, String paramentro) {

        String[] array = new String[3];
        for (int i = 0; i < matrice.length; i++) {
            array[i] = matrice[i][2-i];
        }
        return Arrays.stream(array).allMatch(s -> s.equals(paramentro));
    }

    private boolean isWinV(String[][] matrice) {
        return (isColonnaWinV(matrice) || isRigaWinParamentro(matrice, "#")) || isDiagolaneWin(matrice, "#");

    }

    protected boolean isWinX(String[][] matrice) {
        return isColonnaWinX(matrice) || isRigaWinParamentro(matrice, "o") || isDiagolaneWin(matrice, "o");
    }

    protected boolean isWin(String[][] matrice) {
        return isWinV(matrice) || isWinX(matrice);
    }


    private String[][] matriceTrasposta(String[][] matrice) {
        String[][] matriceTrasposta = new String[3][3];
        for (int i = 0; i < matrice.length; i++) {
            String[] riga = matrice[i];
            for (int j = 0; j < riga.length; j++) {
                matriceTrasposta[j][i] = matrice[i][j];
            }
        }
        return matriceTrasposta;
    }

}
