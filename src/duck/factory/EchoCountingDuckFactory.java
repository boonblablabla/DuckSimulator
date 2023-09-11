package duck.factory;

import duck.*;
import duck.DuckCall;
import duck.MallardDuck;
import duck.RedheadDuck;
import duck.RubberDuck;
import duck.decorator.QuackCounter;
import duck.decorator.QuackEcho;

public class EchoCountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackEcho(new QuackCounter(new MallardDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackEcho(new QuackCounter(new RedheadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackEcho(new QuackCounter(new DuckCall()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackEcho(new QuackCounter(new RubberDuck()));
    }
}