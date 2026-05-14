package app;

import entity.BST;
import service.CalcoliBST;
import util.TreePrinter;

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
        TreePrinter.printVerticale(radice, "");
        System.out.println("Stampa in ampiezza:");
        TreePrinter.printBFS(radice);
    }
}
