import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** stores categorized images */
  private ImageFilter[][] data;

  /** constructor receives image data */
  public SceneOne(ImageFilter[][] data) {
    this.data = data;
  }

  /**
   * controls full animation for scene one
   * precondition: data must be initialized
   * postcondition: all image sections play
   */
  public void drawScene() {
    drawDanceImages();
    drawMusicImages();
    drawDifferentImages();
  }

  /**
   * shows dance images with multiple filters
   */
  private void drawDanceImages() {
    for (ImageFilter img : data[0]) {
      clear("white");
      drawText("Dance", 150, 380);

      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);

      img.sharpen();
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);

      img.makeNegative();
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);

      img.applySepia();
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);

      img.colorize();
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

  /**
   * shows music images
   */
  private void drawMusicImages() {
    for (ImageFilter img : data[1]) {
      clear("white");
      drawText("Music", 150, 380);

      if (img != null) {
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);

        img.applySepia();
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);
      }
    }
  }

  /**
   * shows other interests
   */
  private void drawDifferentImages() {
    for (ImageFilter img : data[2]) {
      clear("white");
      drawText("Styles", 150, 380);

      if (img != null) {
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);

        img.makeNegative();
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);
      }
    }
  }
}
