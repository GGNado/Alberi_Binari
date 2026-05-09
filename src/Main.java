import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodoBin root = new NodoBin(0);
        root.populate(root, scanner);
        root.printVerticale(root, "");
    }
}