package org.kersevanivan;

import org.kersevanivan.ingredients.Ingredient;

/**
 * <p>Title: Coffee.</p>
 * <p>Description: There are plenty types of coffee. Each coffee can take some ingredients (like milk, sugar,...) and
 * how long the preparation takes. Each ingredient may adjust the preparation time. </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 24.09.20 09:54
 */
public interface Coffee {
    /**
     *
     * @return
     */
    public int preparationTime();

    public void addDurationOfPreparation(int duration);
}
