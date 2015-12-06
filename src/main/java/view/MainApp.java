package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

        createLeftPane(hbox);
        createRigthPane(hbox);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);
        stage.setScene(scene);
        stage.show();//we display the stage
    }

    private void createRigthPane(HBox hbox) {
        VBox v = new VBox();
        hbox.getChildren().add(v);
        v.setSpacing(15);

        createHistoryTable(v);
        loadHistoryTable();

        createDetailButton(v);
    }
    private void createDetailButton(Pane root) {
        Button button = new Button("Details");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                createDetailView((StubMatchView) matchTable.getSelectionModel().getSelectedItem());
            }
        });
        root.getChildren().add(button);
    }

    private void createLeftPane(Pane root) {
        final VBox vbox = new VBox();
        vbox.setSpacing(5);

        createItemTable(vbox);
        loadItemsInformation();

        createHeroTable(vbox);
        loadHeroesInformation();

        root.getChildren().add(vbox);
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
                            new Date(m.getStartTime()*1000).toString()
                            ,m.getLobbyType(),
                            m.getPlayers().size()));
        }
    }

    private void createDetailView(StubMatchView selectedItem) {
        if(selectedItem == null)
            return;
        Stage stageErasing = new Stage();

        VBox root = new VBox();
        root.setSpacing(25);
        root.setPadding((new Insets(10, 10, 10, 10)));

        Label title = new Label("Match " + selectedItem.getId());
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        MatchDetail detail = new MatchDetail(selectedItem.getId());

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(8);
        grid.setStyle("-fx-background-color: #BBBBBBBB;");
        grid.setPadding(new Insets(10, 10, 10, 10));
        addTabHeader(grid);
        int rowNumber = 1;
        for(PlayerMatchInfo p : detail.getPlayers()){
            addPlayersRow(grid, p,rowNumber);
            ++rowNumber;
        }

        root.getChildren().addAll(title,grid);

        Scene sceneErasing = new Scene(root);
        stageErasing.setScene(sceneErasing);
        stageErasing.show();
    }

    private void addTabHeader(GridPane root) {
        Font f = Font.font("Arial", FontWeight.BOLD, 14);

        Label playerLab = new Label("Player");
        playerLab.setFont(f);
        root.add(playerLab,0,0);

        Label levelLabel = new Label("Level");
        levelLabel.setFont(f);
        root.add(levelLabel,1,0);

        Label killLabel = new Label("Kill");
        killLabel.setFont(f);
        root.add(killLabel,2,0);

        Label deathLabel = new Label("Death");
        deathLabel.setFont(f);
        root.add(deathLabel,3,0);

        Label assistLabel = new Label("Assist");
        assistLabel.setFont(f);
        root.add(assistLabel,4,0);

        Label goldLabel = new Label("Gold");
        goldLabel.setFont(f);
        root.add(goldLabel,5,0);

        Label xpmLabel = new Label("XPM");
        xpmLabel.setFont(f);
        root.add(xpmLabel,6,0);

        Label gpmLabel = new Label("GPM");
        gpmLabel.setFont(f);
        root.add(gpmLabel,7,0);

        Label heroDamage = new Label("HD");
        heroDamage.setFont(f);
        root.add(heroDamage,8,0);

        Label healingDeal = new Label("HH");
        healingDeal.setFont(f);
        root.add(healingDeal,9,0);

        Label towerDamage = new Label("TD");
        towerDamage.setFont(f);
        root.add(towerDamage,10,0);
    }

    private void addPlayersRow(GridPane root ,PlayerMatchInfo p, int rowNumber) {
        Font f = Font.font("Arial", 14);

        Label playerLab = new Label(Long.toString( p.getAccountId()));
        playerLab.setFont(f);
        if((p.getPlayerSlot()  >>> 7) != 0)
            playerLab.setTextFill(Color.RED);
        else
            playerLab.setTextFill(Color.GREEN);
        root.add(playerLab,0,rowNumber);

        Label levelLabel = new Label(Integer.toString(p.getLevel()));
        levelLabel.setFont(f);
        root.add(levelLabel,1,rowNumber);

        Label killLabel = new Label(Integer.toString(p.getKills()));
        killLabel.setFont(f);
        root.add(killLabel,2,rowNumber);

        Label deathLabel = new Label(Integer.toString(p.getDeaths()));
        deathLabel.setFont(f);
        root.add(deathLabel,3,rowNumber);

        Label assistLabel = new Label(Integer.toString(p.getAssists()));
        assistLabel.setFont(f);
        root.add(assistLabel,4,rowNumber);

        Label goldLabel = new Label(Integer.toString(p.getGold() + p.getGoldSpent()));
        goldLabel.setFont(f);
        root.add(goldLabel,5,rowNumber);

        Label xpmLabel = new Label(Integer.toString(p.getXpPerMin()));
        xpmLabel.setFont(f);
        root.add(xpmLabel,6,rowNumber);

        Label gpmLabel = new Label(Integer.toString(p.getGoldPerMin()));
        gpmLabel.setFont(f);
        root.add(gpmLabel,7,rowNumber);

        Label heroDamage = new Label(Integer.toString(p.getHeroDamage()));
        heroDamage.setFont(f);
        root.add(heroDamage,8,rowNumber);

        Label healingDeal = new Label(Integer.toString(p.getHeroHealing()));
        healingDeal.setFont(f);
        root.add(healingDeal,9,rowNumber);

        Label towerDamage = new Label(Integer.toString(p.getTowerDamage()));
        towerDamage.setFont(f);
        root.add(towerDamage,10,rowNumber);
    }
}
