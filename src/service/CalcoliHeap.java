package service;

import entity.Heap;

public class CalcoliHeap {
    public Heap minHeap(int valore, Heap heap){
        if (heap.getList().isEmpty()){
            heap.getList().add(valore);
            return heap;
        }

        heap.getList().add(valore);
        int len = heap.getList().size();

        if (heap.getList().get(len-1) < heap.getList().get((len-1) /2)){
            swapMin(len-1, (len-1)/2, heap);
        }

        return heap;
    }

    public Heap maxHeap(int valore, Heap heap){
        if (heap.getList().isEmpty()){
            heap.getList().add(valore);
            return heap;
        }

        heap.getList().add(valore);
        int len = heap.getList().size();

        if (heap.getList().get(len-1) > heap.getList().get((len-1) /2)){
            swapMax(len-1, (len-1)/2, heap);
        }

        return heap;
    }


    private void swapMin(int x, int y, Heap heap){
        int tmp = heap.getList().get(y);
        heap.getList().set(y, heap.getList().get(x));
        heap.getList().set(x, tmp);
        if (heap.getList().get(y) < heap.getList().get(y/2)){
            swapMin(y, y/2, heap);
        }
    }

    private void swapMax(int x, int y, Heap heap) {
        int tmp = heap.getList().get(y);
        heap.getList().set(y, heap.getList().get(x));
        heap.getList().set(x, tmp);
        if (heap.getList().get(y) > heap.getList().get(y / 2)) {
            swapMax(y, y / 2, heap);
        }
    }
}
