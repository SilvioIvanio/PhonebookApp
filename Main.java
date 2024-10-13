import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Contact class to hold contact details
class Contact {
    String name;
    String phoneNumber;
    String email;

    // Constructor to initialize the contact
    Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

// RoundedButton class to create a button with rounded edges
class RoundedButton extends JButton {
    private final int radius;

    // Constructor to set button text and radius
    RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentAreaFilled(false);
    }

    // Custom paint method to create a rounded button
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker()); // Darker when pressed
        } else {
            g.setColor(getBackground()); // Normal color otherwise
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}

// Main class for the Phone Booker application
public class Main extends JFrame {
    ArrayList<Contact> contactList = new ArrayList<>(); // List to store contacts
    JTextField nameField, phoneField, emailField; // Input fields for contact details
    JTable contactTable; // Table to display contacts
    DefaultTableModel tableModel; // Model to handle table data

    // Constructor to initialize the GUI components
    public Main() {
        setTitle("Phone Booker"); // Set window title
        setSize(600, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setLayout(new CardLayout()); // Layout manager for pages

        // Add intro page and main page to the window
        JPanel introPanel = createIntroPage();
        add(introPanel, "Intro");

        JPanel contentPanel = createMainPage();
        add(contentPanel, "Main");

        setVisible(true); // Make the window visible
    }

    // Method to create the introduction page
    private JPanel createIntroPage() {
        JPanel introPanel = new JPanel();
        introPanel.setLayout(new BorderLayout()); // Layout for content placement
        introPanel.setBackground(new Color(211, 211, 211)); // Light gray background

        // Welcome label in the center
        JLabel welcomeLabel = new JLabel("Welcome to PhoneBooker", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        introPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Button to proceed to the main page
        RoundedButton proceedBtn = new RoundedButton("GET STARTED", 15);
        proceedBtn.setBackground(new Color(0, 123, 255)); // Blue background
        proceedBtn.setForeground(Color.WHITE); // White text
        proceedBtn.addActionListener(e -> switchToMainPage()); // Action listener to switch page

        // Add button at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(proceedBtn);
        introPanel.add(buttonPanel, BorderLayout.SOUTH);

        return introPanel;
    }

    // Method to create the main page where contacts are managed
    private JPanel createMainPage() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(211, 211, 211)); // Light gray background

        // Header section
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Phone Booker ", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.setBackground(new Color(51, 153, 255)); // Blue background
        headerLabel.setForeground(Color.WHITE); // White text
        headerPanel.add(headerLabel);
        contentPanel.add(headerPanel, BorderLayout.NORTH); // Add header to top

        // Input fields section
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding

        nameField = new JTextField(); // Name input
        phoneField = new JTextField(); // Phone input
        emailField = new JTextField(); // Email input

        inputPanel.add(new JLabel("Name:")); // Add labels and input fields
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);

