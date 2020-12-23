public class Bullet extends Fly {
    private static final int speed_y = -1;

    Bullet(int x, int y) {
        super(x, y, Window.bullet, 1);
    }

    @Override
    public void move() {
        this.setY(this.getY() + speed_y);
    }

    @Override
    public boolean showember() {
        return false;
    }
}
