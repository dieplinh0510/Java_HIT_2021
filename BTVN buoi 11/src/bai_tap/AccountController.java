package bai_tap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AccountController {
    private Account account = new Account();
    private FileController fileController = new FileController();

    public AccountController() {
    }

    public AccountController(Account account, FileController fileController) {
        this.account = account;
        this.fileController = fileController;
    }

    public List<Account> readAccountFromFile(String filename) throws IOException {
        fileController.OpenFileToRead(filename);
        List<Account> accounts = new ArrayList<>();

        while(fileController.scanner.hasNext()) {
            String data = fileController.scanner.nextLine();
            String[] a = data.split("\\|");
            accounts.add(new Account(Long.parseLong(a[0]), a[1], a[2], a[3], a[4], a[5], a[6]));
        }

        fileController.CloseFileAfterRead(filename);

        return accounts;
    }

    public List<Account> writeAccountToFile(List<Account> accounts, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Account account : accounts) {
            fileController.getPrintWriter().println(account.getId() + "|" + account.getFullName() + "|" + account.getUseName()+ "|" + account.getPassword() + "|" + account.getEmail()+ "|" + account.getPhone());
        }

        fileController.CloseFileAfterWrite();
        return accounts;
    }
    public void closeAccountAfterRead(String file){
        fileController.CloseFileAfterWrite();
    }

}
