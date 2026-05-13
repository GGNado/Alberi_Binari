import entity.BST;

import java.util.Scanner;

public class MainBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST radice = null;
        CalcoliBST calcoli = new CalcoliBST();
        
        for (int i = 0; i < 6; i++) {
            System.out.println("Inserisci il valore del nodo: ");
            int valore = Integer.parseInt(scanner.nextLine());
            
            if (radice == null) {
                radice = new BST();
                radice.setValore(valore);
            } else {
                radice = calcoli.populate(radice, valore);
            }
        }
        printVerticale(radice, "");
    }

    public static void printVerticale(BST nodo, String prefisso) {
        if (nodo == null) return;

        printVerticale(nodo.getDestra(), prefisso + "    ");
        System.out.println(prefisso + "|-- " + nodo.getValore());
        printVerticale(nodo.getSinistro(), prefisso + "    ");
    }
}