package org.kersevanivan.ingredients;

import org.kersevanivan.Coffee;

/**
 * <p>Title: VanillaFlavour</p>
 * <p>Description: </p>
 * <p>$LastChangedRevision: $</p>
 * <p>$Id: $</p>
 * <p>$LastChangedDate: $</p>
 * <p>$HeadURL: $</p>
 *
 * @author ivan
 * @version 24.09.20 09:57
 */
public class VanillaFlavour implements Ingredient {

    private Ingredient nextIngredient = null;
    private final int duration = 40;

    @Override
    public void handleCoffee(Coffee coffee) {
        coffee.addDurationOfPreparation(duration);
        if( nextIngredient != null )
            nextIngredient.handleCoffee(coffee);
    }

    @Override
    public void setNext(Ingredient ingredient) {
        if( nextIngredient == null )
            nextIngredient = ingredient;
        else
            nextIngredient.setNext(ingredient);
    }
}
