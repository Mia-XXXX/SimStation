/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */

package simStation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {

    private String name;
    private String heading;
    private Integer xc;
    private  Integer yc;




    public abstract void run();

    public abstract void start();

    public abstract void suspend();

    public abstract void resume();

    public abstract void stop();

    public abstract void update();

    public abstract void move(int steps);
}
