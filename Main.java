package Cricket4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Player {
    int Rating;
    String name;
    String nationality;
    String role;
    String imagePath;
    boolean selected = false;

    public Player(String name, String role, int Rating, String imagePath) {
        this.name = name;
        this.role = role;
        this.Rating = Rating;
        this.imagePath = imagePath;
        this.selected = false;
    }
}

class Team {
    String teamName;
    String nationality;
    Player[] players;

    public Team(String teamName, String nationality, Player[] players) {
        this.teamName = teamName;
        this.nationality = nationality;
        this.players = players;
    }
}


class LoginScreen extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Define admins and passwords
    private String[] admins = {"arpan", "piyush", "krish","user"};
    private String[] passwords = {"arpan123", "piyush123", "krish123","user123"};

    public LoginScreen() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Username field
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        add(usernamePanel);

        // Password field
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        add(passwordPanel);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        // Check if the provided credentials match any admin
        for (int i = 0; i < admins.length; i++) {
            if (username.equals(admins[i]) && password.equals(passwords[i])) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticate(username, password)) {
                // Authentication successful
                dispose(); // Close the login window
                new Main(); // Start the main application
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
            }
        }
    }
}

class WelcomeScreen extends JFrame implements ActionListener {
    private JButton startButton;
    private JButton exitButton;

    public WelcomeScreen() {
        setTitle("Cricket Team Selection System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1)); // Increase rows to make the welcome screen larger

        // Create a panel for the welcome message
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel welcomeLabel = new JLabel("Welcome to Cricket Team Selection System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Decrease font size
        welcomePanel.add(welcomeLabel);

        // Add padding around the welcome panel
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add the welcome panel to the JFrame
        add(welcomePanel);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1)); // Two rows for buttons
        buttonPanel.setPreferredSize(new Dimension(200, 100)); // Set preferred size for button panel

        // Create and add Start button
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size for start button
        buttonPanel.add(startButton);

        // Create and add Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setPreferredSize(new Dimension(150, 30)); // Set preferred size for exit button
        buttonPanel.add(exitButton);

        // Add padding around the button panel
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add the button panel to the JFrame
        add(buttonPanel);

        pack(); // Pack the components to fit the JFrame
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            dispose(); // Close the welcome screen
            new Main(); // Open the main frame for team selection
        } else if (e.getSource() == exitButton) {
            System.exit(0); // Exit the program
        }
    }
}

public class Main extends JFrame implements ActionListener {
    private JComboBox<String> teamComboBox;
    private JTextArea playerTextArea;
    private JButton selectButton;
    private Player[] selectedPlayers;
    private Team[] teams;

