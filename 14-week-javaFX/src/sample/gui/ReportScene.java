package sample.gui;

public class ReportScene {


    // Visual Properties
    private Stage stage;
    private Label label;
    private Scene scene;
    private TableView reportTable;

    // Logic properties
    prvate IReportServices
    reportServices;

    public ReportScene() {
        stage = new Stage();

        setUp();
        behavior(stage);

        stage.setTitle("Report");
        stage.setScene(scene);
        stage.show();
    }

    private void setUp() {

        setUpTableReport();

        VBox layout = new VBox(10);
        reportLayout.getChildren().add(table);

        scene = new Scena(layout, 200, 200);
    }

    private void behavior(Stage stage) {

        this.reportServices = new ReportServices();
        Map<String, Report> reportPersonasByProfession = this.reportServices.getReportPersonasByProfession();
        Report victims = this.reportServices.getCountOfVictims();

        reportTable.setItems((List<Reports>) reportPersonasByProfession.getValues());

    }

    private void setUpTableReport() {

        // Profession Name
        TableColumn<Report, String> professionNameColumn = new TableColumn<>();
        professionNameColumn.setMaxWiidth(200);
        professionNameColumn.setCellValueFactory(new PropertyValueFactory("criteria"));

        // Count
        TableColumn<Report, Integer> countColumn = new TableColumn<>();
        countColumn.setMaxWiidth(200);
        countColumn.setCellValueFactory(new PropertyValueFactory("count"));

        reportTable = new TableView<>();
        reportTable.getColumns().addAll(professionNameColumn, countColumn);

    }
}