import duck.*;
import duck.adaptor.GooseAdaptor;
import duck.adaptor.PigeonAdaptor;
import duck.composite.Flock;
import duck.decorator.QuackCounter;
import duck.decorator.QuackEcho;
import duck.factory.AbstractDuckFactory;
import duck.factory.EchoCountingDuckFactory;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate(new EchoCountingDuckFactory());
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdaptor(new Goose());
        Quackable pigeon = new PigeonAdaptor(new Pigeon());
        Quackable mallardDuck1 = new QuackCounter(new QuackEcho(new MallardDuck()));
        Quackable mallardDuck2 = new QuackEcho(new QuackCounter(new MallardDuck()));

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(goose);
        flockOfDucks.add(pigeon);
        flockOfDucks.add(mallardDuck1);
        flockOfDucks.add(mallardDuck2);

        Flock flockOfRubberDucks = new Flock();
        flockOfRubberDucks.add(rubberDuck);
        flockOfRubberDucks.add(duckFactory.createRubberDuck());
        flockOfRubberDucks.add(duckFactory.createRubberDuck());

        flockOfDucks.add(flockOfRubberDucks);

        System.out.println("\nDuck Simulator");

        simulate(flockOfDucks);

        System.out.println("Number of quacks is " +
                QuackCounter.getNumberOfQuacks() + " times");
    }

    void simulate(Quackable duck) { // ใช้ interface pkg.Quackable
        duck.quack();
    }
}
