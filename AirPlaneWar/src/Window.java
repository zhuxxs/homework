import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.MemoryImageSource;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;


public class Window {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;
    public static BufferedImage hero = null;
    public static BufferedImage hero1 = null;
    public static BufferedImage background = null;
    public static BufferedImage bee = null;
    public static BufferedImage airPlane = null;
    public static BufferedImage bigPlane = null;
    public static BufferedImage bullet = null;
    public static BufferedImage start = null;
    public static BufferedImage pause = null;
    public static BufferedImage gameover = null;
    public static BufferedImage[] airplane_ember=new BufferedImage[4];
    public static BufferedImage[] bee_ember=new BufferedImage[4];
    public static BufferedImage[] hero_ember=new BufferedImage[4];
    public static BufferedImage[] bigplane_ember=new BufferedImage[4];
    public static int now = 0;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;

    static {
        try {
            background = ImageIO.read(new File("AirPlaneWar/src/shooter/background.png"));
            hero = ImageIO.read(new File("AirPlaneWar/src/shooter/hero0.png"));
            hero1 = ImageIO.read(new File("AirPlaneWar/src/shooter/hero1.png"));
            bee = ImageIO.read(new File("AirPlaneWar/src/shooter/bee.png"));
            airPlane = ImageIO.read(new File("AirPlaneWar/src/shooter/airPlane.png"));
            bigPlane = ImageIO.read(new File("AirPlaneWar/src/shooter/bigPlane.png"));
            bullet = ImageIO.read(new File("AirPlaneWar/src/shooter/bullet.png"));
            start = ImageIO.read(new File("AirPlaneWar/src/shooter/start.png"));
            pause = ImageIO.read(new File("AirPlaneWar/src/shooter/pause.png"));
            gameover= ImageIO.read(new File("AirPlaneWar/src/shooter/gameover.png"));
            for (int i = 0; i < 4; i++) {
                airplane_ember[i]=ImageIO.read(new File("AirPlaneWar/src/shooter/airplane_ember"+i+".png"));
                bee_ember[i]=ImageIO.read(new File("AirPlaneWar/src/shooter/bee_ember"+i+".png"));
                hero_ember[i]=ImageIO.read(new File("AirPlaneWar/src/shooter/hero_ember"+i+".png"));
                bigplane_ember[i]=ImageIO.read(new File("AirPlaneWar/src/shooter/bigplane_ember"+i+".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        MyPanel myPanel = new MyPanel();
        window.add(myPanel);
        window.setVisible(true);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (now == START) {
                    now = RUNNING;
                    Toolkit tk=Toolkit.getDefaultToolkit();
                    Image img=tk.getImage("");
                    Cursor cu=tk.createCustomCursor(img,new Point(10,10),"stick");
                    window.setCursor(cu);
                }
                ;
                if (now == GAMEOVER) {
                    now = START;
                }
                ;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (now == PAUSE) {
                    now = RUNNING;
                }
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (now == RUNNING) {
                    now = PAUSE;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                if (now == RUNNING) {
                    myPanel.repaintHero(e.getX(), e.getY());
                }
            }
        };
        window.addMouseListener(mouseAdapter);
        window.addMouseMotionListener(mouseAdapter);
        myPanel.action();
    }
}
