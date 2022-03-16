/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package languagegui;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
/**
 *
 * @author shakaylaalston
 */
public class LanguageGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    GUI t = new GUI();
    //Set program to terminate when window is closed
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t.pack();
    t.setVisible(true);
    }
    
}
