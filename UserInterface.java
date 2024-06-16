import javax.swing.JFrame;

public class UserInterface{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().add(new ShapeDrawing());
        frame.setVisible(true);
    }
}