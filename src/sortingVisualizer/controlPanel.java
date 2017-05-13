/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Theta1
 */
import javax.swing.*;
public class controlPanel extends JPanel implements ActionListener, ItemListener
{
    Color[] stateColors = {
        Color.RED,
        Color.ORANGE,
        Color.GREEN
    };
    JPanel upperPanel;
    JPanel lowerPanel;
    Model model;
    JComboBox sortDirCombo;
    JComboBox sortCombo;
    JLabel sortDirLabel;
    JLabel currentSortingState;
    JButton buttonOK;
    String[] sortChoices = {
    "Shell's sort",
    "Quick sort",
    "Bubble sort",
    "Binary tree"
    };
    String[] sortStates = {
    "Unsorted",
    "Being sorted...",
    "Sorted"
    };
    String[] sortDirChoices = {
    "Ascending",
    "Descending"
    };
    public controlPanel(Model model) {
        this.upperPanel = new JPanel();
        this.lowerPanel = new JPanel();
        
        this.model = model;
        sortCombo = new JComboBox();
        sortDirCombo = new JComboBox();
        sortDirLabel = new JLabel("Direction");
        currentSortingState = new JLabel(this.sortStates[0]);
        currentSortingState.setFont(new Font("Sans-Serif", Font.PLAIN, 34));
        currentSortingState.setForeground(Color.RED);
        for(String str:this.sortChoices) {
            sortCombo.addItem(str);
        }
        for(String str:this.sortDirChoices) {
            sortDirCombo.addItem(str);
        }
        buttonOK = new JButton();
        buttonOK.setText("Sort");
        buttonOK.addActionListener(this);
        sortCombo.addItemListener(this);
        this.upperPanel.add(sortCombo);
        this.upperPanel.add(sortDirLabel);
        this.upperPanel.add(sortDirCombo);
        this.upperPanel.add(buttonOK);  
        this.lowerPanel.add(currentSortingState);
        this.add(upperPanel);
        this.add(lowerPanel);
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
            this.updateStateLabel(1);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getStateChange() == ItemEvent.SELECTED){
            this.updateStateLabel(0);
        }
    }
    //0 - unsorted
    //1 - being sorted
    //3 - sorted
    public void updateStateLabel(int state){
        this.currentSortingState.setText(this.sortStates[state]);
        this.currentSortingState.setForeground(stateColors[state]);   
    }
}
