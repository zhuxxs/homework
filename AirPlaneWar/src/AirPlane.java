public class AirPlane extends Fly implements Enemy {
    private static final int SPEED_Y = 1;
    private static final int SCORE = 10;
    private int emberlife = 0;

    public  int getSCORE() {
        return SCORE;
    }

    AirPlane() {
        super((int) (Math.random() * (Window.WIDTH - Window.airPlane.getWidth())), -Window.airPlane.getHeight(), Window.airPlane,1);
    }

    public void move() {
        this.setY(getY() + SPEED_Y);
    }

    @Override
    public boolean showember() {
        if (emberlife<3) {
            emberlife++;
            this.setImg(Window.airplane_ember[emberlife]);
            return false;
        }
        return true;
    }
}
