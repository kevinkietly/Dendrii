package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LearnPage extends JPanel implements ColourRepository, FontRepository {

    public LearnPage() throws IOException {
        setPreferredSize(new Dimension(1440, 847));
        setLayout(new GridBagLayout());
        setBackground(new Color(248, 245, 185));
        BufferedImage learnImage = ImageIO.read(new File("./images/Learn.jpg"));
        ImageIcon learnIcon = new ImageIcon(learnImage);
        JLabel learnLabel = new JLabel(learnIcon);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(learnLabel, gridBagConstraints);
        JButton backButton = new JButton("ᐸ");
        backButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        backButton.setForeground(ACCENT_COLOUR);
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addActionListener(event -> {
            try {
                initializeHomePage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 0;
        add(backButton, gridBagConstraints);
    }

    private void initializeHomePage() throws IOException {
        HomePage homePage = new HomePage();
        SwingUtilities.getWindowAncestor(this).add(homePage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }
}
