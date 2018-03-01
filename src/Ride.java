public class Ride {
    int rideId; // row number
    public Integer x1;
    public Integer x2;
    public Integer y1;
    public Integer y2;
    public Integer startTime;
    public Integer finishTime;

    public Ride(String[] data){
        this.x1 = Integer.parseInt(data[0]);
        this.x2 = Integer.parseInt(data[1]);
        this.y1 = Integer.parseInt(data[2]);
        this.y2 = Integer.parseInt(data[3]);
        this.startTime = Integer.parseInt(data[4]);
        this.finishTime = Integer.parseInt(data[5]);
    }

    public Integer getDistance(Integer x,Integer y){
        return Math.abs(x-this.x1) + Math.abs(y-this.y1);
    }
}
