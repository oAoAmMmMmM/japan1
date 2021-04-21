import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame();

        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Cells cells;
        cells = new Cells();

        World world = new World(cells);

        Panel panel = new Panel(world, cells, frame.getGraphics());

        frame.add(panel);
        frame.setVisible(true);

    }
}