package ui;

import javax.swing.*;
import java.io.IOException;

public class MainWindow extends JFrame {
    private HomePage homePage;

    public MainWindow() throws IOException {
        super("Dendrii");
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        initializeHomePage();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeHomePage() throws IOException {
        homePage = new HomePage();
        add(homePage);
    }
}
