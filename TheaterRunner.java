import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D array storing categorized images
    // row 0 = dance styles
    // row 1 = music interest
    // row 2 = other styles
    ImageFilter[][] data = {
      { new ImageFilter("ballet.jpg"), new ImageFilter("folklorico.jpg") },
      { new ImageFilter("jazz.jpg"), null },
      { new ImageFilter("contemporary.jpg"), new ImageFilter("hiphop.jpg") }
    };

    // create scene objects
    SceneOne scene1 = new SceneOne(data);
    SceneTwo scene2 = new SceneTwo();
    
    // draw scenes
    scene1.drawScene();
    scene2.drawScene();
    
    // play animation
    Theater.playScenes(scene1, scene2);
  }
}
