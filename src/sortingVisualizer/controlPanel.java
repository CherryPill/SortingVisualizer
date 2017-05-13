/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.event.*;
/**
 *
 * @author Theta1
 */
import javax.swing.*;
public class controlPanel extends JPanel implements ActionListener
{
    Model model;
    JComboBox sortDirCombo;
    JComboBox sortCombo;
    JLabel sortDirLabel;
    JButton buttonOK;
    String[] sortChoices = {
    "Shell's sort",
    "Quick sort",
    "Bubble sort",
    "Binary tree"
    };
    String[] sortDirChoices = {
    "Ascending",
    "Descending"
    };
    public controlPanel(Model model) {
        this.model = model;
        sortCombo = new JComboBox();
        sortDirCombo = new JComboBox();
        sortDirLabel = new JLabel("Direction");
        
        for(String str:this.sortChoices) {
            sortCombo.addItem(str);
        }
        for(String str:this.sortDirChoices) {
            sortDirCombo.addItem(str);
        }
        buttonOK = new JButton();
        buttonOK.setText("Sort");
        buttonOK.addActionListener(this);
        this.add(sortCombo);
        this.add(sortDirLabel);
        this.add(sortDirCombo);
        this.add(buttonOK);  
    }
    public JPanel getControlPanel() {
        return this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(buttonOK)) {
            int chosenSortAlgorithm = sortCombo.getSelectedIndex();
            int chosenDirection = sortDirCombo.getSelectedIndex();
            this.model.sortWrapper(chosenSortAlgorithm, chosenDirection);
            sortDirCombo.setSelectedIndex(chosenDirection == 0 ? 1:0);
        }
    }
}
