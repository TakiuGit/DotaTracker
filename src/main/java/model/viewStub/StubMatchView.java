package model.viewStub;

import javafx.beans.property.*;

/**
 * File created by Paul NOFERI on 06/12/2015 at ESILV
 */
public class StubMatchView {

    private LongProperty id;
    private StringProperty date;
    private IntegerProperty lobby;
    private IntegerProperty nbPlayers;

    public StubMatchView(long id, String date, int lobby,int nbPlayers){
        this.id = new SimpleLongProperty(id);
        this.date = new SimpleStringProperty(date);
        this.lobby = new SimpleIntegerProperty(lobby);
        this.nbPlayers = new SimpleIntegerProperty(nbPlayers);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public int getLobby() {
        return lobby.get();
    }

    public IntegerProperty lobbyProperty() {
        return lobby;
    }

    public void setLobby(int lobby) {
        this.lobby.set(lobby);
    }

    public int getNbPlayers() {
        return nbPlayers.get();
    }

    public IntegerProperty nbPlayersProperty() {
        return nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers.set(nbPlayers);
    }
}
