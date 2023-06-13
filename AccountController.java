import javax.swing.*;
import java.time.LocalDate;

public class AccountController {
        private  final AccountModel model;
        private final AccountView view;

        public AccountController(AccountModel model, AccountView view) {
            this.model = model;
            this.view = view;
        }

    public boolean isNationalIdValid(String nationalId) {
        if (nationalId.length() != 9) {
            return false;
        }

        for (int i = 0; i < nationalId.length(); i++) {
            if (!Character.isDigit(nationalId.charAt(i))) {
                return false;
            }
        }

        if (nationalId.charAt(0) == '0') {
            return false;
        }

        return true;
    }



        public void saveAccount() {
            String name = view.getNameField().getText();
            String family = view.getFamilyField().getText();
            String k = view.getKodeMeliField().getText();
            int kode_meli = Integer.parseInt(k);
            String b = view.getBalanceField().getText();
            int mojodi = Integer.parseInt(b);
            String d = view.getDateField().getText();
            int date_start = Integer.parseInt(d);
            double n = Math.random() * 100;
            int number_hesab = (int) Math.round(n);



            if (name.isEmpty()) {
                String message="لطفا اسم را وارد کنید.";
                showError(message);
                return;
            }
            if (family.isEmpty()) {
                String message="لطفا فامیلی را وارد کنید.";
                showError(message);
                return;
            }

            if (!isNationalIdValid(k)) {
                String message="کد ملی معتبر نیست.";
                showError(message);
                return;
            }

            if (mojodi <= 0) {
                String message="موجودی معتبر نیست.";
                showError(message);
                return;
            }

            if (date_start > LocalDate.now().getYear()) {
                String message="سال وارد شده معتبر نیست.";
                showError(message);
                return;
            }


            model.saveAccount(kode_meli, name, family, date_start, number_hesab, mojodi);

            view.getNameField().clear();
            view.getFamilyField().clear();
            view.getKodeMeliField().clear();
            view.getBalanceField().clear();
            view.getDateField().clear();
        }

    public void showError(String message) {

        JOptionPane.showMessageDialog( null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    }
