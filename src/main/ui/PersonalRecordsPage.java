package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PersonalRecordsPage extends JPanel implements ColourRepository, FontRepository {
    private JPanel chartPanel;

    public PersonalRecordsPage() throws IOException {
        setLayout(new GridBagLayout());
        setBackground(LIGHT_YELLOW);
        initializeTitlePanel();
        initializeChartPanel();
    }

    private void initializeTitlePanel() {
        JPanel titlePanel = new JPanel(new GridBagLayout());
        JButton backButton = new JButton("ᐸ");
        JLabel titleLabel = new JLabel("Personal Records");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        titlePanel.setPreferredSize(new Dimension(1440, 150));
        titlePanel.setBackground(ACCENT_COLOUR);
        backButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addActionListener(event -> {
            try {
                initializePlayPage();
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

    private void initializeChartPanel() throws IOException {
        chartPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        initializeChartLabels();
        chartPanel.setPreferredSize(new Dimension(1440, 500));
        chartPanel.setBackground(LIGHT_YELLOW);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(chartPanel, gridBagConstraints);
    }

    private void initializeChartLabels() throws IOException {
        BufferedImage cognitiveAbilityImage = ImageIO.read(new File("./images/Cognitive_Ability.png"));
        ImageIcon cognitiveAbilityIcon = new ImageIcon(cognitiveAbilityImage);
        JLabel cognitiveAbilityLabel = new JLabel("Cognitive Ability", cognitiveAbilityIcon, SwingConstants.CENTER);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        cognitiveAbilityLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        cognitiveAbilityLabel.setForeground(ACCENT_COLOUR);
        cognitiveAbilityLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        cognitiveAbilityLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        cognitiveAbilityLabel.setIconTextGap(50);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(150, 0, 0, 100);
        chartPanel.add(cognitiveAbilityLabel, gridBagConstraints);

        BufferedImage memoryImage = ImageIO.read(new File("./images/Memory.png"));
        ImageIcon memoryIcon = new ImageIcon(memoryImage);
        JLabel memoryLabel = new JLabel("Memory", memoryIcon, SwingConstants.CENTER);
        memoryLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        memoryLabel.setForeground(ACCENT_COLOUR);
        memoryLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        memoryLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        memoryLabel.setIconTextGap(50);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.insets = new Insets(150, 0, 0, 0);
        chartPanel.add(memoryLabel, gridBagConstraints);

        BufferedImage reflexImage = ImageIO.read(new File("./images/Reflex.png"));
        ImageIcon reflexIcon = new ImageIcon(reflexImage);
        JLabel reflexLabel = new JLabel("Reflex", reflexIcon, SwingConstants.CENTER);
        reflexLabel.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        reflexLabel.setForeground(ACCENT_COLOUR);
        reflexLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        reflexLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        reflexLabel.setIconTextGap(50);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new Insets(150, 100, 0, 0);
        chartPanel.add(reflexLabel, gridBagConstraints);
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
}
