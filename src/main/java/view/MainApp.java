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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Items;
import javafx.scene.control.*;
import javafx.scene.image.Image;

public class MainApp extends Application {
    private TableView table = new TableView();

    public static void main(String[] args) {
        Application.launch(MainApp.class, args);
    }
    private final ObservableList<Items> data =
            FXCollections.observableArrayList(
                    //TODO parcourir la liste des items+ creer un objet ou je ne sais quoi contenant le nom de l'item son nombre d'achat et de victoire.
                    new Items());


        @Override
        public void start(Stage stage) throws Exception {


            Scene scene = new Scene(new Group());
            stage.setTitle("Table View Sample");
            stage.setWidth(800);
            stage.setHeight(850);

            final Label label = new Label("Items");
            label.setFont(new Font("Arial", 20));

            table.setEditable(true);

//we can try to put it in row but i can't figure out how
            TableColumn ItemCol = new TableColumn("Item"); //name of the colum
            ItemCol.setMinWidth(100);//min size of the column
            ItemCol.setCellValueFactory(new PropertyValueFactory<>("Item")); //name of the list object

            TableColumn NbrCol = new TableColumn("Number of time");
            NbrCol.setMinWidth(150);
            ItemCol.setCellValueFactory(new PropertyValueFactory<>("NbrTime"));

            TableColumn WinCol = new TableColumn("number of win");
            WinCol.setMinWidth(150);
            ItemCol.setCellValueFactory(new PropertyValueFactory<>("NbrWin"));


            table.setItems(data);
            table.getColumns().addAll(ItemCol, NbrCol, WinCol);

            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(50, 50, 0, 50));
            vbox.getChildren().addAll(label, table);

            ((Group) scene.getRoot()).getChildren().addAll(vbox); //here we add the tab to the vew context

            MenuBar menuBar = new MenuBar();

            // --- Menu File
            Menu menuFile = new Menu("Items");

            // --- Menu Edit
            Menu menuEdit = new Menu("WinRate");

            // --- Menu View
            Menu menuView = new Menu("AllTymeStats");

            menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

            ((Group) scene.getRoot()).getChildren().addAll(menuBar); //same here for the menu

            stage.setScene(scene);
            stage.show();//we display the stage
        }

}
