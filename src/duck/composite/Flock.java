package duck.composite;

import duck.Quackable;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackers;

    public Flock () {
        quackers = new ArrayList<>();
    }

    public void add(Quackable duck) {
        quackers.add(duck);
    }

    @Override
    public void quack() {
        for (Quackable duck: quackers) {
            if (quackers.get(0)==duck) {
                duck.quack();
                duck.quack();
                duck.quack();
            } else {
                duck.quack();
            }
        }
    }
}
