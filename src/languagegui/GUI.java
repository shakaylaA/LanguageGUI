/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagegui;
import java.util.*;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
/**
 *
 * @author shakaylaalston
 */
  public class GUI extends JFrame implements ActionListener{
    
    Scanner input = new Scanner(System.in);
    private JLabel myLabel;
    private JLabel wordLabel = new JLabel("");
    private Timer myTimer;
    private JButton myButton;
    private JTextField myTextField;
    private JLabel wordLabelEqual = new JLabel("");
    private JLabel userInput;
        
    public GUI() throws IOException, FileNotFoundException{
        super("LanguageGUI");
    
        myLabel = new JLabel ("Type the translation into the field below.");
        GridBagConstraints layoutConst = null;

        /*Set dimension of the box*/
        Dimension preferredSize = new Dimension (450,150);
        this.setMinimumSize(preferredSize);

        /*Create text box for user input*/
        myTextField = new JFormattedTextField();
        myTextField.setColumns(15); // Initial width of 10 units 

        /* Create button and add action listener */
        myButton = new JButton("OK");

        /*Use GridBag to set up*/
        this.setLayout(new GridBagLayout());

        /*Specify grid location*/
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(myLabel, layoutConst); 

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 7, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(myTextField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 0, 1, 10);
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        add(myButton, layoutConst);
    
        /* Initialize Buffer to read both text files and input words into array */
        BufferedReader spanishReader = new BufferedReader(new 
            FileReader("Spanish.txt")); 
            ArrayList<String> spanish = new ArrayList<>();
            
        BufferedReader englishReader = new BufferedReader(new 
            FileReader("English.txt")); 
            ArrayList<String> english = new ArrayList<>(); 

        /*Spanish array*/
        String line = spanishReader.readLine(); 
            while (line != null) { 
            spanish.add(line); 
            line = spanishReader.readLine(); 
            } 
            
        /*English array*/
        line = englishReader.readLine(); 
            while (line != null) { 
            english.add(line); 
            line = englishReader.readLine(); 
            } 
            
        /*ArrayList to combine the different languages*/
        ArrayList<String> allWords = new ArrayList<String>();
            for(int x =0; x < english.size(); x++) {
                allWords.add(english.get(x));
                allWords.add(spanish.get(x));
            } 
            
        /*I set the translation word directly next to its corresponding word in the array. 
          The order will be english1, spanish1, english2, spanish2,etc.*/
        
   
      /*Create infinite loop*/  
        
            /* Set the text box to be editable since after the loop is re-iterated, 
                the action performed is set to false for 4 seconds */
            myTextField.setEditable(true);

            /*Take random word from array list and set it as the word label*/
            int index = (int) (Math.random()* allWords.size() + 0);
            wordLabel.setText(allWords.get(index));

            /*Odd index = Spanish Translation, Even index = English Translation*/
            if(index % 2 == 0 ) { 
                wordLabelEqual.setText(allWords.get(index+1)); //If even, spanish equivalent is one index higher
            }else if (index % 2 != 0) { 
                wordLabelEqual.setText(allWords.get(index-1)); //If odd, English equivalent is one index below
            }

            /*Add the vocabulary word to the GUI*/
            layoutConst = new GridBagConstraints();
            layoutConst.insets = new Insets(10, 0, 1, 10);
            layoutConst.gridx = 0;
            layoutConst.gridy = 1;
            add(wordLabel, layoutConst);

            /*Five seconds have elapsed and then answer will be given*/
            myTimer = new Timer (5000, this); 
            myTimer.start(); 

            /*If enter is pressed*/
            myTextField.addActionListener(this);

            /*When mouse clicks okay button*/
            myButton.addActionListener(this); 

    }
       
/*Method for interface*/
        
    @Override
    public void actionPerformed(ActionEvent e) {
        myTextField.setEditable(false);
        
        /*Create JLabel to store user input*/
        this.userInput = new JLabel (myTextField.getText());
        int length;
        
        /*If the users input length is greater/less than the correct answer... wrong answer*/
        if(userInput.getText().equals(wordLabelEqual.getText())) {
            myLabel.setText("Correct Answer! "); 
        }else{
            myLabel.setText("Incorrect! Answer: " + 
            wordLabelEqual.getText());
        }
        
        /*Set a timer for 4 seconds so the user cannot enter in anything*/
        myTimer = new Timer (4000, this);
        myTimer.addActionListener(new ActionListener() {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        myTextField.setEditable(true);
    }
      });
        myTimer.start();
        // myTextField.setEditable(true);
        }
    
        //Inner class
        class ButtonCallback implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
      }
    }
  }