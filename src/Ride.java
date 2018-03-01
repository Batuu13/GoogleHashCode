public class Ride {
    public int rideId; // row number
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    public int startTime;
    public int finishTime;

    public Ride(String[] data){
        this.x1 = Integer.parseInt(data[0]);
        this.x2 = Integer.parseInt(data[1]);
        this.y1 = Integer.parseInt(data[2]);
        this.y2 = Integer.parseInt(data[3]);
        this.startTime = Integer.parseInt(data[4]);
        this.finishTime = Integer.parseInt(data[5]);
    }
    @Override
    public boolean equals(Object o) {
        System.out.println(((Ride)o).rideId);
        if(((Ride)o).rideId == this.rideId){
            return true;
        }
        return false;
    }
    public Integer getDistance(Integer x,Integer y){
        return Math.abs(x-this.x1) + Math.abs(y-this.y1);
    }
    public Integer getRoadLength(){
        return Math.abs(this.x2-this.x1) + Math.abs(this.y2-this.y1);
    }
}
