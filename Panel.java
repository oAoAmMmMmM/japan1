import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    World world;
    Cells cells;


    public int winowWidth = 750;
    public int windowHeight = 750;
    BufferedImage myImage;

    public Panel(World world, Cells cells, Graphics g ) throws IOException {
        this.world = world;
        this.cells = cells;
        this.myImage = ImageIO.read(new File("784_800_auto_jpg_5_80.jpg"));
        g.drawImage( myImage, 0, 0, 750, 750, null);
    }

    public void paintComponent(Graphics g) {
        g.drawRect(winowWidth/2-175, windowHeight/2-175, 350, 350);
        for (int a = 1; a <= 4; a = a + 1) {
            g.drawLine(winowWidth/2-175+70*a, windowHeight/2-175, winowWidth/2-175+70*a, windowHeight/2-175+350);
            g.drawLine(winowWidth/2-175, windowHeight/2-175+70*a, winowWidth/2-175+350, windowHeight/2-175+70*a);
        }
        cells.Znacheniya(g);
        cells.Algoritm(g);
    }
}