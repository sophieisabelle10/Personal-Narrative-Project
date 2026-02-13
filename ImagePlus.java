import org.code.theater.*;
import org.code.media.*;

/*
 * ImagePlus allows pixel editing by storing pixels in a 2D array
 */
public class ImagePlus extends Image {

  /** pixel grid */
  private Pixel[][] pixels;

  /** constructor loads image pixels */
  public ImagePlus(String filename) {
    super(filename);
    pixels = getPixelsFromImage();
  }

  /** returns pixel array */
  public Pixel[][] getImagePixels() {
    return pixels;
  }

  /** copies pixels from image into 2D array */
  public Pixel[][] getPixelsFromImage() {
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];
    
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        tempPixels[row][col] = getPixel(col, row);
      }
    }
    return tempPixels;
  }
}
