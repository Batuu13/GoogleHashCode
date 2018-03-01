import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Vehicle {
    LinkedList<Integer> rides;
    int currX;
    int currY;
    boolean isAvailable;
    public Ride currentRide;

    public Vehicle(LinkedList<Integer> rides, int currX, int currY, boolean isAvailable) {
        this.rides = rides;
        this.currX = currX;
        this.currY = currY;
        this.isAvailable = isAvailable;
    }

    public Ride getRide(List<Ride> rides,int currentTime,int bonus){
        rides.sort(new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                int score1 = Math.abs(o1.x1 - currX) + Math.abs(o1.y1 - currY);
                int score2 = Math.abs(o2.x1 - currX) + Math.abs(o2.y1 - currY);
                if(score1 > score2){
                    return -1;
                }
                if(score1 < score2){
                    return 1;
                }
                else{
                    int ride1Value = o1.getRoadLength() + bonusValue(o1,currentTime,bonus);
                    int ride2Value = o2.getRoadLength() + bonusValue(o2,currentTime,bonus);
                    if(ride1Value >= ride2Value){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }

            }
        });

        for(int i = 0 ; i < rides.size(); i++){
            int timeToGetThere = rides.get(i).getDistance(currX,currY);
            int timeOnRoad = rides.get(i).getRoadLength();
            int waitingTime = rides.get(i).startTime - (timeToGetThere + currentTime);
            if(timeToGetThere + timeOnRoad + waitingTime < rides.get(i).finishTime)
            {
                return rides.get(i);
            }
        }
        return null;
    }
    public void checkIsFinished(){
        if(currentRide.x2 == currX && currentRide.y2 == currX){
            isAvailable = true;
        }
    }
    private int bonusValue(Ride ride,int currentTime,int bonus){
        int timeToGetThere = ride.getDistance(currX,currY);
        if(timeToGetThere + currentTime > ride.startTime)
            return 0;
        else{
            return bonus;
        }
    }
}
