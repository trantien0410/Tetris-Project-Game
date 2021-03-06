
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.io.*;

public class Main  {
 
  private static final String PARAMETER[][] = {
      {
      "tetris.color.background", "color",
      "The overall background color."}
      , {
      "tetris.color.label", "color",
      "The text color of the labels."}
      , {
      "tetris.color.button", "color",
      "The start and pause button bolor."}
      , {
      "tetris.color.board.background", "color",
      "The background game board color."}
      , {
      "tetris.color.board.message", "color",
      "The game board message color."}
      , {
      "tetris.color.figure.square", "color",
      "The color of the square figure."}
      , {
      "tetris.color.figure.line", "color",
      "The color of the line figure."}
      , {
      "tetris.color.figure.s", "color",
      "The color of the 's' curved figure."}
      , {
      "tetris.color.figure.z", "color",
      "The color of the 'z' curved figure."}
      , {
      "tetris.color.figure.right", "color",
      "The color of the right angle figure."}
      , {
      "tetris.color.figure.left", "color",
      "The color of the left angle figure."}
      , {
      "tetris.color.figure.triangle", "color",
      "The color of the triangle figure."}
  };


  public static void main(String[] args) {
    init();
    JFrame frame = new JFrame("Tetris Chicken Brothers");
    final Game game = new Game();
    frame.setLocation(500, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set Icon frame
    ImageIcon image = new ImageIcon("images.png");
    frame.setIconImage(image.getImage());

    // Set up frame
    frame.add(game.getComponent());
    frame.pack();
    // Add frame window listener
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
        game.quit();
      }
    });

    // Show frame (and start game)
    frame.show();
  }

  public static void init() {
    try {
      FileReader reader = new FileReader("game.properties");
      Properties properties = new Properties();
      properties.load(reader);

      String value;

      // Set all configuration parameters
      for (int i = 0; i < PARAMETER.length; i++) {
        value = properties.getProperty(PARAMETER[i][0]);
        if (value != null) {
          Configuration.setValue(PARAMETER[i][0], value);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
}