import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /** constructor */
  public ImageFilter(String filename) {
    super(filename);
  }

  /**
   * sharpens image by increasing contrast between pixels
   */
  public void sharpen() {
    Pixel[][] pixels = getImagePixels();

    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {

        Pixel current = pixels[row][col];
        Pixel neighbor = pixels[row - 1][col - 1];

        int redDiff = current.getRed() - neighbor.getRed();
        int greenDiff = current.getGreen() - neighbor.getGreen();
        int blueDiff = current.getBlue() - neighbor.getBlue();
      
        int avg = (redDiff + greenDiff + blueDiff) / 3;

        current.setRed(Math.min(255, current.getRed() + avg));
        current.setGreen(Math.min(255, current.getGreen() + avg));
        current.setBlue(Math.min(255, current.getBlue() + avg));
      }
    }
  }

  /** turns image into negative */
  public void makeNegative() {
    Pixel[][] pixels = getImagePixels();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {
        Pixel p = pixels[r][c];
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
      }
    }
  }

  /** applies sepia tone */
  public void applySepia() {
    Pixel[][] pixels = getImagePixels();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {

        Pixel p = pixels[r][c];

        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();

        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

        p.setRed(Math.min(255, newRed));
        p.setGreen(Math.min(255, newGreen));
        p.setBlue(Math.min(255, newBlue));
      }
    }
  }

  /** colorizes image based on brightness */
  public void colorize() {
    Pixel[][] pixels = getImagePixels();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[0].length; c++) {

        Pixel p = pixels[r][c];
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;

        if (avg < 85) {
          p.setRed(255); p.setGreen(0); p.setBlue(0);
        }
        else if (avg < 170) {
          p.setRed(0); p.setGreen(255); p.setBlue(0);
        }
        else {
          p.setRed(0); p.setGreen(0); p.setBlue(255);
        }
      }
    }
  }
}
