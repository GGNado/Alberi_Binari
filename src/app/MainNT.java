package app;

import entity.NT;
import service.CalcoliNT;
import util.TreePrinter;

import java.util.Scanner;

public class MainNT {
    public static void main(String[] args) {
        NT radice = null;
        CalcoliNT calcoli = new CalcoliNT();
        Scanner scanner = new Scanner(System.in);

        radice = calcoli.populate(radice, scanner);
        TreePrinter.printVerticale(radice, "");

    }
}
