import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

public class Board extends JComponent{
    final int LENGTH;
    final int NUM_BOXES_IN_ROW;

    public Board(int length){
        this.LENGTH = length;
        NUM_BOXES_IN_ROW = 10;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Random randGen = new Random();
        final int BOX_SIZE = this.LENGTH / this.NUM_BOXES_IN_ROW;

        /* Make board rotationally symmetric */
        for (int y = 0; y < this.LENGTH / 2; y += BOX_SIZE){
            for (int x = 0; x < this.LENGTH; x += BOX_SIZE){
                Color color;
                Color oppositeColor;
                switch (randGen.nextInt(0, 5)){
                    case 0:
                        color = Color.RED;
                        oppositeColor = Color.BLUE;
                        break;
                    case 1:
                        color = Color.BLUE;
                        oppositeColor = Color.RED;
                        break;
                    default:
                        color = Color.BLACK;
                        oppositeColor = Color.BLACK;
                        break;
                }
                g2D.setColor(color);
                g2D.fillRect(x, y, BOX_SIZE, BOX_SIZE);
                g2D.setColor(oppositeColor);
                g2D.fillRect(this.LENGTH - x - BOX_SIZE, this.LENGTH - y - BOX_SIZE, BOX_SIZE, BOX_SIZE);
            }
        }

        g2D.setStroke(new BasicStroke(3));
        g2D.setColor(Color.GRAY);
        // Horizontal lines
        for (int y = 0; y <= this.LENGTH; y += BOX_SIZE){
            g2D.drawLine(0, y, this.LENGTH, y);
        }
        // Vertical lines
        for (int x = 0; x <= this.LENGTH; x += BOX_SIZE){
            g2D.drawLine(x, 0, x, this.LENGTH);
        }
    }
}