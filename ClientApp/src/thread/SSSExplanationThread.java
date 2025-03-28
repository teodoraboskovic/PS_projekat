/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

/**
 *
 * @author PC
 */
public class SSSExplanationThread implements Runnable {

    JTextField txtSSSExplanation;
    JSpinner txtSSS;

    public SSSExplanationThread(JTextField txtSSSExplanation, JSpinner txtSSS) {
        this.txtSSSExplanation = txtSSSExplanation;
        this.txtSSS = txtSSS;
    }

    @Override
    public void run() {
        setExplanation();
    }

    public void setExplanation() {
        while (true) {
            switch ((String) txtSSS.getValue()) {
                case "I":
                    txtSSSExplanation.setText("Cetiri razreda osnovne skole");
                    break;
                case "II":
                    txtSSSExplanation.setText("Osnovna skola");
                    break;
                case "III":
                    txtSSSExplanation.setText("Srednja skola-treci stepen");
                    break;
                case "IV":
                    txtSSSExplanation.setText("Srednja skola-cetvrti stepen");
                    break;
                case "V":
                    txtSSSExplanation.setText("Visoko kvalifikovana srednja skola");
                    break;
                case "VI":
                    txtSSSExplanation.setText("Visa skola");
                    break;
                case "VI-1":
                    txtSSSExplanation.setText("Osnovne trogodisnje studije");
                    break;
                case "VI-2":
                    txtSSSExplanation.setText("Specijalisticke strukovne studije");
                    break;
                case "VII-1":
                    txtSSSExplanation.setText("Visoka strucna sprema");
                    break;
                case "VII-1a":
                    txtSSSExplanation.setText("Osnovne cetvorogodišnje akademske studije");
                    break;
                case "VII-1b":
                    txtSSSExplanation.setText("Master studije");
                    break;
                case "VII-2":
                    txtSSSExplanation.setText("Magistar nauka/specijalističke akademske studije");
                    break;
                case "VIII":
                    txtSSSExplanation.setText("Doktor nauka");
                    break;
            }
        }
    }

}
