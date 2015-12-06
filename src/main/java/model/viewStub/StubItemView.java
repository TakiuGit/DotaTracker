package model.viewStub;

import javafx.beans.property.*;

/**
 * File created by Paul NOFERI on 06/12/2015 at ESILV
 */
public class StubItemView {
    private StringProperty name ;
    private IntegerProperty id;
    private IntegerProperty cost;
    private FloatProperty winRate;
    private IntegerProperty nbUse;
    private FloatProperty useRate;

    public StubItemView(String name ,int id, float winRate, int cost, int nbUse, float useRate){
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(id);
        this.winRate = new SimpleFloatProperty(winRate);
        this.cost = new SimpleIntegerProperty(cost);
        this.nbUse = new SimpleIntegerProperty(nbUse);
        this.useRate = new SimpleFloatProperty(useRate);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getCost() {
        return cost.get();
    }

    public IntegerProperty costProperty() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }

    public float getWinRate() {
        return winRate.get();
    }

    public FloatProperty winRateProperty() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        this.winRate.set(winRate);
    }

    public int getNbUse() {
        return nbUse.get();
    }

    public IntegerProperty nbUseProperty() {
        return nbUse;
    }

    public void setNbUse(int nbUse) {
        this.nbUse.set(nbUse);
    }

    public float getUseRate() {
        return useRate.get();
    }

    public FloatProperty useRateProperty() {
        return useRate;
    }

    public void setUseRate(float useRate) {
        this.useRate.set(useRate);
    }
}
