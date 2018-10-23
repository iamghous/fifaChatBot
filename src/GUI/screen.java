/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Noman
 */
public class screen {
    public static void main(String[] args) {
        FlashScreen flash=new FlashScreen();
        flash.setVisible(true);
        MainPage m=new MainPage();
        try {
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(40);
                flash.num.setText(Integer.toString(i)+"%");
                flash.progressbar.setValue(i);
                if(i==100)
                {
                    flash.dispose();
                    m.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
