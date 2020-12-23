public class Bee extends Fly implements Award{
    private int speed_x = 2;
    private int speed_y = 1;
    private int awards = (int)(Math.random()*2);
    private int emberlife = 0;

    Bee() {
        super((int) (Math.random() * (Window.WIDTH - Window.bee.getWidth())), -Window.bee.getHeight(), Window.bee,1);
    }

    @Override
    public void move() {
        this.setX(getX() + speed_x);
        this.setY(getY() + speed_y);
        if (this.getX() < 0 || this.getX() > (Window.WIDTH - this.getWidth())) {
            speed_x *= -1;
        }
    }

    @Override
    public boolean showember() {
        if (emberlife<3) {
            emberlife++;
            this.setImg(Window.bee_ember[emberlife]);
            return false;
        }
        return true;
    }

    @Override
    public int award() {
        return awards;
    }
}
