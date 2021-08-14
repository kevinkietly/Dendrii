package ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChessPage extends JPanel implements ColourRepository, FontRepository {

    public ChessPage() {
        setLayout(new GridBagLayout());
        setBackground(LIGHT_YELLOW);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        initializeLabel();
        initializeHelpButton();
        JButton backButton = new JButton("ᐸ");
        backButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        backButton.setForeground(ACCENT_COLOUR);
        backButton.setPreferredSize(new Dimension(50, 50));
        backButton.addActionListener(event -> {
            try {
                initializePlayPage();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 50);
        add(backButton, gridBagConstraints);
    }

    private void initializeLabel() {
        JLabel label = new JLabel("This feature is not ready yet. Please visit chess.com as an alternative.");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        label.setFont(HELVETICA_NEUE_LIGHT_HEADING_BOLD);
        label.setForeground(ACCENT_COLOUR);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(label, gridBagConstraints);
    }

    private void initializeHelpButton() {
        JButton helpButton = new JButton("?");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        helpButton.setFont(HELVETICA_NEUE_LIGHT_SUBHEADING_BOLD);
        helpButton.setForeground(ACCENT_COLOUR);
        helpButton.setPreferredSize(new Dimension(50, 50));
        helpButton.addActionListener(event -> JOptionPane.showMessageDialog(null,
                "Research has shown that playing chess can protect against the development of dementia" +
                        " (Lillo-Crespo et al., 2019)."));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0, 0, -650, -1200);
        add(helpButton, gridBagConstraints);
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