        // Table to display contacts
        tableModel = new DefaultTableModel(new String[]{"Name", "Phone", "Email"}, 0); // Columns
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable); // Scrollable table
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputPanel, BorderLayout.NORTH); // Inputs at top
        centerPanel.add(scrollPane, BorderLayout.CENTER); // Table in center

        contentPanel.add(centerPanel, BorderLayout.CENTER); // Add to main page

        // Action buttons section
        JPanel actionPanel = new JPanel(new GridLayout(2, 4, 10, 10)); // Button grid layout
        actionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding

        // Create buttons for different actions (Add, Search, Display, etc.)
        RoundedButton insertBtn = new RoundedButton("Add", 15);
        insertBtn.setBackground(new Color(0, 123, 255));
        insertBtn.setForeground(Color.WHITE);
        insertBtn.addActionListener(e -> insertContact());

        RoundedButton searchBtn = new RoundedButton("Search", 15);
        searchBtn.setBackground(new Color(0, 123, 255));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.addActionListener(e -> searchContactAndDisplay());

        RoundedButton displayAllBtn = new RoundedButton("Display All", 15);
        displayAllBtn.setBackground(new Color(0, 123, 255));
        displayAllBtn.setForeground(Color.WHITE);
        displayAllBtn.addActionListener(e -> displayAllContacts());

        RoundedButton deleteBtn = new RoundedButton("Delete", 15);
        deleteBtn.setBackground(new Color(0, 123, 255));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.addActionListener(e -> deleteContact());

        RoundedButton updateBtn = new RoundedButton("Update", 15);
        updateBtn.setBackground(new Color(0, 123, 255));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener(e -> updateContact());

        RoundedButton analyzeBtn = new RoundedButton("Analyze", 15);
        analyzeBtn.setBackground(new Color(0, 123, 255));
        analyzeBtn.setForeground(Color.WHITE);
        analyzeBtn.addActionListener(e -> analyzeSearchEfficiency());

        RoundedButton sortBtn = new RoundedButton("Sort", 15);
        sortBtn.setBackground(new Color(0, 123, 255));
        sortBtn.setForeground(Color.WHITE);
        sortBtn.addActionListener(e -> sortContacts());

        // Add buttons to the action panel
        actionPanel.add(insertBtn);
        actionPanel.add(searchBtn);
        actionPanel.add(displayAllBtn);
        actionPanel.add(deleteBtn);
        actionPanel.add(updateBtn);
        actionPanel.add(analyzeBtn);
        actionPanel.add(sortBtn);

        contentPanel.add(actionPanel, BorderLayout.SOUTH); // Add action buttons to bottom

        return contentPanel;
    }

    // Switch from intro page to the main content page
    private void switchToMainPage() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "Main");
    }

    // Add a new contact to the contact list
    public void insertContact() {
        String name = nameField.getText(); // Get name input
        String phoneNumber = phoneField.getText(); // Get phone input
        String email = emailField.getText(); // Get email input

        // Validate inputs (name and phone are required)
        if (!name.isEmpty() && !phoneNumber.isEmpty()) {
            Contact existingContact = searchContact(name); // Check if contact exists by name
            if (existingContact == null) {
                existingContact = searchContact(phoneNumber); // Check if contact exists by phone
            }
            if (existingContact == null) {
                Contact newContact = new Contact(name, phoneNumber, email); // Create new contact
                contactList.add(newContact); // Add to contact list
                clearFields(); // Clear input fields
                JOptionPane.showMessageDialog(this, "Contact added successfully."); // Show success
            } else {
                JOptionPane.showMessageDialog(this, "Contact already exists."); // Show error
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name and Phone are required."); // Show validation message
        }
    }

    // Search for a contact by name or phone (linear search)
    public Contact searchContact(String query) {
        for (Contact contact : contactList) {
            if (contact.name.equalsIgnoreCase(query) || contact.phoneNumber.equals(query)) {
                return contact; // Return found contact
            }
        }
        return null; // Return null if not found
    }

    // Prompt user for contact and display the contact details
    public void searchContactAndDisplay() {
        String query = JOptionPane.showInputDialog(this, "Enter Name or Phone Number:");
        if (query != null) {
            Contact contact = searchContact(query); // Search for contact
            if (contact != null) {
                JOptionPane.showMessageDialog(this, "Name: " + contact.name + "\nPhone: " + contact.phoneNumber + "\nEmail: " + contact.email);
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found."); // Not found message
            }
        }
    }

    // Display all contacts in the table
    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No contacts to display."); // No contacts message
        } else {
            tableModel.setRowCount(0); // Clear existing table rows
            for (Contact contact : contactList) {
                tableModel.addRow(new Object[]{contact.name, contact.phoneNumber, contact.email}); // Add each contact to the table
            }
            JOptionPane.showMessageDialog(this, "All contacts displayed."); // Show confirmation
        }
    }

    // Delete a contact by name or phone
    public void deleteContact() {
        String query = JOptionPane.showInputDialog(this, "Enter Name or Phone Number to delete:");
        if (query != null) {
            Contact contact = searchContact(query); // Search for contact
            if (contact != null) {
                contactList.remove(contact); // Remove from contact list
                displayAllContacts(); // Refresh the table
                JOptionPane.showMessageDialog(this, "Contact deleted successfully."); // Success message
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found."); // Not found message
            }
        }
    }

    // Update a contact's details
    public void updateContact() {
        String query = JOptionPane.showInputDialog(this, "Enter Name or Phone Number to update:");
        if (query != null) {
            Contact contact = searchContact(query); // Search for contact
            if (contact != null) {
                String newName = JOptionPane.showInputDialog(this, "Enter new name:", contact.name);
                String newPhone = JOptionPane.showInputDialog(this, "Enter new phone number:", contact.phoneNumber);
                String newEmail = JOptionPane.showInputDialog(this, "Enter new email:", contact.email);

                // Check if new contact details conflict with existing ones
                if (!newName.isEmpty() && !newPhone.isEmpty()) {
                    Contact existingContact = searchContact(newName);
                    if (existingContact == null || existingContact == contact) {
                        existingContact = searchContact(newPhone);
                    }
                    if (existingContact == null || existingContact == contact) {
                        contact.name = newName; // Update name
                        contact.phoneNumber = newPhone; // Update phone
                        contact.email = newEmail; // Update email
                        displayAllContacts(); // Refresh table
                        JOptionPane.showMessageDialog(this, "Contact updated successfully."); // Success message
                    } else {
                        JOptionPane.showMessageDialog(this, "A contact with the same details already exists."); // Conflict error
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Name and Phone are required."); // Validation error
                }
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found."); // Not found error
            }
        }
    }

    // Analyze search efficiency using linear and binary search
    public void analyzeSearchEfficiency() {
        String query = JOptionPane.showInputDialog(this, "Enter Name or Phone Number for search analysis:");
        if (query != null) {
            if (contactList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No contacts to analyze."); // Empty list message
                return;
            }

            // Sort contacts alphabetically by name for binary search
            contactList.sort((c1, c2) -> c1.name.compareToIgnoreCase(c2.name));

            long startTime = System.nanoTime(); // Start timing linear search
            Contact linearResult = searchContact(query);
            long linearSearchTime = System.nanoTime() - startTime; // End timing

            startTime = System.nanoTime(); // Start timing binary search
            Contact binaryResult = binarySearch(query, 0, contactList.size() - 1);
            long binarySearchTime = System.nanoTime() - startTime; // End timing

            // Show search times and results
            JOptionPane.showMessageDialog(this, "Linear Search Time: " + linearSearchTime + " ns\nBinary Search Time: " + binarySearchTime + " ns\n"
                    + (linearResult != null ? "Contact found." : "Contact not found."));
        }
    }

    // Binary search method for analyzing search efficiency
    private Contact binarySearch(String query, int low, int high) {
        if (low > high) return null; // Base case: Not found

        int mid = (low + high) / 2;
        Contact midContact = contactList.get(mid);

        if (midContact.name.equalsIgnoreCase(query) || midContact.phoneNumber.equals(query)) {
            return midContact; // Found contact
        }

        if (midContact.name.compareToIgnoreCase(query) < 0) {
            return binarySearch(query, mid + 1, high); // Search right half
        } else {
            return binarySearch(query, low, mid - 1); // Search left half
        }
    }

    // Sort the contact list alphabetically by name
    public void sortContacts() {
        if (contactList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No contacts to sort."); // Empty list message
        } else {
            contactList.sort((c1, c2) -> c1.name.compareToIgnoreCase(c2.name)); // Sort by name
            displayAllContacts(); // Refresh table
            JOptionPane.showMessageDialog(this, "Contacts sorted successfully."); // Success message
        }
    }

    // Clear input fields for name, phone, and email
    public void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Main(); // Create an instance of the Main class to start the application
    }
}