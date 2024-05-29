package ro.fithubhome.ui;

import org.springframework.stereotype.Component;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuUI extends JButton{
  

    public void start() {

       /* MenuUI(new String (MODEL_CHANGED_PROPERTY));
                super(MODEL_CHANGED_PROPERTY);
                addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // Code to execute when the button is clicked

                    }
                });

        MenuUI button = new MenuUI("Click Me!");
        add(button);
        }
                int count = 0;
                //while (count <= 3) {
                    System.out.println("Please choose an option from the following: ");
                    System.out.println("Signup \t Login \t Profile \t Exit ");

                    Scanner keyboadInput = new Scanner(System.in);
                    String option = keyboadInput.next();

                    if (option != null) {
                        System.out.println("The selected option is " + option);

                        if (option.equals("Login")) {
                            EnterStatsUI loginUI = new EnterStatsUI();
                            loginUI.enterStats();
                        } else if (option.equals("Signup")) {
                            System.out.println("Sign in started");
                            DisplayStatsUI signupUI = new DisplayStatsUI();
                            signupUI.displayStats();
                        } else {
                            System.out.println("No valid option has been selected");
                            count++;

              //  }
            }
        }*/
    }
}
