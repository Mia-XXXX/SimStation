package plague;

import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class PlagueAgent extends Agent {

    public PlagueAgent(String name, Simulation world, boolean infected) {
        this(name, world);
        this.infected = infected;
    }

    public boolean isInfected() {
        return infected;
    }

    private boolean infected;


    public PlagueAgent(String name, Simulation world) {
        super(name, world);
        infected = false;
    }

    @Override
    public void update() {
        //move randomly
        moveRandomly();

        PlagueSimulation world = (PlagueSimulation) this.world;

        //get the neighbor
        //PlagueAgent neighbor = (PlagueAgent) world.getNeighbor(this, 200);
        PlagueAgent neighbor = (PlagueAgent) world.getNeighbor(this);

        //then infect its neighbor
        if (neighbor != null && this.infected)
            infectOthers(neighbor);

        world.changed();
    }

    private void moveRandomly() {
        this.heading = Heading.values()[(int) (Math.random() * 4)];
        this.speed = random.nextInt(10);

        move(speed);
        world.changed();
    }

    private void infectOthers(PlagueAgent target) {

        //generate a number from 0 to 99
        int randomNumber = (int) (random.nextDouble() * 100);


        //if the random number is bigger than the percentage, then the target will be infected
        if (randomNumber < PlagueSimulation.VIRULENCE) {

            //generate another random number
            randomNumber = (int) (random.nextDouble() * 100);

            if (randomNumber > PlagueSimulation.RESISTANCE) {
                //infect the neighbor
                target.infected = true;
            }
        }
    }
}
