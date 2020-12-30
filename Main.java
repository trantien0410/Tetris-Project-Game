
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main
    extends Applet {
  /*
    Class to configure to run Game by Applet
   */
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

  private Game game = null;

  public static void main(String[] args) {
    JFrame frame = new JFrame("Tetris Advance");
    Game game = new Game();
    frame.setLocation(500, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Set up frame
    frame.add(game.getComponent());
    frame.pack();
//    new Dongho();
    // Add frame window listener
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // Show frame (and start game)
    frame.show();
  }

  public String[][] getParameterInfo() {
    return PARAMETER;
  }

  public void init() {
    String value;

    // Set all configuration parameters
    for (int i = 0; i < PARAMETER.length; i++) {
      value = getParameter(PARAMETER[i][0]);
      if (value != null) {
        Configuration.setValue(PARAMETER[i][0], value);
      }
    }

    // Create game object
    game = new Game();

    // Initialize applet component
    setLayout(new BorderLayout());
    add(game.getComponent(), "Center");
  }

  public void stop() {
    game.quit();
  }

  public static class COMClassObject
      extends Object {

  }
}