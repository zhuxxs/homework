
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyPanel extends JPanel {
    private CopyOnWriteArrayList<Fly> arrayList = new CopyOnWriteArrayList<Fly>();
    private CopyOnWriteArrayList<Bullet> bulletList = new CopyOnWriteArrayList<Bullet>();
    private CopyOnWriteArrayList<Fly> ember = new CopyOnWriteArrayList<Fly>();
    private Hero hero;
    private int count = 0;
    private int countBullet = 0;

    MyPanel() {
        hero = new Hero();
    }

    public void moves() {
        for (Fly flyObjection : arrayList) {
            flyObjection.move();
        }
        hero.move();
    }

    public void create() {
        Fly fly;
        if (count == 100) {
            count = 0;
            int flag = (int) (Math.random() * 20);
            if (flag == 0) {
                fly = new Bee();
            } else if (flag == 1 || flag == 2) {
                fly = new BigPlane();
            } else fly = new AirPlane();
            arrayList.add(fly);
        } else {
            count++;
        }
    }

    public void crossBorder() {
        Iterator<Fly> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Fly fly = iterator.next();
            if (fly.getY() > Window.HEIGHT) {
                arrayList.remove(fly);
            }
        }

        Iterator<Bullet> bulletIterator = bulletList.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            if (bullet.getY() < -bullet.getWidth()) {
                bulletList.remove(bullet);
            }
        }
    }

    public void shootAction() {
        if (countBullet == 80) {
            countBullet = 0;
            Bullet[] bullets = hero.shoot();
            for (int i = 0; i < bullets.length; i++) {
                bulletList.add(bullets[i]);
            }
        } else {
            countBullet++;
        }
    }

    private void shootMove() {
        for (Bullet bullet : bulletList) {
            bullet.move();
        }
    }

    private void destroy() {
        int x, y;
        for (Bullet bullet : bulletList) {
            for (Fly fly : arrayList) {
                x = bullet.getX() + bullet.getWidth() / 2;
                y = bullet.getY() + bullet.getHeight() / 2;
                if (x <= fly.getX() + fly.getWidth() && x >= fly.getX() && y >= fly.getY() && y <= fly.getY() + fly.getHeight()) {
                    fly.setLife(fly.getLife() - 1);
                    if (fly.getLife() == 0) {
                        if (fly instanceof Enemy) {
                            hero.addScore(((Enemy) fly).getSCORE());
                        }
                        if (fly instanceof Award) {
                            hero.growup(((Award) fly).award());
                        }
                        arrayList.remove(fly);
                        ember.add(fly);
                    }
                    bulletList.remove(bullet);
                }
            }
        }
    }

    private void herotouch() {
        for (Fly fly : arrayList) {
            if (hero.touch(fly)) {
                arrayList.remove(fly);
                hero.decressLife();
                hero.setFiretime(0);
                if (hero.getLife() == 0) {
                    Window.now = 3;
                    hero = new Hero();
                    arrayList.clear();
                    bulletList.clear();
                }
            }
        }
    }

    private void embermove() {
        for (Fly fly : ember) {
            if (fly.showember()) {
                ember.remove(fly);
            }
        }
    }

    public void action() {
        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (Window.now == 1) {
                    create();
                    moves();
                    crossBorder();
                    shootAction();
                    shootMove();
                    destroy();
                    herotouch();
                    embermove();
                    repaint();
                }
            }

        }, 1000, 5);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Window.background, 0, 0, this);
        g.drawImage(hero.getImg(), hero.getX(), hero.getY(), this);
        if (Window.now == Window.START) {
            g.drawImage(Window.start, 0, 0, this);
        }
        paintFly(g);
        if (Window.now == Window.PAUSE) {
            g.drawImage(Window.pause, 0, 0, this);
        }
        paintScoreAndLife(g);
        if (Window.now == Window.GAMEOVER) {
            g.drawImage(Window.gameover, 0, 0, this);
        }
        paintember(g);
    }

    private void paintember(Graphics g) {
        for (Fly fly : ember) {
            g.drawImage(fly.getImg(), fly.getX(), fly.getY(), this);
        }
    }

    private void paintFly(Graphics g) {
        for (Fly fly : arrayList) {
            g.drawImage(fly.getImg(), fly.getX(), fly.getY(), this);
        }
        for (Bullet bullet : bulletList) {
            g.drawImage(bullet.getImg(), bullet.getX(), bullet.getY(), this);
        }
    }

    public void repaintHero(int x, int y) {
        hero.setX(x - hero.getWidth() / 2);
        hero.setY(y - hero.getHeight() / 2);
        repaint();
    }

    public void paintScoreAndLife(Graphics g) {
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("Score:" + hero.getScore(), 0, 20);
        g.drawString("life:" + hero.getLife(), 0, 40);
    }


}