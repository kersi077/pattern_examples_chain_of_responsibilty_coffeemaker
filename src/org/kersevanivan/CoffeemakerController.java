package org.kersevanivan;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import org.kersevanivan.coffeeEngine.CoffeePreparationEngine;
import org.kersevanivan.ingredients.Ingredient;
import org.kersevanivan.ingredients.Milk;
import org.kersevanivan.ingredients.Sugar;
import org.kersevanivan.ingredients.VanillaFlavour;

public class CoffeemakerController {
    @FXML
    Button milk;
    @FXML
    Button sugar;
    @FXML
    Button vanilla;
    @FXML
    Button coffee;
    @FXML
    ProgressBar preparationProgress;
    @FXML
    TextArea state;

    private Ingredient ingredient; // This is our chain of responsibility. Every inredient points to another ingredient.

    public void makeCoffee(ActionEvent actionEvent) {
        coffee.setDisable(true);
        Coffee espresso = new Espresso();

        preparationProgress.setProgress(0);
        if( this.ingredient != null )
            this.ingredient.handleCoffee(espresso);

        startCoffeeEngine(espresso);
    }

    private void startCoffeeEngine(Coffee espresso) {
        CoffeePreparationEngine preparation = new CoffeePreparationEngine(espresso); // This is a Task. It runs in background and calls every second our progressBar update!
        preparationProgress.progressProperty().bind( preparation.progressProperty() ); // Now the progressBar is bound to the progress in preparation CoffeePreparationEngine. This is part of javaFX Task object.

        preparation.setOnRunning(new RunningCoffeeMake());
        preparation.setOnSucceeded(new SuccededCoffeeMake());

        new Thread(preparation).start();
    }

    public void addMilk(ActionEvent actionEvent) {
        addIngredient(new Milk());
        this.milk.setDisable(true);
        state.setText(state.getText() + "Milk will be added\n");
    }

    public void addSugar(ActionEvent actionEvent) {
        addIngredient(new Sugar());
        this.sugar.setDisable(true);
        state.setText(state.getText() + "Sugar will be added\n");
    }

    public void addVanilla(ActionEvent actionEvent) {
        addIngredient(new VanillaFlavour());
        this.vanilla.setDisable(true);
        state.setText(state.getText() + "Vanilla flavour will be added\n");
    }

    private void addIngredient(Ingredient ingredient) {
        if( this.ingredient == null )
            this.ingredient = ingredient;
        else
            this.ingredient.setNext(ingredient);
    }
    private class SuccededCoffeeMake implements EventHandler<WorkerStateEvent> {
        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            preparationProgress.progressProperty().unbind();
            preparationProgress.setProgress(0L);
            milk.setDisable(false);
            sugar.setDisable(false);
            vanilla.setDisable(false);
            coffee.setDisable(false);
            state.setText("");

        }
    }

    private class RunningCoffeeMake implements EventHandler<WorkerStateEvent> {
        private static final String PREPARINGCOFFEE = "Preparing coffee\n";
        @Override
        public void handle(WorkerStateEvent workerStateEvent) {
            state.setText(state.getText() + PREPARINGCOFFEE);
        }
    }

}
