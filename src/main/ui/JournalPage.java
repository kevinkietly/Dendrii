package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JournalPage extends JPanel implements ColourRepository, FontRepository {

    public JournalPage() throws IOException {
        setLayout(new GridBagLayout());
        setBackground(LIGHT_YELLOW);
        initializeTitlePanel();
        initializeMoodPanel();
    }

    private void initializeTitlePanel() {
        JPanel titlePanel = new JPanel(new GridBagLayout());
        JButton backButton = new JButton("ᐸ");
        JLabel titleLabel = new JLabel("How are you feeling?");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        titlePanel.setPreferredSize(new Dimension(1440, 150));
        titlePanel.setBackground(ACCENT_COLOUR);
        backButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addActionListener(event -> {
            try {
                initializeHomePage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        titleLabel.setFont(HELVETICA_NEUE_LIGHT_HEADING_BOLD);
        titleLabel.setForeground(Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, -750, 0, 0);
        titlePanel.add(backButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        titlePanel.add(titleLabel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new Insets(-150, 0, 50, 0);
        add(titlePanel, gridBagConstraints);
    }

    private void initializeMoodPanel() throws IOException {
        JPanel moodPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        BufferedImage moodImage = ImageIO.read(new File("./images/Mood.png"));
        ImageIcon moodIcon = new ImageIcon(moodImage);
        JLabel moodLabel = new JLabel("Select Your Mood", moodIcon, SwingConstants.CENTER);
        moodPanel.setBackground(LIGHT_YELLOW);
        moodLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        moodLabel.setForeground(ACCENT_COLOUR);
        moodLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        moodLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 100);
        moodPanel.add(moodLabel, gridBagConstraints);
        BufferedImage thoughtImage = ImageIO.read(new File("./images/Thought.png"));
        ImageIcon thoughtIcon = new ImageIcon(thoughtImage);
        JLabel thoughtLabel = new JLabel("Record Your Thoughts", thoughtIcon, SwingConstants.CENTER);
        thoughtLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        thoughtLabel.setForeground(ACCENT_COLOUR);
        thoughtLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        thoughtLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(0, 100, 0, 0);
        moodPanel.add(thoughtLabel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(moodPanel, gridBagConstraints);
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
