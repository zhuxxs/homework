import java.awt.*;

public class Hero extends Fly {
    private int score = 0;
    private int count = 0;
    private int num = 0;
    private int firetime = 0;
    private int emberlife = 0;

    Hero() {
        super(Window.WIDTH / 2 - Window.hero.getWidth() / 2, Window.HEIGHT * 2 / 3 - Window.hero.getHeight() / 2, Window.hero, 3);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.setScore(this.getScore() + score);
    }

    public void setFiretime(int firetime) {
        this.firetime = firetime;
    }

    public Bullet[] shoot() {
        Bullet[] bullets;
        if (num == 0) {
            bullets = new Bullet[1];
            bullets[0] = new Bullet(this.getX() + this.getWidth() / 2, this.getY());
            return bullets;
        } else {
            firetime--;
            if (firetime == 0) {
                num = 0;
            }
            bullets = new Bullet[2];
            bullets[0] = new Bullet(this.getX() + this.getWidth() / 3, this.getY());
            bullets[1] = new Bullet(this.getX() + this.getWidth() * 2 / 3, this.getY());
            return bullets;
        }
    }

    @Override
    public void move() {
        if (count == 20) {
            count = 0;
            this.setImg(Window.hero1);
        } else if (count == 10) {
            this.setImg(Window.hero);
            count++;
        } else {
            count++;
        }
    }

    @Override
    public boolean showember() {
        if (emberlife < 3) {
            emberlife++;
            this.setImg(Window.hero_ember[emberlife]);
            return false;
        }
        return true;
    }

    public void addLife() {
        this.setLife(this.getLife() + 1);
    }

    public void decressLife() {
        this.setLife(this.getLife() - 1);
    }

    public void growup(int award) {
        if (award == 0) {
            this.addLife();
        } else {
            this.num = 1;
            this.firetime = 10;
        }
    }

    public boolean touch(Fly fly) {
        Rectangle herptangle = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        Rectangle flytangle = new Rectangle(fly.getX(), fly.getY(), fly.getWidth(), fly.getHeight());
        if (herptangle.intersects(flytangle)) {
            return true;
        } else return false;
    }
}
