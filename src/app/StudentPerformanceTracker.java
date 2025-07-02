package app;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class StudentPerformanceTracker extends JFrame {
    private JTextField studentIdField, dateField, topicField, marksField;
    private JTextField ceDateField, ceSemField, ceTopicField, ceStartIdField, ceEndIdField;
    private DefaultTableModel tableModel, editTableModel;
    private JTable editTable;
    private JComboBox<String> semComboBox, dateComboBox;
    private JLabel dateLabel, semLabel, topicLabel;
    private String name ;
    private ArrayList<PerformanceEntry> entries;

    public StudentPerformanceTracker() {
        setTitle("Student Performance Tracker");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        entries = new ArrayList<>();

        tableModel = new DefaultTableModel(new String[]{"Date", "Semester", "Student ID", "Topic", "Marks"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JTabbedPane tabbedPane = new JTabbedPane();

        // --- Tab 1: Add Single Entry ---
        JPanel singlePanel = new JPanel(new GridLayout(6, 2, 10, 10));
        studentIdField = new JTextField();
        dateField = new JTextField();
        topicField = new JTextField();
        marksField = new JTextField();
        JTextField semesterField = new JTextField();

        singlePanel.add(new JLabel("Date (YYYY-MM-DD):"));
        singlePanel.add(dateField);
        singlePanel.add(new JLabel("Semester:"));
        singlePanel.add(semesterField);
        singlePanel.add(new JLabel("Student ID:"));
        singlePanel.add(studentIdField);
        singlePanel.add(new JLabel("Topic:"));
        singlePanel.add(topicField);
        singlePanel.add(new JLabel("Marks:"));
        singlePanel.add(marksField);

        JButton addSingleButton = new JButton("Add Entry");
        singlePanel.add(addSingleButton);

        addSingleButton.addActionListener(e -> {
            try {
                String date = dateField.getText().trim();
                String sem = semesterField.getText().trim();
                String id = studentIdField.getText().trim();
                String topic = topicField.getText().trim();
                double marks = Double.parseDouble(marksField.getText().trim());

                PerformanceEntry entry = new PerformanceEntry(date, sem, id, topic, marks);
                entries.add(entry);
                tableModel.addRow(new Object[]{date, sem, id, topic, marks});
                updateSemesterComboBox();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tabbedPane.add("Add Single Entry", singlePanel);

        // --- Tab 2: Continuous Evaluation ---
        JPanel cePanel = new JPanel(new GridLayout(6, 2, 10, 10));
        ceDateField = new JTextField();
        ceSemField = new JTextField();
        ceTopicField = new JTextField();
        ceStartIdField = new JTextField();
        ceEndIdField = new JTextField();

        cePanel.add(new JLabel("Date (YYYY-MM-DD):"));
        cePanel.add(ceDateField);
        cePanel.add(new JLabel("Semester:"));
        cePanel.add(ceSemField);
        cePanel.add(new JLabel("Topic:"));
        cePanel.add(ceTopicField);
        cePanel.add(new JLabel("Start Student ID (e.g., S001):"));
        cePanel.add(ceStartIdField);
        cePanel.add(new JLabel("End Student ID (e.g., S010):"));
        cePanel.add(ceEndIdField);

        JButton generateButton = new JButton("Generate Entries");
        cePanel.add(generateButton);

        generateButton.addActionListener(e -> generateContinuousEntries());

        tabbedPane.add("Create Continuous Evaluation", cePanel);

        // --- Tab 3: View/Edit Evaluation ---
        JPanel editPanel = new JPanel(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(3, 1));

        JPanel semPanel = new JPanel();
        semPanel.add(new JLabel("Select Semester:"));
        semComboBox = new JComboBox<>();
        semComboBox.addActionListener(e -> updateDateComboBox());
        semPanel.add(semComboBox);
        topPanel.add(semPanel);

        JPanel datePanel = new JPanel();
        datePanel.add(new JLabel("Select Date:"));
        dateComboBox = new JComboBox<>();
        dateComboBox.addActionListener(e -> loadEntriesBySemAndDate());
        datePanel.add(dateComboBox);
        topPanel.add(datePanel);

        JPanel infoPanel = new JPanel(new GridLayout(1, 3));
        dateLabel = new JLabel("Date: ");
        semLabel = new JLabel("Semester: ");
        topicLabel = new JLabel("Topic: ");
        infoPanel.add(dateLabel);
        infoPanel.add(semLabel);
        infoPanel.add(topicLabel);
        topPanel.add(infoPanel);

        editPanel.add(topPanel, BorderLayout.NORTH);

        editTableModel = new DefaultTableModel(new String[]{"Student ID", "Marks"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };

        editTable = new JTable(editTableModel);
        editPanel.add(new JScrollPane(editTable), BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(e -> saveEditedEntries());
        editPanel.add(saveButton, BorderLayout.SOUTH);

        tabbedPane.add("View/Edit Evaluation", editPanel);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void generateContinuousEntries() {
        String date = ceDateField.getText().trim();
        String semester = ceSemField.getText().trim();
        String topic = ceTopicField.getText().trim();
        String startId = ceStartIdField.getText().trim();
        String endId = ceEndIdField.getText().trim();

        try {
            int start = Integer.parseInt(startId.substring(1));
            int end = Integer.parseInt(endId.substring(1));
            String prefix = startId.substring(0, 1);

            for (int i = start; i <= end; i++) {
                String studentId = prefix + String.format("%03d", i);
                PerformanceEntry entry = new PerformanceEntry(date, semester, studentId, topic, -1);
                entries.add(entry);
                tableModel.addRow(new Object[]{date, semester, studentId, topic, ""});
            }
            updateSemesterComboBox();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSemesterComboBox() {
        Set<String> semesters = new TreeSet<>();
        for (PerformanceEntry entry : entries) {
            semesters.add(entry.getSemester());
        }
        semComboBox.removeAllItems();
        for (String sem : semesters) {
            semComboBox.addItem(sem);
        }
    }

    private void updateDateComboBox() {
        String selectedSem = (String) semComboBox.getSelectedItem();
        if (selectedSem == null) return;

        Set<String> dates = new TreeSet<>();
        for (PerformanceEntry entry : entries) {
            if (entry.getSemester().equals(selectedSem)) {
                dates.add(entry.getDate());
            }
        }

        dateComboBox.removeAllItems();
        for (String date : dates) {
            dateComboBox.addItem(date);
        }
    }

    private void loadEntriesBySemAndDate() {
        String selectedSem = (String) semComboBox.getSelectedItem();
        String selectedDate = (String) dateComboBox.getSelectedItem();
        if (selectedSem == null || selectedDate == null) return;

        editTableModel.setRowCount(0);

        String topic = "";
        for (PerformanceEntry entry : entries) {
            if (entry.getSemester().equals(selectedSem) && entry.getDate().equals(selectedDate)) {
                if (topic.isEmpty()) topic = entry.getTopic();
                editTableModel.addRow(new Object[]{
                        entry.getStudentId(),
                        entry.getMarks() >= 0 ? entry.getMarks() : ""
                });
            }
        }

        semLabel.setText("Semester: " + selectedSem);
        dateLabel.setText("Date: " + selectedDate);
        topicLabel.setText("Topic: " + topic);
    }

    private void saveEditedEntries() {
        String selectedSem = (String) semComboBox.getSelectedItem();
        String selectedDate = (String) dateComboBox.getSelectedItem();
        if (selectedSem == null || selectedDate == null) return;

        int rowCount = editTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String studentId = (String) editTableModel.getValueAt(i, 0);
            try {
                String markStr = editTableModel.getValueAt(i, 1).toString().trim();
                if (markStr.isEmpty()) continue;
                double marks = Double.parseDouble(markStr);

                for (PerformanceEntry entry : entries) {
                    if (entry.getDate().equals(selectedDate) &&
                        entry.getSemester().equals(selectedSem) &&
                        entry.getStudentId().equals(studentId)) {
                        entry.setMarks(marks);
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid mark at row " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Changes saved.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentPerformanceTracker().setVisible(true));
    }
}

class PerformanceEntry {
    private String date;
    private String semester;
    private String studentId;
    private String topic;
    private double marks;

    public PerformanceEntry(String date, String semester, String studentId, String topic, double marks) {
        this.date = date;
        this.semester = semester;
        this.studentId = studentId;
        this.topic = topic;
        this.marks = marks;
    }

    public String getDate() { return date; }
    public String getSemester() { return semester; }
    public String getStudentId() { return studentId; }
    public String getTopic() { return topic; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
}

