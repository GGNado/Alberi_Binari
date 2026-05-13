import entity.NodoBinSearch;

import java.util.Scanner;

public class MainNodoBinSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodoBinSearch nodoBinSearch = new NodoBinSearch();
        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci il valore del nodo: ");
            int valore = Integer.parseInt(scanner.nextLine());
            nodoBinSearch.populate(nodoBinSearch, valore);
        }

        printVerticale(nodoBinSearch, "");
    }

    public static void printVerticale(NodoBinSearch nodo, String prefisso) {
        if (nodo == null) return;

        printVerticale(nodo.getDestra(), prefisso + "    ");
        System.out.println(prefisso + "|-- " + nodo.getValore());
        printVerticale(nodo.getSinistro(), prefisso + "    ");
    }
}