import java.awt.image.BufferedImage;

public abstract class Fly {
    private int x;
    private int y;
    private BufferedImage img;
    private int width;
    private int height;
    private int life;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    Fly() {
    }

    Fly(int x, int y, BufferedImage img, int life) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.life = life;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void move();

    public abstract boolean showember();
}
