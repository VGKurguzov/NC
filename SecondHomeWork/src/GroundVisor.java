public class GroundVisor {
    private Ground ground;

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public boolean hasObstacles(int length, int width) throws GroundVisorException{
        if (ground.getLength() < length || ground.getLength() < 0){
            throw new GroundVisorException("GroundVisor.the class went beyond the Ground.class");
        }
        if (ground.getWidth() < width || ground.getWidth() < 0){
            throw new GroundVisorException("GroundVisor.the class went beyond the Ground.class");
        }
        if((ground.getLength() == length || ground.getWidth() == width))
            return true;
        return false;
    }
}
