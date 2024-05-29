package ro.fithubhome;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.fithubhome.ui.MenuUI;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
        System.out.println("Welcome to FithubHome! Here you can see body stats ");
        MenuUI menuUI = new MenuUI();
        menuUI.start();

    }
}

  /*
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
*/