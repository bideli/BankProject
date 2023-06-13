
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class AccountView extends Application {
    private TextField nameField;
    private TextField familyField;
    private TextField kodeMeliField;
    private TextField balanceField;
    private TextField dateField;
    private Button okButton;
    private Button backButton;

        @Override
        public void start (Stage primaryStage)  {

        GridPane eftetahHesab = new GridPane();

        Scene eftetahHesabScene = new Scene(eftetahHesab, 800, 600);


        eftetahHesab.setAlignment(Pos.CENTER);
        eftetahHesab.setHgap(15);
        eftetahHesab.setVgap(15);
        eftetahHesab.setPadding(new Insets(25, 25, 25, 25));

        Label nameLabel = new Label("نام");
        nameField = new TextField();
        eftetahHesab.add(nameLabel, 2, 1);
        eftetahHesab.add(nameField, 1, 1);

        Label familyLabel = new Label("نام خوانوادگی");
         familyField = new TextField();
        eftetahHesab.add(familyLabel, 2, 2);
        eftetahHesab.add(familyField, 1, 2);

        Label kodeMeliLabel = new Label("کد ملی");
        kodeMeliField = new TextField();
        eftetahHesab.add(kodeMeliLabel, 2, 3);
        eftetahHesab.add(kodeMeliField, 1, 3);

        Label balanceLabel = new Label("موجودی");
         balanceField = new TextField();
        eftetahHesab.add(balanceLabel, 2, 4);
        eftetahHesab.add(balanceField, 1, 4);

        Label dateLabel = new Label("سال افتتاح حساب");
         dateField = new TextField();
        eftetahHesab.add(dateLabel, 2, 5);
        eftetahHesab.add(dateField, 1, 5);

         okButton = new Button("تایید");
        eftetahHesab.add(okButton, 2, 7);

         backButton = new Button("صفحه اصلی");
        eftetahHesab.add(backButton, 1, 7);

        AccountModel model = new AccountModel();
        AccountController controller = new AccountController(model, this);
        okButton.setOnAction(event -> controller.saveAccount());
        //backButton().setOnAction(event -> goHomePage());


        primaryStage.setScene(eftetahHesabScene);




        primaryStage.setTitle("سیستم بانکی");
        primaryStage.show();

    }





    public TextField getNameField() {
        return nameField;
    }

    public TextField getFamilyField() {
        return familyField;
    }

    public TextField getKodeMeliField() {
        return kodeMeliField;
    }

    public TextField getBalanceField() {
        return balanceField;
    }

    public TextField getDateField() {
        return dateField;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getBackButton() {
        return backButton;
    }



}

