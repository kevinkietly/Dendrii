package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPage extends JPanel implements ColourRepository, FontRepository {
    private static final Dimension BUTTON_DIMENSIONS = new Dimension(500, 50);

    private JPanel buttonsPanel;

    public PlayPage() throws IOException {
        setLayout(new GridBagLayout());
        setBackground(LIGHT_YELLOW);
        initializeTitlePanel();
        initializePlayLabel();
        initializeButtonsPanel();
    }

    private void initializeTitlePanel() {
        JPanel titlePanel = new JPanel(new GridBagLayout());
        JButton backButton = new JButton("ᐸ");
        JLabel titleLabel = new JLabel("Let's play a game!");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        titlePanel.setPreferredSize(new Dimension(1440, 150));
        titlePanel.setBackground(ACCENT_COLOUR);
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
        gridBagConstraints.insets = new Insets(-50, 0, 100, 0);
        add(titlePanel, gridBagConstraints);
    }

    private void initializePlayLabel() throws IOException {
        BufferedImage playImage = ImageIO.read(new File("./images/Play.png"));
        ImageIcon playIcon = new ImageIcon(playImage);
        JLabel playLabel = new JLabel("What do you want to improve?", playIcon, SwingConstants.CENTER);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        playLabel.setFont(HELVETICA_NEUE_LIGHT_HEADING_BOLD);
        playLabel.setForeground(ACCENT_COLOUR);
        playLabel.setVerticalTextPosition(SwingConstants.CENTER);
        playLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        playLabel.setIconTextGap(100);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 50, 0);
        add(playLabel, gridBagConstraints);
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

    private void initializeButtonsPanel() {
        buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        buttonsPanel.setPreferredSize(new Dimension(1440, 150));
        buttonsPanel.setBackground(LIGHT_YELLOW);
        initializeCognitiveAbilityButton();
        initializeMemoryButton();
        initializeReflexButton();
        initializePersonalRecordsButton();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(50, 0, 0, 0);
        add(buttonsPanel, gridBagConstraints);
    }

    private void initializeCognitiveAbilityButton() {
        JButton cognitiveAbilityButton = new JButton("Cognitive Ability");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        cognitiveAbilityButton.setPreferredSize(BUTTON_DIMENSIONS);
        cognitiveAbilityButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        cognitiveAbilityButton.setForeground(Color.WHITE);
        cognitiveAbilityButton.setBackground(ACCENT_COLOUR);
        cognitiveAbilityButton.addActionListener(event -> initializeChessPage());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 50, 25);
        buttonsPanel.add(cognitiveAbilityButton, gridBagConstraints);
    }

    private void initializeMemoryButton() {
        JButton memoryButton = new JButton("Memory");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        memoryButton.setPreferredSize(BUTTON_DIMENSIONS);
        memoryButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        memoryButton.setForeground(Color.WHITE);
        memoryButton.setBackground(ACCENT_COLOUR);
        memoryButton.addActionListener(event -> new CardMatchingGame());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 25, 50, 0);
        buttonsPanel.add(memoryButton, gridBagConstraints);
    }

    private void initializeReflexButton() {
        JButton reflexButton = new JButton("Reflex");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        reflexButton.setPreferredSize(BUTTON_DIMENSIONS);
        reflexButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        reflexButton.setForeground(Color.WHITE);
        reflexButton.setBackground(ACCENT_COLOUR);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 25);
        buttonsPanel.add(reflexButton, gridBagConstraints);
    }

    private void initializePersonalRecordsButton() {
        JButton personalRecordsButton = new JButton("View Personal Records");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        personalRecordsButton.setPreferredSize(BUTTON_DIMENSIONS);
        personalRecordsButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        personalRecordsButton.setForeground(ACCENT_COLOUR);
        personalRecordsButton.addActionListener(event -> {
            try {
                initializePersonalRecordsPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 25, 0, 0);
        buttonsPanel.add(personalRecordsButton, gridBagConstraints);
    }

    private void initializeChessPage() {
        ChessPage chessPage = new ChessPage();
        SwingUtilities.getWindowAncestor(this).add(chessPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }

    private void initializeCardMatchingGame() {

    }

    private void initializePersonalRecordsPage() throws IOException {
        PersonalRecordsPage personalRecordsPage = new PersonalRecordsPage();
        SwingUtilities.getWindowAncestor(this).add(personalRecordsPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }
}
