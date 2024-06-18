import javax.swing.JFrame;

public class UserInterface{
    private JFrame frame;

    public UserInterface(){
        frame = new JFrame();
        frame.setTitle("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        frame.add(new Board(800));
    }

    public void show(){
        frame.setVisible(true);
    }
}