package ui;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import javax.swing.*;
import java.io.IOException;

public class Dendrii {

    public static void main(String[] args) throws IOException {
        FlatArcOrangeIJTheme.install();
        UIManager.put("Button.arc", 999);
        new MainWindow();
    }
}
