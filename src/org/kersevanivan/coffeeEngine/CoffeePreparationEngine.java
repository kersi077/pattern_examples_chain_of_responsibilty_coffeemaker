package org.kersevanivan.coffeeEngine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import org.kersevanivan.Coffee;

import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.CountDownLatch;

/**
 * <p>Title: CoffeePreparation</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020 ec-logic GmbH, Fuerth, germany</p>
 * <p>Company: ec-logic GmbH</p>
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
