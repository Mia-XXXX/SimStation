/*
 * Edit history:
 *   Hui, 4/2: created
 *   Hui, 4/6: update to new method
 *
 */

package simStation;

import java.io.Serializable;
import java.util.Random;

public abstract class Agent implements Runnable, Serializable {

    private static int[] headingStatistics = new int[4];

    protected String name;
    protected Heading heading;
    protected Integer xc;
    protected Integer yc;
    protected Simulation world;
    private AgentState state;
    private Thread thread;
    protected Random random = new Random();
    protected int speed;



    public Agent(String name,  Simulation world) {
        this.name = name;
        this.heading = Heading.values()[random.nextInt(4)];
        this.speed  = random.nextInt(10);
        this.xc = random.nextInt(Simulation.WORLD_SIZE);
        this.yc = random.nextInt(Simulation.WORLD_SIZE);
        this.world = world;
        this.state = null;

    }


    public String getName() {
        return name;
    }

    public Heading getHeading() {
        return heading;
    }

    public Integer getXc() {
        return xc;
    }

    public Integer getYc() {
        return yc;
    }

    public synchronized AgentState getState() {
        return state;
    }

    public synchronized void join() throws InterruptedException {
        if (thread != null) thread.join();
    }

    public synchronized String toString() {
        return name + ".state = " + state + " id:" + super.toString();
    }

    public void run() {
        thread = Thread.currentThread(); // catch my thread
        while (!isStopped()) {
            state = AgentState.RUNNING;
            update();
            try {
                Thread.sleep(100); // be cooperative
                synchronized (this) {
                    while (isSuspended()) {
                        wait();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public void start() {
        if (state == null) {
            state = AgentState.READY;
            thread = new Thread(this);
            thread.start();
        }
    }


    public synchronized void stop() {
        if (state != AgentState.STOPPED) {
            state = AgentState.STOPPED;
        }
    }

    public synchronized boolean isStopped() {
        return state == AgentState.STOPPED;
    }

    public synchronized void suspend() {
        if (state == AgentState.RUNNING) {
            state = AgentState.SUSPENDED;
        }
    }

    public synchronized boolean isSuspended() {
        return state == AgentState.SUSPENDED;
    }

    public synchronized void resume() {
        if (state == AgentState.SUSPENDED) {
            notify();
            state = AgentState.READY;
        }
    }


    public abstract void update();

    public void move(int steps) {
        switch (heading) {
            case NORTH: {
                if (yc - steps > 0)
                    yc -= steps;
                else
                    yc = 0;
                headingStatistics[0]++;
            }
            case SOUTH: {
                if (yc + steps < Simulation.WORLD_SIZE - 10)
                    yc += steps;
                else
                    yc = Simulation.WORLD_SIZE - 10;
                headingStatistics[1]++;
            }
            case EAST: {
                if (xc + steps < Simulation.WORLD_SIZE - 10)
                    xc += steps;
                else
                    xc = Simulation.WORLD_SIZE - 10;
                headingStatistics[2]++;
            }
            case WEST: {
                if (xc - steps > 0)
                    xc -= steps;
                else
                    xc = 0;
                headingStatistics[3]++;
            }
        }
        world.changed();
    }
}
