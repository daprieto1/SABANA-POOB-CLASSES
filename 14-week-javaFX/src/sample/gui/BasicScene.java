package sample.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.logic.PersonaException;
import sample.logic.entities.Persona;
import sample.logic.services.IPersonaServices;
import sample.logic.services.impl.PersonaService;

public class BasicScene extends Application {

    // Visual Properties
    private Scene scene;
    private TableView<Persona> personasTable;
    private TextField nameInput;
    private TextField lastNameInput;
    private TextField ageInput;
    private Button addPersona;
    private Button deletePersona;

    // Logic Properties
    private IPersonaServices personaServices;

    //CRUD -
    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp();
        behavior();

        primaryStage.setTitle("Sabana Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void behavior() {
        this.personaServices = new PersonaService();
        try {
            this.personaServices.insert(new Persona("Diego", "Prieto", "25"));
            this.personaServices.insert(new Persona("Maria", "Rdriguez", "12"));
            this.personaServices.insert(new Persona("Carlos", "Henao", "100"));
        } catch (PersonaException e) {
            e.printStackTrace();
        }

        personasTable.setItems(this.personaServices.getAll());

        addPersona.setOnAction(e -> {
            try {
                Persona p = new Persona(nameInput.getText(), lastNameInput.getText(), ageInput.getText());
                this.personaServices.insert(p);
                nameInput.clear();
                lastNameInput.clear();
                ageInput.clear();
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
        });

        deletePersona.setOnAction(e -> {
            this.personaServices.delete(personasTable.getSelectionModel().getSelectedItems());
        });
    }

    private void setUp() {

        //Name column
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Name column
        TableColumn<Persona, String> lastNameColumn = new TableColumn<>("LastName");
        lastNameColumn.setMaxWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Name column
        TableColumn<Persona, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setMaxWidth(200);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        //Table
        personasTable = new TableView<>();
        personasTable.getColumns().addAll(nameColumn, lastNameColumn, ageColumn);

        setupInputs();

        addPersona = new Button("Add");
        addPersona.setMinWidth(30);

        deletePersona = new Button("Delete");
        deletePersona.setMinWidth(30);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, lastNameInput, ageInput, addPersona, deletePersona);

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(personasTable, hBox);

        //Scene
        scene = new Scene(layout, 400, 400);
    }

    private void setupInputs() {
        nameInput = new TextField();
        nameInput.setPromptText("name");
        nameInput.setMinWidth(30);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("last name");
        lastNameInput.setMinWidth(30);

        ageInput = new TextField();
        ageInput.setPromptText("age");
        ageInput.setMinWidth(30);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
