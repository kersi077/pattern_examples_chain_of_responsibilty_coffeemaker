package org.kersevanivan.coffeeEngine;

import javafx.concurrent.Task;
import org.kersevanivan.Coffee;


/**
 * <p>Title: CoffeePreparation</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 24.09.20 10:51
 */
public class CoffeePreparationEngine extends Task<Void> {

    private long timeElapsed = 0L;
    private int preparationTime = 0;

    public CoffeePreparationEngine(Coffee someCoffee) {
        this.preparationTime = someCoffee.preparationTime();
    }

    @Override
    protected Void call() throws Exception {

        while( timeElapsed <= preparationTime ) {
            updateProgress(timeElapsed, (long) preparationTime);
            timeElapsed++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
        return null;
    }
}
