import java.awt.*;
public class Drawings extends Canvas {
    public void paint(Graphics g){
        g.drawRect(50, 75, 100, 50);
        g.fillRect(200, 75 , 50, 50);
        g.drawOval(50, 200, 100, 50);
        g.fillOval(200, 200, 50, 50);
        g.drawRoundRect(50, 300, 100, 50, 20, 20);
        g.fillRoundRect(200, 300, 50, 50, 20, 20);
        g.drawArc(50, 400, 100, 50, 0, 180);
        g.fillArc(200, 400, 50, 50, 0, 180);
    }

    public static void main(String[] args){
        Drawings m = new Drawings();
        Frame f = new Frame("Shapes");
        f.add(m);
        f.setSize(400, 500);
        f.setVisible(true);
    }
}
