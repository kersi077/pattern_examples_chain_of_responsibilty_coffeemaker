package org.kersevanivan;


/**
 * <p>Title: Espresso.</p>
 * <p>Description: A good espresso has just 40 ml. </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 24.09.20 09:57
 */
public class Espresso implements Coffee {

    private int durationBias = 25; // The preparation of the espresso lasts 25 seconds. This is just a thought up value. Which is needed for a progressbar. In reality this would work completely different.

    @Override
    public int preparationTime() {
        return durationBias;
    }

    @Override
    public void addDurationOfPreparation(int duration) {
        durationBias = durationBias + duration;
    }


}
