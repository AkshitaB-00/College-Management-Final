import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CombinedManagementSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Unified Management System");
            mainFrame.setSize(400, 300);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(new GridLayout(4, 1));

            JLabel welcomeLabel = new JLabel("Welcome to the Unified Management System", SwingConstants.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

            JButton libraryButton = new JButton("Library Management System");
            JButton studentButton = new JButton("Student Management System");
            JButton attendanceButton = new JButton("Attendance System");

            libraryButton.addActionListener(e -> {
                JFrame libraryFrame = new JFrame("Library Management System");
                libraryFrame.setSize(600, 400);
                libraryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                libraryFrame.setLayout(new BorderLayout());

                LibraryManagementSystemGUI libraryGUI = new LibraryManagementSystemGUI();
                libraryFrame.add(libraryGUI.getContentPane());

                JButton backButton = new JButton("Back to Main Menu");
                backButton.addActionListener(event -> {
                    libraryFrame.dispose();
                    mainFrame.setVisible(true);
                });

                libraryFrame.add(backButton, BorderLayout.SOUTH);
                mainFrame.setVisible(false);
                libraryFrame.setVisible(true);
            });

            studentButton.addActionListener(e -> {
                JFrame studentFrame = new JFrame("Student Management System");
                studentFrame.setSize(500, 600);
                studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                studentFrame.setLayout(new BorderLayout());

                DBWithGUI studentGUI = new DBWithGUI();
                studentFrame.add(studentGUI.getContentPane());

                JButton backButton = new JButton("Back to Main Menu");
                backButton.addActionListener(event -> {
                    studentFrame.dispose();
                    mainFrame.setVisible(true);
                });

                studentFrame.add(backButton, BorderLayout.SOUTH);
                mainFrame.setVisible(false);
                studentFrame.setVisible(true);
            });

            attendanceButton.addActionListener(e -> {
                mainFrame.setVisible(false);
                AttendanceSystemGUI.showMainMenu();
                mainFrame.setVisible(true);
            });

            mainFrame.add(welcomeLabel);
            mainFrame.add(libraryButton);
            mainFrame.add(studentButton);
            mainFrame.add(attendanceButton);

            mainFrame.setVisible(true);
        });
    }
}
