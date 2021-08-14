package ui;

import model.NameCard;
import model.PhotoCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardMatchingGame implements ActionListener {
    private JFrame frame;
    CardLayout card;

    private int WIDTH = 1000;
    private int HEIGHT = 750;

    //number of cards
    private final int NUM = 8;
    public int myelin = 0;

    //when selecting the pair of cards in game
    private NameCard selectedName;
    private PhotoCard selectedPhoto;
    private int selected = 0;

    private PhotoCard ethan;
    private PhotoCard winnie;
    private PhotoCard amy;
    private PhotoCard jubelle;
    private PhotoCard terry;
    private PhotoCard polina;
    private PhotoCard kevin;
    private PhotoCard jason;

    private NameCard ethanN;
    private NameCard winnieN;
    private NameCard amyN;
    private NameCard jubelleN;
    private NameCard terryN;
    private NameCard polinaN;
    private NameCard kevinN;
    private NameCard jasonN;

    //lists of cards
    private PhotoCard[] lop;
    private NameCard[] lon;

    //lists of photo buttons
    private ArrayList<JButton> lopb = new ArrayList<JButton>(8);
    //lists of name buttons
    private ArrayList<JButton> lonb = new ArrayList<JButton>(8);

    //selection process
    private int cardsSelected = 0;
    private String photoCardSelected = "";
    private String nameCardSelected = "";


    public CardMatchingGame() {
        runApp();
    }

    private void runApp() {
        initCards();
        setUpFrame();
        displayStart();
        frame.setVisible(true);
    }

    // sets up frame
    private void setUpFrame() {
        frame = new JFrame();
        frame.setTitle("Card Matching Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        card = new CardLayout();
        frame.getContentPane().setLayout(card);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
    }

    // displays start menu
    private void displayStart() {
        JPanel panel_tmp = new JPanel(new GridLayout(4, 0)); // can add layout to this to add a picture
        JLabel banner = new JLabel("CARD MATCH", SwingConstants.CENTER);
        banner.setFont(new Font(banner.getFont().toString(),Font.BOLD, 100));
        panel_tmp.add(banner);
        panel_tmp.add(startButton());
        panel_tmp.add(homeButton());
        panel_tmp.add(whyButton());
        frame.getContentPane().add(panel_tmp);
    }

    // home button w/o action listener
    private JButton homeButton() {
        JButton home = new JButton("HOME");
        home.setFont(new Font(home.getFont().toString(),Font.BOLD,60));
        home.setBackground(Color.white);
//        awaits integration
//        home.addActionListener(e -> home());
        return home;
    }

    // start button w/ action listener
    private JButton startButton() {
        JButton start = new JButton("START");
        start.setFont(new Font(start.getFont().toString(),Font.BOLD,80));
        start.setBackground(Color.orange);
        start.addActionListener(e -> playGame());
        return start;
    }

    // why play this game? w/ action listener
    private JButton whyButton() {
        JButton why = new JButton("WHY PLAY?");
        why.setFont(new Font(why.getFont().toString(),Font.BOLD,80));
        why.setBackground(Color.orange);
        why.addActionListener(e -> whyPlay());
        return why;
    }

    private void whyPlay() {
        popup("This game is great because it can help you remember your loved ones!", "Why Play This Game?");
    }

    // sets up game panels, goes to next card panel (game)
    private void playGame() {
        setUpGame();
        card.next(frame.getContentPane());
    }

    // sets up area for game
    private void setUpGame() {
        JPanel back = new JPanel(new GridLayout(0, 2));
        //based on 7 cards, can be changed
        JPanel left = new JPanel(new GridLayout(4, 2));
        JPanel right = new JPanel(new GridLayout(4, 2));
        left.setBackground(Color.orange); // I set these different colours to see if it works
        right.setBackground(Color.white); // I set these different colours to see if it works
        back.add(left);
        back.add(right);
        frame.getContentPane().add(back);

        makePhotoButton(left);
        makeNameButton(right);
    }

    private void makePhotoButton(JPanel panel) {
        for (int i = 0; i < NUM; i++) {
            final JButton button = new JButton();
            button.setName(lop[i].getName());
            button.setIcon(new ImageIcon(lop[i].getPhoto_path()));
//            ImageIcon photo = new ImageIcon(lop[i].getPhoto_path());
//            Image resizedPhoto = photo.getImage();
//            resizedPhoto.getScaledInstance(50, -1, Image. SCALE_SMOOTH);
//            button.setIcon((Icon) resizedPhoto);

            button.addActionListener(e -> photoButtonClicked(button));
            panel.add(button);
            lopb.add(button);
        }
    }

    private void photoButtonClicked(JButton button) {
        photoCardSelected = button.getName();
        checkCorrect();
    }

    private void makeNameButton(JPanel panel) {
        for (int i = 0; i < NUM; i++) {
            final JButton button = new JButton(lon[i].getName());
            button.setName(lon[i].getName());
            button.addActionListener(e -> nameButtonClicked(button));
//            button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            panel.add(button);
            lonb.add(button);
        }
    }

    private void nameButtonClicked(JButton button) {
        nameCardSelected = button.getName();
        checkCorrect();
    }

    private void checkCorrect() {
        if (photoCardSelected.equals(nameCardSelected)) {
            popup("Correct!", "You Are...");
            resetSelected();
        } else if (!photoCardSelected.equals(nameCardSelected) &&
                !photoCardSelected.equals("") && !nameCardSelected.equals("")) {
            popup("Try again!", "Aw...");
            photoCardSelected = "";
            nameCardSelected = "";
        }
    }

    private void resetSelected() {
        for (int i = 0;i < NUM; i++){
            if(lopb.get(i).getName().equals(photoCardSelected)){
                lopb.get(i).setEnabled(false);
            }
        }
        for (int i = 0;i < NUM; i++){
            if(lonb.get(i).getName().equals(nameCardSelected)){
                lonb.get(i).setEnabled(false);
            }
        }
        photoCardSelected = "";
        nameCardSelected = "";

        if (checkWon()){
            popup("Congrats! You have won the game."+"/n"
                    +" You have earned 15 Myelin! " , "");
            myelin +=15;
        }
    }

    private boolean checkWon(){
        int buttonsPressed = 0;
        for(JButton button:lopb){
            if(!button.isEnabled()){
                buttonsPressed++;
            }
        }

        if (buttonsPressed == NUM){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void initCards() {
        ethan = new PhotoCard("Ethan", "./images/Ethan smaller.jpeg");
        winnie = new PhotoCard("Winnie", "./images/Winnie smaller.jpeg");
        amy = new PhotoCard("Amy", "./images/Amy smaller.jpeg");
        jubelle = new PhotoCard("Jubelle", "./images/Jubelle smaller.jpeg");
        terry = new PhotoCard("Terry", "./images/Terry smaller.JPG");
        polina = new PhotoCard("Polina", "./images/Polina smaller.jpeg");
        kevin = new PhotoCard("Kevin", "./images/Kevin smaller.jpeg");
        jason = new PhotoCard("Jason", "./images/Jason smaller.jpeg");
        lop = new PhotoCard[]{ethan, winnie, amy, jubelle, terry, polina, kevin, jason};
        Collections.shuffle(Arrays.asList(lop));

        ethanN = new NameCard("Ethan");
        winnieN = new NameCard("Winnie");
        amyN = new NameCard("Amy");
        jubelleN = new NameCard("Jubelle");
        terryN = new NameCard("Terry");
        polinaN = new NameCard("Polina");
        kevinN = new NameCard("Kevin");
        jasonN = new NameCard("Jason");
        lon = new NameCard[]{ethanN, winnieN, amyN, jubelleN, terryN, polinaN, kevinN, jasonN};
        Collections.shuffle(Arrays.asList(lon));
    }

    //EFFECTS: create a pop up message box
    private void popup(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
