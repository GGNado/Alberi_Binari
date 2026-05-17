package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Heap {

    private ArrayList<Integer> list;

    public Heap() {
        list = new ArrayList<>();
    }
}
