public class Vehicle {
    int[] rides;
    int currX;
    int currY;
    boolean isAvailable;

    public Vehicle(int[] rides, int currX, int currY, boolean isAvailable) {
        this.rides = rides;
        this.currX = currX;
        this.currY = currY;
        this.isAvailable = isAvailable;
    }
}
