import javafx.scene.control.Alert;

import java.sql.*;

public  class AccountModel {
    public void saveAccount(int kode_meli, String name, String family, int date_start, int number_hesab, int mojodi) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bank", "bank123");


            PreparedStatement preparedStatement = connection.prepareStatement("insert into hesab (kode_meli,name, family,date_start, number_hesab,mojodi) values ( ?, ?, ?, ?,?,?)");
            preparedStatement.setInt(1, kode_meli);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, family);
            preparedStatement.setInt(4, date_start);
            preparedStatement.setInt(5, number_hesab);
            preparedStatement.setInt(6, mojodi);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            Alert okAlert=new Alert(Alert.AlertType.CONFIRMATION);
            okAlert.setTitle("اعلان");
            okAlert.setHeaderText(null);
            okAlert.setContentText("ثبت شد.");
            okAlert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert okAlert=new Alert(Alert.AlertType.ERROR);
            okAlert.setTitle("اعلان");
            okAlert.setHeaderText(null);
            okAlert.setContentText("خطا!! ثبت نشد.");
            okAlert.showAndWait();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
