import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** constructor */
  public SceneTwo() {
  }

  /**
   * runs the second scene
   * precondition: scene must be created
   * postcondition: ending screen displays
   */
  public void drawScene() {
    clear("white");
    showTitle();
    playMusic();
    pause(2);
  }

  /** displays ending message */
  private void showTitle() {
    drawText("Thanks for Watching!", 80, 200);
  }

  /** plays background audio */
  private void playMusic() {
    playSound("applause2_x.wav");
  }
}
