package ui;

import model.Pet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePage extends JPanel implements ColourRepository, FontRepository {
    private static final Insets BUTTON_INSETS = new Insets(0, 0, 50, 0);
    private static final Dimension BUTTON_DIMENSIONS = new Dimension(500, 50);

    private Pet pet;

    public HomePage() throws IOException {
        setPreferredSize(new Dimension(1440, 847));
        setLayout(new GridBagLayout());
        setBackground(LIGHT_YELLOW);
        setBorder(new EmptyBorder(0, 100, 0, 100));
        initializePet();
        initializeHeart();
        initializeToDoList();
        initializeHealthBar();
        initializePlayButton();
        initializeJournalButton();
        initializeLearnButton();
        initializeShopButton();
    }

    private void initializePet() throws IOException {
        pet = new Pet();
        JPanel petPanel = new JPanel();
        BufferedImage petImage = ImageIO.read(new File("./images/Pet.png"));
        ImageIcon petIcon = new ImageIcon(petImage);
        JLabel petLabel = new JLabel("Keep me healthy by doing today's to-dos.", petIcon, SwingConstants.CENTER);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        petPanel.setBackground(LIGHT_YELLOW);
        petLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        petLabel.setForeground(ACCENT_COLOUR);
        petLabel.setVerticalTextPosition(SwingConstants.TOP);
        petLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        petLabel.setIconTextGap(-100);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        petPanel.add(petLabel, gridBagConstraints);
        add(petPanel, gridBagConstraints);
    }

    private void initializeHeart() throws IOException {
        BufferedImage heartImage = ImageIO.read(new File("./images/Heart.png"));
        ImageIcon heartIcon = new ImageIcon(heartImage);
        JLabel heartLabel = new JLabel(heartIcon);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, -375, -375, 0);
        add(heartLabel, gridBagConstraints);
    }

    private void initializeToDoList() {
        JPanel toDoListPanel = new JPanel(new GridBagLayout());
        JLabel toDoListLabel = new JLabel("TO-DO");
        JLabel task1 = new JLabel("• " + pet.getNeeds().get(0));
        JLabel task2 = new JLabel("• " + pet.getNeeds().get(1));
        JLabel task3 = new JLabel("• " + pet.getNeeds().get(2));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        toDoListPanel.setPreferredSize(new Dimension(400, 350));
        toDoListPanel.setBackground(ACCENT_COLOUR);
        toDoListLabel.setFont(FUTURA);
        toDoListLabel.setForeground(Color.WHITE);
        task1.setForeground(Color.WHITE);
        task1.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        task2.setForeground(Color.WHITE);
        task2.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        task3.setForeground(Color.WHITE);
        task3.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(25, 0, 50, 0);
        toDoListPanel.add(toDoListLabel, gridBagConstraints);
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0, 0, 50, 0);
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        toDoListPanel.add(task1, gridBagConstraints);
        gridBagConstraints.gridy = 3;
        toDoListPanel.add(task2, gridBagConstraints);
        gridBagConstraints.gridy = 4;
        toDoListPanel.add(task3, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        add(toDoListPanel, gridBagConstraints);
    }

    private void initializeHealthBar() {
        JProgressBar healthBar = new JProgressBar();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        healthBar.setPreferredSize(new Dimension(400, 50));
        healthBar.setForeground(Color.RED);
        healthBar.setBackground(Color.WHITE);
        healthBar.setValue(pet.getHealth());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, -350, 0);
        add(healthBar, gridBagConstraints);
    }


    private void initializePlayButton() {
        JButton playButton = new JButton("Play");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        playButton.setPreferredSize(BUTTON_DIMENSIONS);
        playButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(ACCENT_COLOUR);
        playButton.addActionListener(event -> {
            try {
                initializePlayPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = BUTTON_INSETS;
        add(playButton, gridBagConstraints);
    }

    private void initializeJournalButton() {
        JButton journalButton = new JButton("Journal");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        journalButton.setPreferredSize(BUTTON_DIMENSIONS);
        journalButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        journalButton.setForeground(Color.WHITE);
        journalButton.setBackground(ACCENT_COLOUR);
        journalButton.addActionListener(event -> {
            try {
                initializeJournalPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = BUTTON_INSETS;
        add(journalButton, gridBagConstraints);
    }

    private void initializeLearnButton() {
        JButton learnButton = new JButton("Learn");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        learnButton.setPreferredSize(BUTTON_DIMENSIONS);
        learnButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        learnButton.setForeground(Color.WHITE);
        learnButton.setBackground(ACCENT_COLOUR);
        learnButton.addActionListener(event -> {
            try {
                initializeLearnPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = BUTTON_INSETS;
        add(learnButton, gridBagConstraints);
    }

    private void initializeShopButton() {
        JButton shopButton = new JButton("Shop");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        shopButton.setPreferredSize(BUTTON_DIMENSIONS);
        shopButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        shopButton.setForeground(Color.WHITE);
        shopButton.setBackground(ACCENT_COLOUR);
        shopButton.addActionListener(event -> {
            try {
                initializeShopPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = BUTTON_INSETS;
        add(shopButton, gridBagConstraints);
    }

    private void initializePlayPage() throws IOException {
        PlayPage playPage = new PlayPage();
        SwingUtilities.getWindowAncestor(this).add(playPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }

    private void initializeJournalPage() throws IOException {
        JournalPage journalPage = new JournalPage();
        SwingUtilities.getWindowAncestor(this).add(journalPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }

    private void initializeLearnPage() throws IOException {
        LearnPage learnPage = new LearnPage();
        SwingUtilities.getWindowAncestor(this).add(learnPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }

    private void initializeShopPage() throws IOException {
        ShopPage shopPage = new ShopPage();
        SwingUtilities.getWindowAncestor(this).add(shopPage);
        revalidate();
        repaint();
        SwingUtilities.getWindowAncestor(this).remove(this);
        revalidate();
        repaint();
    }
}
