import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Panel extends JPanel {

    World world;
    Cells cells;


    public int winowWidth = 750;
    public int windowHeight = 750;

    public Panel(World world, Cells cells ) throws IOException {
        this.world = world;
        this.cells = cells;
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