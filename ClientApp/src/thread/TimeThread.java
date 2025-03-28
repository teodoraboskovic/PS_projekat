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
import javax.swing.text.DateFormatter;

/**
 *
 * @author PC
 */
public class TimeThread implements Runnable{
    JLabel lblTime;

    public TimeThread(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    @Override
    public void run() {
       setTime();
    }
    public void setTime(){
         while(true){
            Date date=new Date();
            DateFormat df=new SimpleDateFormat("HH:mm:ss");
            lblTime.setText(df.format(date));
        }
    }
    
}
