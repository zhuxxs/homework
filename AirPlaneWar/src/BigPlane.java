public class BigPlane extends Fly implements Enemy,Award{
    private static final int SPEED_Y = 1;
    private static final int SCORE = 50;
    private int awards = (int)(Math.random()*2);
    private int emberlife = 0;

    public int getSCORE() {
        return SCORE;
    }

    BigPlane() {
        super((int) (Math.random() * (Window.WIDTH - Window.bigPlane.getWidth())), -Window.bigPlane.getHeight(), Window.bigPlane,5);
    }

    @Override
    public void move() {
        this.setY(getY() + SPEED_Y);
    }

    @Override
    public boolean showember() {
        if (emberlife<19) {
            emberlife++;
            this.setImg(Window.bigplane_ember[emberlife/5]);
            return false;
        }
        return true;
    }

    @Override
    public int award() {
        return awards;
    }
}
