package duck.adaptor;

import duck.Quackable;
import duck.Pigeon;

public class PigeonAdaptor implements Quackable {

    private Pigeon pigeon;

    public  PigeonAdaptor (Pigeon pigeon) {
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        pigeon.coo();
        pigeon.coo();
    }
}