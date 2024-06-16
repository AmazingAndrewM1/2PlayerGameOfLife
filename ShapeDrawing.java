import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShapeDrawing extends JComponent{
    @Override
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        final int BOX_SIZE = 50;
        for (int r = 0; r < 10; ++r){
            for (int c = 0; c < 10; ++c){
                g2D.drawRect(c * BOX_SIZE, r * BOX_SIZE, BOX_SIZE, BOX_SIZE);
            }
        }
    }
}