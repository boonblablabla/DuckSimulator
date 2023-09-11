package duck.adaptor;

import duck.Quackable;
import duck.Goose;

public class GooseAdaptor implements Quackable {
    private Goose goose;

    public GooseAdaptor (Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
        goose.honk();
    }
}