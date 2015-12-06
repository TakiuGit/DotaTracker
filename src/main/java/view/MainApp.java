package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;
import model.viewStub.StubHeroView;
import model.viewStub.StubItemView;
import model.viewStub.StubMatchView;

import java.util.Date;

public class MainApp extends Application {
    private TableView itemTable = new TableView();
    private TableView heroTable = new TableView();
    private TableView matchTable = new TableView();

    private MatchHistory history;
    private Items items;
    private HeroesList heroes;

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
    private final ObservableList<StubItemView> itemData =
            FXCollections.observableArrayList();

    private final ObservableList<StubHeroView> heroData =
            FXCollections.observableArrayList();

    private final ObservableList<StubMatchView> matchData =
            FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {

        long accountId = 76561198037671458L;
        history = new MatchHistory(accountId);
        Scene scene = new Scene(new Group());
        stage.setTitle("Data Game Review");

        final HBox hbox = new HBox();
        hbox.setSpacing(24);
        hbox.setPadding(new Insets(10, 50, 10, 50));

        final VBox vbox = new VBox();
        vbox.setSpacing(5);

        createItemTable(vbox);
        loadItemsInformation();

        createHeroTable(vbox);
        loadHeroesInformation();

        hbox.getChildren().add(vbox);

        createHistoryTable(hbox);
        loadHistoryTable();

        ((Group) scene.getRoot()).getChildren().addAll(hbox); //here we add the tab to the vew context
/*
        MenuBar menuBar = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("Items");

        // --- Menu Edit
        Menu menuEdit = new Menu("WinRate");

        // --- Menu View
        Menu menuView = new Menu("AllTymeStats");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        ((Group) scene.getRoot()).getChildren().addAll(menuBar); //same here for the menu
*/
        stage.setScene(scene);
        stage.show();//we display the stage
    }


    private void createHeroTable(Pane root) {

        final Label label = new Label("Champions");
        label.setFont(new Font("Arial", 20));
        itemTable.setEditable(true);
        itemTable.setPrefSize(450, 250);
        //we can try to put it in row but i can't figure out how
        TableColumn itemCol = new TableColumn("Id"); //name of the colum
        itemCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Integer>("id")); //name of the list object

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Float>("name"));

        TableColumn nbrCol = new TableColumn("Win rate");
        nbrCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Float>("winRate"));

        TableColumn winCol = new TableColumn("Number of use");
        winCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Integer>("nbUse"));
        TableColumn useCol = new TableColumn("Use rate");
        useCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView,Integer>("useRate"));

                heroTable.getColumns().addAll(itemCol, nameCol, nbrCol, winCol, useCol);
        heroTable.setItems(heroData);

        root.getChildren().addAll(label, heroTable);
    }
    private void loadHeroesInformation() {
        heroes = HeroesList.getInstance();
        for(Heroes h : heroes.getListHeroes()){
            heroData.add(heroData.size(), history.getAllHeroesInformationForDisplay(h.getId()));
        }
    }

    private void createItemTable(Pane root) {

        VBox b = new VBox();
        final Label label = new Label("Items");
        label.setFont(new Font("Arial", 20));

        itemTable.setEditable(true);
        itemTable.setPrefSize(450, 250);
        //we can try to put it in row but i can't figure out how
        TableColumn itemCol = new TableColumn("Id"); //name of the colum
        itemCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Integer>("id")); //name of the list object

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Float>("name"));

        TableColumn nbrCol = new TableColumn("Win rate");
        nbrCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Float>("winRate"));

        TableColumn winCol = new TableColumn("Number of use");
        winCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView, Integer>("nbUse"));
        TableColumn useCol = new TableColumn("Use rate");
        useCol.setCellValueFactory(
                new PropertyValueFactory<StubItemView,Integer>("useRate"));

        itemTable.getColumns().addAll(itemCol,nameCol, nbrCol, winCol,useCol);
        itemTable.setItems(itemData);

        b.getChildren().addAll(label, itemTable);
        root.getChildren().add(b);
    }
    private void loadItemsInformation() {
        items = Items.getInstance();
        for(Item i : items.getItems()){
            itemData.add(itemData.size(), history.getAllItemsInformationForDisplay(i.getId()));
        }
    }

    private void createHistoryTable(Pane root){
        VBox b = new VBox();
        final Label label = new Label("Matchs");
        label.setFont(new Font("Arial", 20));
        matchTable.setPrefWidth(450);

        //we can try to put it in row but i can't figure out how
        TableColumn idCol = new TableColumn("Id"); //name of the colum
        idCol.setCellValueFactory(
                new PropertyValueFactory<StubMatchView, Long>("id"));

        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(
                new PropertyValueFactory<StubMatchView, String>("date"));

        TableColumn lobbyTypeCol = new TableColumn("Lobby");
        lobbyTypeCol.setCellValueFactory(
                new PropertyValueFactory<StubMatchView, Integer>("lobby"));

        TableColumn nbPlayerCol = new TableColumn("Number of players");
        nbPlayerCol.setCellValueFactory(
                new PropertyValueFactory<StubMatchView, Integer>("nbPlayers"));
        matchTable.getColumns().addAll(idCol,dateCol, lobbyTypeCol, nbPlayerCol);
        matchTable.setItems(matchData);

        b.getChildren().addAll(label, matchTable);
        root.getChildren().add(b);
    }

    private void loadHistoryTable() {
        for(Match m : history.getListMatch()){
            matchData.add(matchData.size(),
                    new StubMatchView(m.getMatchId(),
                            new Date(m.getStartTime()).toString()
                            ,m.getLobbyType(),
                            m.getPlayers().size()));
        }
    }

}