    public Main() {
        setTitle("Cricket Team Selection System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(680, 480));

        // Initialize teams and players
        Player[] indianPlayers = new Player[20];
        Player[] australianPlayers = new Player[20];
        Player[] westIndiesPlayers = new Player[20];
        Player[] englandPlayers = new Player[20];
        Player[] newZealandPlayers = new Player[19];
        Player[] pakistanPlayers = new Player[20];
        Player[] srilankaPlayers = new Player[19];
        Player[] bangaladeshPlayers = new Player[20];
        Player[] southAfricaPlayers = new Player[20];
        Player[] afghanistanPlayers = new Player[18];

        // Initialize other teams and players...

        Team australianTeam = new Team("Australia","AUS", australianPlayers);
        Team indianTeam = new Team("India","IND", indianPlayers);
        Team westIndiesTeam = new Team("West Indies", "WI", westIndiesPlayers);
        Team englandTeam = new Team("England", "ENG", englandPlayers);
        Team newZealandTeam = new Team("New Zealand", "NZ", newZealandPlayers);
        Team pakistanTeam = new Team("Pakistan", "PAK", pakistanPlayers);
        Team srilankaTeam = new Team("Sri Lanka", "SL", srilankaPlayers);
        Team bangaladeshTeam = new Team("Bangladesh", "BAN", bangaladeshPlayers);
        Team southAfricaTeam = new Team("South Africa", "SA", southAfricaPlayers);
        Team afghanistanTeam = new Team("Afghanistan", "AFG", afghanistanPlayers);

        indianPlayers[0] = new Player("Rohit Sharma","Batsman",90,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0171.jpg");
        indianPlayers[1] = new Player("Virat Kohli","Batsman",93,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0169.jpg");
        indianPlayers[2] = new Player("Shikhar Dhawan","Batsman",83,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0167.jpg");
        indianPlayers[3] = new Player("Shubman Gill","Batsman",81,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0166.jpg");
        indianPlayers[4] = new Player("Ruturaj Gaikwad","Batsman",81,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0163.jpg");
        indianPlayers[5] = new Player("Yashashvi Jaiswal","Batsman",80,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0168.jpg");
        indianPlayers[6] = new Player("Rinku Singh","Batsman",80,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0164.jpg");
        indianPlayers[7] = new Player("Suryakumar Yadav","Batsman",81,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0165.jpg");
        indianPlayers[8] = new Player("K.L.Rahul","Wicket-Keeper",87,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0160.jpg");
        indianPlayers[9] = new Player("Ishan Kishan","Wicket-Keeper",81,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0162.jpg");
        indianPlayers[10] = new Player("Rishabh Pant","Wicket-Keeper",84,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0157.jpg");
        indianPlayers[11] = new Player("Hardik Pandya","All-Rounder",85,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0158.jpg");
        indianPlayers[12] = new Player("Ravindra Jadeja","All-Rounder",87,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0161.jpg");
        indianPlayers[13] = new Player("Ravinchandra Ashwin","All-Rounder",86,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0159.jpg");
        indianPlayers[14] = new Player("Bhuvaneshwar Kumar","Bowler",82,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0152.jpg");
        indianPlayers[15] = new Player("Kuldeep Yadav","Bowler",87,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0155.jpg");
        indianPlayers[16] = new Player("Yuzvendra Chahal","Bowler",84,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0156.jpg");
        indianPlayers[17] = new Player("Jasprit Bumrah","Bowler",92,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0154.jpg");
        indianPlayers[18] = new Player("Mohammed Shami","Bowler",90,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240407-WA0004.jpg");
        indianPlayers[19] = new Player("Mohammed Siraj","Bowler",84,"E:\\Cricket4\\JP projectImages\\Players\\india team\\IMG-20240406-WA0153.jpg");

        australianPlayers[0] = new Player("David Warner","Batsman",90,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0151.jpg");
        australianPlayers[1] = new Player("Marnus Labuschagne","Batsman",86,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0147.jpg");
        australianPlayers[2] = new Player("Steven Smith","Batsman",87,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0149.jpg");
        australianPlayers[3] = new Player("Travis Head","Batsman",86,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0150.jpg");
        australianPlayers[4] = new Player("Cameron Green","All-Rounder",83,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0148.jpg");
        australianPlayers[5] = new Player("Glenn Maxwell","All-Rounder",85,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0145.jpg");
        australianPlayers[6] = new Player("Marcus Stoinis","All-Rounder",84,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0146.jpg");
        australianPlayers[7] = new Player("Mitchell Marsh","All-Rounder",82,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0144.jpg");
        australianPlayers[8] = new Player("Sean Abbott","All-Rounder",77,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0139.jpg");
        australianPlayers[9] = new Player("Alex-Carey","Wicket-Keeper",80,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0138.jpg");
        australianPlayers[10] = new Player("Josh Inglis","Wicket-Keeper",81,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0142.jpg");
        australianPlayers[11] = new Player("Adam Zampa","Bowler",81,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0143.jpg");
        australianPlayers[12] = new Player("Josh Hazlewood","Bowler",84,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0141.jpg");
        australianPlayers[13] = new Player("Mitchell Starc","Bowler",92,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0140.jpg");
        australianPlayers[14] = new Player("Pat Cummins","Bowler",88,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0135.jpg");
        australianPlayers[15] = new Player("Usman Khwaja","Batsman",82,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0137.jpg");
        australianPlayers[16] = new Player("Nathan Lyon","Bowler",87,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0132.jpg");
        australianPlayers[17] = new Player("Scott Boland","Bowler",80,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0136.jpg");
        australianPlayers[18] = new Player("Matt Renshaw","Batsman",78,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0133.jpg");
        australianPlayers[19] = new Player("Nathan Ellis","Bowler",80,"E:\\Cricket4\\JP projectImages\\Players\\australia team\\IMG-20240406-WA0134.jpg");


        westIndiesPlayers[0] = new Player("Kraigg Braithwate","Batsman",79,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0130.jpg");
        westIndiesPlayers[1] = new Player("Tagenarine Chanderpaul","Batsman",80,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0131.jpg");
        westIndiesPlayers[2] = new Player("Kirk McKenzie","Batsman",78,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0129.jpg");
        westIndiesPlayers[3] = new Player("Joshua Da Silva","Wicket-Keeper",77,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0124.jpg");
        westIndiesPlayers[4] = new Player("Alick Athanaze","All-Rounder",74,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0125.jpg");
        westIndiesPlayers[5] = new Player("Justin Greaves","All-Rounder",76,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0127.jpg");
        westIndiesPlayers[6] = new Player("Kavem Hodge","All-Rounder",74,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0126.jpg");
        westIndiesPlayers[7] = new Player("Shai Hope","Batsman",77,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240407-WA0009.jpg");
        westIndiesPlayers[8] = new Player("Teddy Bishop","Batsman",84,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0128.jpg");
        westIndiesPlayers[9] = new Player("Kjorn Ottey","Batsman",74,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0120.jpg");
        westIndiesPlayers[10] = new Player("Keacy Carty","Batsman",76,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0121.jpg");
        westIndiesPlayers[11] = new Player("Rovman Powell","Batsman",78,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0122.jpg");
        westIndiesPlayers[12] = new Player("Brandon King","Batsman",80,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0123.jpg");
        westIndiesPlayers[13] = new Player("Nicholas Pooran","Wicket-Keeper",83,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0118.jpg");
        westIndiesPlayers[14] = new Player("Andre Russell","All-Rounder",87,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0116.jpg");
        westIndiesPlayers[15] = new Player("Alzarri Joseph","Bowler",81,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0117.jpg");
        westIndiesPlayers[16] = new Player("Akeal Hosein","Bowler",77,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0114.jpg");
        westIndiesPlayers[17] = new Player("Kemar Roach","Bowler",83,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0115.jpg");
        westIndiesPlayers[18] = new Player("Shamar Joseph","Bowler",79,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0119.jpg");
        westIndiesPlayers[19] = new Player("Tevin Imlach","Bowler",72,"E:\\Cricket4\\JP projectImages\\Players\\west indies team\\IMG-20240406-WA0113.jpg");
        
        // Initialize other teams...
        
        
                englandPlayers[0]  = new Player(" Zak Crawley           ","Batsman      ", 78,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0094.jpg");
                englandPlayers[1]  = new Player(" Joe Root              ","Batsman      ", 88,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0106.jpg");
                englandPlayers[2]  = new Player(" Harry Brook           ","Batsman      ", 72,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0101.jpg");
                englandPlayers[3]  = new Player(" Ollie Pope            ","Batsman      ", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0091.jpg");
                englandPlayers[4]  = new Player(" Ben Duckett           ","Batsman      ", 77,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0098.jpg");
                englandPlayers[5]  = new Player(" Alex Hales            ","Batsman      ", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0104.jpg");
                englandPlayers[6]  = new Player(" Dan Lawrence          ","Batsman      ", 77,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0091.jpg");
                englandPlayers[7]  = new Player(" Jonny Bairstow        ","Wicket-Keeper", 81,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0108.jpg");
                englandPlayers[8]  = new Player(" Ben Foakes            ","Wicket-Keeper", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0105.jpg");
                englandPlayers[9]  = new Player(" Jos Buttler           ","Wicket-Keeper", 88,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0107.jpg");
                englandPlayers[10] = new Player("Phil Salt             ","Wicket-Keeper", 81,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0110.jpg");
                englandPlayers[11] = new Player("Liam Livingstone      ","All-Rounder  ", 82,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0109.jpg");
                englandPlayers[12] = new Player("Ben Stokes            ","All-Rounder  ", 87,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0102.jpg");
                englandPlayers[13] = new Player("Sam Curran            ","All-Rounder   ", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0093.jpg");
                englandPlayers[14] = new Player("James Anderson        ","Bowler       ", 92,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0103.jpg");
                englandPlayers[15] = new Player("Mark Wood             ","Bowler       ", 87,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0096.jpg");
                englandPlayers[16] = new Player("Gus Atkinson          ","Bowler       ", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0092.jpg");
                englandPlayers[17] = new Player("Adil Rashid           ","Bowler       ", 80,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0095.jpg");
                englandPlayers[18] = new Player("Tom Hartley           ","Bowler       ", 78,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0100.jpg");
                englandPlayers[19] = new Player("Josh Tongue           ","Bowler       ", 74,"E:\\Cricket4\\JP projectImages\\Players\\england team\\IMG-20240406-WA0097.jpg");
                
    newZealandPlayers[0]  = new Player(" Henry Nicholls","Batsman", 80,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Henry Nichollas.jpg");
    newZealandPlayers[1]  = new Player(" Will Young","Batsman", 84,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Will Young.jpg");
    newZealandPlayers[2]  = new Player(" Kane Williamson","Batsman", 88,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Kane williamson.jpg");
    newZealandPlayers[3]  = new Player(" Mark Champman","Batsman", 77,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Mark chapman.jpg");
    newZealandPlayers[4]  = new Player(" Finn Allen","Batsman", 74,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Finn Allen.jpg");
    newZealandPlayers[5]  = new Player(" Tim Steifert","Batsman", 74,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Tim seifert.jpg");
    newZealandPlayers[6]  = new Player(" Devon Conway","Wicket-Keeper", 85,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Devon Conway.jpg");
    newZealandPlayers[7]  = new Player(" Tom Latham","Wicket-Keeper", 84,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Tom Latham.jpg");
    newZealandPlayers[8]  = new Player(" Glenn Philips","All-Rounder", 82,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Glenn Philip.jpg");
    newZealandPlayers[9] = new Player("Rachin Ravindra","All-Rounder", 81,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Rachin Ravindra.jpg");
    newZealandPlayers[10] = new Player("Daryl Mitchell","All-Rounder", 84,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Daryl Mitchell.jpg");
    newZealandPlayers[11] = new Player("Mitchell Santner","All-Rounder", 81,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Mitchell Santner.jpg");
    newZealandPlayers[12] = new Player("Tim Southee","Bowler", 87,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Tim southee.jpg");
    newZealandPlayers[13] = new Player("Ben Sears","Bowler", 75,"E:\\Cricket4\\JP projectImages\\Players\\new zealand team\\Ben Sears.jpg");
    newZealandPlayers[14] = new Player("Trent boult","Bowler", 91,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Trent Boult.jpg");
    newZealandPlayers[15] = new Player("Matt Henry","Bowler", 78,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Matt Henry.jpg");
    newZealandPlayers[16] = new Player("Ish Sodhi","Bowler", 77,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Ish Sodhi.jpg");
    newZealandPlayers[17] = new Player("Lockie Ferguson","Bowler", 84,"E:\\Cricket4\\JP projectImages\\Players\\n" + //
                "ew zealand team\\Lockie Ferguson.jpg");
    newZealandPlayers[18] = new Player("Adam Milne","Bowler", 80,"E:\\Cricket4\\JP projectImages\\Players\\new zealand team\\Adam Milne.jpg");
        
    pakistanPlayers[0]  = new Player(" Fakhar Zaman","Batsman", 81,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Fakhar Zaman.jpeg");
    pakistanPlayers[1]  = new Player(" Abdullah Shafique","Batsman", 77,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Abdullah Shafique.jpg");
    pakistanPlayers[2]  = new Player(" Imam-ul-Haq","Batsman", 77,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Imam-ul-Haq.jpg");
    pakistanPlayers[3]  = new Player(" Babar Azam","Batsman", 88,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Babar Azam.jpeg");
    pakistanPlayers[4]  = new Player(" Iftikhar Ahmed","Batsman", 76,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Iftikhar Ahmed.jpeg");
    pakistanPlayers[5]  = new Player(" Saud Shakeel","Batsman", 77,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Saud Shakeel.jpg");
    pakistanPlayers[6]  = new Player(" Mohammed Rizwan","Wicket-Keeper", 84,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Mohammed Rizwan.jpg");
    pakistanPlayers[7]  = new Player(" Sarfaraz Ahmed","Wicket-Keeper", 78,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Sarfaraz Ahmed.jpg");
    pakistanPlayers[8]  = new Player(" Shan Masood","Batsman", 75,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Shan Masood.jpg");
    pakistanPlayers[9]  = new Player(" Agha Salman","All-Rounder", 77,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Agha Salman.jpg");
    pakistanPlayers[10] = new Player("Mohammed Nawaz","All-Rounder", 79,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Mohammed Nawaz.jpg");
    pakistanPlayers[11] = new Player("Shadab Khan","All-Rounder", 78,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Shadab Khan.jpeg");
    pakistanPlayers[12] = new Player("Mohammed Wasim","All-Rounder", 74,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Mohammed Wasim.jpg");
    pakistanPlayers[13] = new Player("Sajid Khan","All-Rounder", 76,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Sajid Khan.jpg");
    pakistanPlayers[14] = new Player("Ihsanullah","Bowler", 76,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Ihsanullah.jpg");
    pakistanPlayers[15] = new Player("Naseem Shah","Bowler", 79,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Naseem Shah.jpg");
    pakistanPlayers[16] = new Player("Usama Mir","Bowler", 77,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Usama Mir.png");
    pakistanPlayers[17] = new Player("Shaheen Afridi","Bowler", 85,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Shaheen Afridi.png");
    pakistanPlayers[18] = new Player("Hasan Ali","Bowler", 80,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Hasan Ali.jpeg");
    pakistanPlayers[19] = new Player("Haris Rauf","Bowler", 81,"E:\\Cricket4\\JP projectImages\\Players\\Pakistan team\\Haris Rauf.jpeg");
        
    srilankaPlayers[0]  = new Player(" Dimuth Karunaratne    ","Batsman      ", 77,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dimuth Karunaratne.jpeg");
    srilankaPlayers[1]  = new Player(" Pathum Nissanka       ","Batsman      ", 81,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Pathum Nissanka.jpeg");
    srilankaPlayers[2]  = new Player(" Kusal Mendis          ","Wicket-Keeper", 80,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Kusal Mendis.jpeg");
    srilankaPlayers[3]  = new Player(" Kusal Perera          ","Wicket-Keeper", 80,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Kusal Perera.jpeg");
    srilankaPlayers[4]  = new Player(" Sadeera Samarawickrama","Wicket-Keeper", 76,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Sadeera Samarawickrama.jpeg");
    srilankaPlayers[5]  = new Player(" Dhasun Nissanka       ","All-Rounder  ", 80,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dhasun Nissanka.png");
    srilankaPlayers[6]  = new Player(" Angelo Matthews       ","All-Rounder  ", 82,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Angelo Matthews.jpg");
    srilankaPlayers[7]  = new Player(" Charith Asalanka      ","All-Rounder  ", 76,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Charith Asalanka.jpeg");
    srilankaPlayers[8]  = new Player(" Dushan Hemantha       ","All-Rounder  ", 74,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dushan Hemantha.jpeg");
    srilankaPlayers[9]  = new Player(" Chamika Karunaratne   ","All-Rounder  ", 79,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Chamika Karunaratne.png");
    srilankaPlayers[10] = new Player("Dhananjaya de Silva   ","All-Rounder  ", 74,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dhananjaya de Silva.jpeg");
    srilankaPlayers[11] = new Player("Maheesh Theekshana    ","Bowler       ", 77,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Maheesh Theekshana.jpeg");
    srilankaPlayers[12] = new Player("Dilshan Madhushanka   ","Bowler       ", 75,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dilshan Madhushanka.jpeg");
    srilankaPlayers[13] = new Player("Dushmantha Chameera   ","Bowler       ", 73,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dushmantha Chameera.jpeg");
    srilankaPlayers[14] = new Player("Kasun Rajitha         ","Bowler       ", 74,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Kasun Rajitha.png");
    srilankaPlayers[15] = new Player("Dunith Wellalage      ","Bowler       ", 77,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Dunith Wellalage.png");
    srilankaPlayers[16] = new Player("Lahiru Kumara         ","Bowler       ", 81,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Lahiru Kumara.jpeg");
    srilankaPlayers[17] = new Player("Matheesha Pathirana   ","Bowler       ", 82,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Matheesha Pathirana.jpeg");
    srilankaPlayers[18] = new Player("Binura Fernando       ","Bowler       ", 77,"E:\\Cricket4\\JP projectImages\\Players\\srilanka team\\Binura Fernando.jpeg");
        
    bangaladeshPlayers[0]  = new Player(" Najmul Hossain Shanto","Batsman", 76,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Najmul Hossain Shanto.jpeg");
    bangaladeshPlayers[1]  = new Player(" Tanzid Hasan","Batsman", 74,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Tanzid Hasan.jpeg");
    bangaladeshPlayers[2]  = new Player(" Towhid Hridoy","Batsman", 73,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Towhid Hridoy.jpeg");
    bangaladeshPlayers[3]  = new Player(" Mominul Haque","Batsman", 77,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mominul Haque.jpeg");
    bangaladeshPlayers[4]  = new Player(" Shahadat Hossain","Batsman", 78,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Shahadat Hossain.jpeg");
    bangaladeshPlayers[5]  = new Player(" Mushfiqur Rahman","Wicket-Keeper", 81,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mushfiqur Rahman.jpeg");
    bangaladeshPlayers[6]  = new Player(" Litton Das","Wicket-Keeper", 77,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Litton Das.jpeg");
    bangaladeshPlayers[7]  = new Player(" Anamul Haque","Wicket-Keeper", 76,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Anamul Haque.jpeg");
    bangaladeshPlayers[8]  = new Player(" Shakib Al Hasan","All-Rounder  ", 87,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Shakib Al Hasan.png");
    bangaladeshPlayers[9]  = new Player(" Mahmudullah","All-Rounder  ", 80,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mahmudullah.jpeg");
    bangaladeshPlayers[10] = new Player(" Mehidy Hasan Miraz","All-Rounder  ", 75,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mehidy Hasan Miraz.jpeg");
    bangaladeshPlayers[11] = new Player("Mahedi Hasan","All-Rounder  ", 71,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mahedi Hasan.jpeg");
    bangaladeshPlayers[12] = new Player("Nayeem Hasan","Bowler", 71,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Nayeem Hasan.jpeg");
    bangaladeshPlayers[13] = new Player("Hasan Mahmud","Bowler", 75,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Hasan Mahmud.jpeg");
    bangaladeshPlayers[14] = new Player("Mustafizur Rahman","Bowler", 84,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Mustafizur Rahman.jpeg");
    bangaladeshPlayers[15] = new Player("Nasum Ahmed","Bowler", 74,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Nasum Ahmed.jpeg");
    bangaladeshPlayers[16] = new Player("Shoriful Islam","Bowler", 72,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Shoriful Islam.jpeg");
    bangaladeshPlayers[17] = new Player("Tanzim Hasan Sakib","Bowler", 75,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Tanzim Hasan Sakib.jpeg");
    bangaladeshPlayers[18] = new Player("Taskin Ahmed","Bowler", 79,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Taskin Ahmed.jpeg");
    bangaladeshPlayers[19] = new Player("Khaled Ahmed","Bowler", 71,"E:\\Cricket4\\JP projectImages\\Players\\bangaladesh team\\Khaled Ahmed.jpeg");
        
    southAfricaPlayers[0]  = new Player(" Temba Bavuma","Batsman", 79,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\1bavuma.jpeg");
    southAfricaPlayers[1]  = new Player(" Aiden Markram","Batsman", 84,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\2Aiden Markram.jpeg");
    southAfricaPlayers[2]  = new Player(" Reeza Hendricks","Batsman", 76,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\3Reeza Hendricks.jpeg");
    southAfricaPlayers[3]  = new Player(" Rassie van der Dussen","Batsman", 81,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\4Rassie van der Dussen.jpeg");
    southAfricaPlayers[4]  = new Player(" Matthew Breetzke","Batsman", 74,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\5Matthew Breetzke.png");
    southAfricaPlayers[5]  = new Player(" David Miller","Batsman", 83,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\6David Miller.jpeg");
    southAfricaPlayers[6]  = new Player(" Quinton de Kock","Wicket-Keeper", 88,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\7Quinton de Kock.jpeg");
    southAfricaPlayers[7]  = new Player(" Heinrich Klaasen","Wicket-Keeper", 83,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\8Heinrich Klaasen.jpeg");
    southAfricaPlayers[8]  = new Player(" Tristan Stubbs","Wicket-Keeper", 79,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\9Tristan Stubbs.jpeg");
    southAfricaPlayers[9]  = new Player(" Marco Jansen","All-Rounder", 79,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\9.1Jansen.jpeg");
    southAfricaPlayers[10] = new Player("Andile Phelukwayo","All-Rounder", 78,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\10Andile Phelukwayo.jpeg");
    southAfricaPlayers[11] = new Player("Donovan Ferreira","All-Rounder", 73,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\11Donovan Ferreira.jpg");
    southAfricaPlayers[12] = new Player("Lizaad Williams","Bowler", 76,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\12Lizaad Williams.jpeg");
    southAfricaPlayers[13] = new Player("Gerald Coetzee","Bowler", 79,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\13Gerald Coetzee.png");
    southAfricaPlayers[14] = new Player("Keshav Maharaj","Bowler", 81,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\14Keshav Maharaj.jpeg");
    southAfricaPlayers[15] = new Player("Kagiso Rabada","Bowler", 86,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\15Kagiso Rabada.jpeg");
    southAfricaPlayers[16] = new Player("Lungi Ngidi","Bowler", 83,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\16Lungi Ngidi.jpeg");
    southAfricaPlayers[17] = new Player("Anrich Nortje","Bowler", 80,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\17Anrich Nortje.jpeg");
    southAfricaPlayers[18] = new Player("Tabraiz Shamsi","Bowler", 77,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\18Tabraiz Shamsi.jpeg");
    southAfricaPlayers[19] = new Player("Sisanda Magala","Bowler", 70,"E:\\Cricket4\\JP projectImages\\Players\\southAfrica team\\Sisanda Magala.jpeg");
        
    afghanistanPlayers[0]  = new Player(" Ibrahim Zadran","Batsman", 78,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Ibrahim Zadran.jpeg");
    afghanistanPlayers[1]  = new Player(" Najibullah Zadran","Batsman", 74,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Najibullah Zadran.jpeg");
    afghanistanPlayers[2]  = new Player(" Riaz Hassan","Batsman", 71,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Riaz Hassan.jpeg");
    afghanistanPlayers[3]  = new Player(" Hashmatullah Gurbaz","Batsman", 76,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Hashmatullah Gurbaz.jpeg");
    afghanistanPlayers[4] = new Player("Hazratullah Zazai","Batsman", 75,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Hazratullah Zazai.jpeg");
    afghanistanPlayers[5]  = new Player(" Rahmanullah Gurbaz","Wicket-Keeper", 74,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Rahmanullah Gurbaz.jpeg");
    afghanistanPlayers[6] = new Player(" Mohammed Ishaq","Wicket-Keeper", 73,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Mohammed Ishaq.jpeg");
    afghanistanPlayers[7]  = new Player(" Azmatullah Omarzai","All-Rounder ", 80,"C:\\Users\\arpan\\Downloads\\Azmatullah Omarzai_LE_auto_x1_no_background.jpg");
    afghanistanPlayers[8]  = new Player(" Rahmat Shah","All-Rounder  ", 73,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Rahmat Shah.jpeg");
    afghanistanPlayers[9]  = new Player(" Mohammad Nabi","All-Rounder  ", 81,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Mohammad Nabi.jpeg");
    afghanistanPlayers[10]  = new Player(" Rashid Khan","All-Rounder", 84,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Rashid Khan.jpeg");        
    afghanistanPlayers[11] = new Player("Karim Janat","All-Rounder ", 71,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Karim Janat.jpeg");
    afghanistanPlayers[12] = new Player("Sharafuddin Ashraf","All-Rounder", 74,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Sharafuddin Ashraf.jpeg");
    afghanistanPlayers[13] = new Player("Fareed Ahmad","Bowler", 72,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Fareed Ahmad.jpeg");
    afghanistanPlayers[14] = new Player("Abdul Rahman","Bowler", 69,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Abdul Rahman.jpeg");
    afghanistanPlayers[15] = new Player("Fazalhaq Farooqi","Bowler", 70,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Fazalhaq Farooqi.jpeg");
    afghanistanPlayers[16] = new Player("Mujeeb Ur Rahman","Bowler", 81,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Mujeeb Ur Rahman.jpeg");
    afghanistanPlayers[17] = new Player("Naveen-ul-Haq","Bowler", 73,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Naveen-ul-Haq.jpeg");
    //afghanistanPlayers[19] = new Player("Noor Ahmad","Bowler", 75,"E:\\Cricket4\\JP projectImages\\Players\\afghanistan team\\Noor Ahmad.jpeg");
    // Initialize other teams...

        // Initialize teams array
        teams = new Team[]{indianTeam, australianTeam, westIndiesTeam, englandTeam, newZealandTeam,
        pakistanTeam, srilankaTeam, bangaladeshTeam, southAfricaTeam, afghanistanTeam};
        // Welcome message
        JOptionPane.showMessageDialog(this, "Welcome to Cricket Team Selection System!");

        // Team selection combo box
        teamComboBox = new JComboBox<>();
        for (Team team : teams) {
            teamComboBox.addItem(team.teamName);
        }
        teamComboBox.addActionListener(this);
        add(teamComboBox, BorderLayout.NORTH);

        // Player display area
        playerTextArea = new JTextArea();
        playerTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playerTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button for selecting players
        selectButton = new JButton("Select Players");
        selectButton.addActionListener(this);
        add(selectButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == teamComboBox) {
            // Display players for the selected team
            int selectedTeamIndex = teamComboBox.getSelectedIndex();
            Team selectedTeam = teams[selectedTeamIndex];
            StringBuilder playersText = new StringBuilder("Available Players for " + selectedTeam.teamName + ":\n");
            for (int i = 0; i < selectedTeam.players.length; i++) {
                playersText.append((i + 1)).append(". ").append(selectedTeam.players[i].name).append("                 ")
                        .append(selectedTeam.players[i].role).append("                ").append(selectedTeam.players[i].Rating).append("\n");
            }
            playerTextArea.setText(playersText.toString());
        } else if (e.getSource() == selectButton) {
            // User selects players for the team
            Team selectedTeam = teams[teamComboBox.getSelectedIndex()];
            selectedPlayers = new Player[11];
            int selectedCount = 0;
            int[] selectedPlayerIndices = new int[11];
            while (selectedCount < 11) {
                int playerNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter player number to select:"));
                if (playerNumber >= 1 && playerNumber <= selectedTeam.players.length) {
                    if (!selectedTeam.players[playerNumber - 1].selected) {
                        selectedTeam.players[playerNumber - 1].selected = true;
                        selectedPlayers[selectedCount] = selectedTeam.players[playerNumber - 1];
                        selectedPlayerIndices[selectedCount] = playerNumber;
                        selectedCount++;
                    } else {
                        JOptionPane.showMessageDialog(this, "Player already selected. Choose another player.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid player number. Please enter a number between 1 and " + selectedTeam.players.length);
                }
            }
    
            int captainIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the player number of the captain:"));
    
// Create new frame
JFrame teamFrame = new JFrame(selectedTeam.teamName);
teamFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

// Set size to 1080x720 (70% of the width)
int frameWidth = 1080;
int frameHeight = 720;
teamFrame.setSize(frameWidth, frameHeight);

// Header panel
JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, frameHeight / 20)); // Center align the label vertically
headerPanel.setPreferredSize(new Dimension(frameWidth, frameHeight / 10)); // Set header panel to 1/10th of frame height

String selectedTeamName = selectedTeam.teamName.toUpperCase(); // Convert to uppercase
Font headerFont = new Font("Arial", Font.BOLD, 36); // Define font with increased size and bold
JLabel headerLabel = new JLabel(selectedTeamName);
headerLabel.setFont(headerFont); // Set the font
headerLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
headerLabel.setVerticalAlignment(SwingConstants.CENTER); // Center align the label vertically
headerPanel.add(headerLabel);

teamFrame.add(headerPanel, BorderLayout.NORTH);


// Player display panel
JPanel playerPanel = new JPanel(new GridLayout(2, 6));
for (Player player : selectedPlayers) {
    JPanel playerInfoPanel = new JPanel(new BorderLayout());
    playerInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    JLabel nameLabel = new JLabel("<html><b>Name:</b> " + player.name + "</html>");
    JLabel roleLabel = new JLabel("<html><b>Role:</b> " + player.role + "</html>");
    JLabel ratingLabel = new JLabel("<html><b>Rating:</b> " + player.Rating + "</html>");

    ImageIcon icon = new ImageIcon(player.imagePath);
    Image image = icon.getImage();
    Image newImage = image.getScaledInstance((int) (icon.getIconWidth() * 0.8), -1, Image.SCALE_SMOOTH); // Adjust scale
    icon = new ImageIcon(newImage);
    JLabel imageLabel = new JLabel();
    imageLabel.setIcon(icon);

    // Center image within the panel
    JPanel imagePanel = new JPanel(new GridBagLayout());
    imagePanel.add(imageLabel);

    playerInfoPanel.add(imagePanel, BorderLayout.CENTER);

    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new GridLayout(3, 1));
    infoPanel.add(nameLabel);
    infoPanel.add(roleLabel);
    infoPanel.add(ratingLabel);

    playerInfoPanel.add(infoPanel, BorderLayout.SOUTH);

    playerPanel.add(playerInfoPanel);
}

teamFrame.add(playerPanel, BorderLayout.CENTER);

// Captain and overall rating panel
JPanel captainOverallPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center align the panel
captainOverallPanel.setPreferredSize(new Dimension(frameWidth, frameHeight / 15)); // Set captainOverallPanel to 1/15th of frame height
JLabel captainLabel = new JLabel("Captain: " + selectedPlayers[captainIndex - 1].name);
JLabel overallLabel = new JLabel("         Overall Rating: ");

captainOverallPanel.add(captainLabel);
captainOverallPanel.add(overallLabel);

teamFrame.add(captainOverallPanel, BorderLayout.SOUTH);

teamFrame.setVisible(true);

// Calculate team overall
int sum = 0;
for (int i = 0; i < selectedPlayers.length; i++) {
    sum += selectedPlayers[i].Rating;
}
int ovr = sum / 11;
JLabel ovrLabel = new JLabel(String.valueOf(ovr));

captainOverallPanel.add(ovrLabel);

teamFrame.add(captainOverallPanel, BorderLayout.SOUTH);

            teamFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}
