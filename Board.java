import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

public class Board extends JComponent{
    final int LENGTH;
    final int NUM_BOXES_IN_ROW;
    final int PADDING;

    public Board(){
        this(800, 10);
    }

    public Board(int length){
        this(length, 10);
    }

    public Board(int length, int numBoxesInRow){
        this.LENGTH = length;
        this.NUM_BOXES_IN_ROW = numBoxesInRow;
        this.PADDING = 50;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Random randGen = new Random();
        final int BOX_SIZE = (this.LENGTH - 2 * this.PADDING) / this.NUM_BOXES_IN_ROW;
        final int FINAL_Y_BOX = BOX_SIZE * this.NUM_BOXES_IN_ROW / 2 + this.PADDING; 
        final int FINAL_Y = this.NUM_BOXES_IN_ROW * BOX_SIZE + this.PADDING;
        final int FINAL_X = FINAL_Y;

        /* Make board rotationally symmetric */
        for (int y = this.PADDING; y < FINAL_Y_BOX; y += BOX_SIZE){
            for (int x = this.PADDING; x < FINAL_X; x += BOX_SIZE){
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
        for (int y = this.PADDING; y <= FINAL_Y; y += BOX_SIZE){
            g2D.drawLine(this.PADDING, y, this.LENGTH - this.PADDING, y);
        }
        // Vertical lines
        for (int x = this.PADDING; x <= FINAL_X; x += BOX_SIZE){
            g2D.drawLine(x, this.PADDING, x, this.LENGTH - this.PADDING);
        }
    }
}