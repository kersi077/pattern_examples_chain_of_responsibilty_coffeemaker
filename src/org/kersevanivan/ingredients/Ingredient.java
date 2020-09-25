package org.kersevanivan.ingredients;

import org.kersevanivan.Coffee;

/**
 * <p>Title: Ingredient</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 24.09.20 09:53
 */
public interface Ingredient {
    /**
     *
     * @param coffee
     */
    public void handleCoffee(Coffee coffee);

    /**
     *
     * @param ingredient
     */
    public void setNext(Ingredient ingredient);
}
