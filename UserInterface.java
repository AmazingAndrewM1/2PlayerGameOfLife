import javax.swing.JFrame;

public class UserInterface{
    private JFrame frame;
    private int width;
    private int height;

    public UserInterface(){
        width = 800;
        height = 800;
        frame = new JFrame();
        frame.setTitle("Conway's Game of Life!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(true);

        frame.add(new Board(width, 20));
    }

    public void show(){
        frame.setVisible(true);
    }
}