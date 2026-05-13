import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WhoWillPayUI {

    private ArrayList<String> names = new ArrayList<>();
    private JTextField nameField;
    private JTextArea nameList;
    private JLabel resultLabel;

    public WhoWillPayUI() {

        JFrame frame = new JFrame("Who Will Pay The Bill?");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel title = new JLabel("Enter Names");
        nameField = new JTextField(15);

        JButton addButton = new JButton("Add Name");
        JButton pickButton = new JButton("Pick Who Pays");

        nameList = new JTextArea(10,25);
        nameList.setEditable(false);

        resultLabel = new JLabel(" ");

        frame.add(title);
        frame.add(nameField);
        frame.add(addButton);
        frame.add(new JScrollPane(nameList));
        frame.add(pickButton);
        frame.add(resultLabel);

        addButton.addActionListener(e -> addName());
        pickButton.addActionListener(e -> pickRandom());

        frame.setVisible(true);
    }

    private void addName() {
        String name = nameField.getText();

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter a name first");
            return;
        }

        names.add(name);
        nameList.append(name + "\n");
        nameField.setText("");
    }

    private void pickRandom() {

        if(names.size()==0){
            JOptionPane.showMessageDialog(null,"No names added");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(names.size());

        String selected = names.get(index);

        resultLabel.setText(selected + " WILL PAY THE BILL!");
    }

    public static void main(String[] args) {
        new WhoWillPayUI();
    }
}