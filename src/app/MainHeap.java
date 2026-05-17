package app;

import entity.Heap;
import service.CalcoliHeap;

import java.util.Scanner;

public class MainHeap {
    public static void main(String[] args) {
        Heap minHeap = new Heap();
        Heap maxHeap = new Heap();
        CalcoliHeap calcoliHeap = new CalcoliHeap();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci un numero: ");
            int num = scanner.nextInt();
            minHeap = calcoliHeap.minHeap(num, minHeap);
            maxHeap = calcoliHeap.maxHeap(num, maxHeap);
        }

        System.out.println(minHeap.getList());
        System.out.println(maxHeap.getList());
    }
}
