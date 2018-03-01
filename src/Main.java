import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Ride> rides = new LinkedList<>();
    public static LinkedList<Vehicle> vehicles = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("d_metropolis.in");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        st = br.readLine();
        String[] firstLine = st.split(" ");
        int rowCount = Integer.parseInt(firstLine[0]);
        int colCount = Integer.parseInt(firstLine[1]);
        int vehicleCount = Integer.parseInt(firstLine[2]);
        int rideCount = Integer.parseInt(firstLine[3]);
        int bonus = Integer.parseInt(firstLine[4]);
        int turn = Integer.parseInt(firstLine[5]);
        int rideID = 0;
        while ((st = br.readLine()) != null) {
            String[] tempLine = st.split(" ");
            rides.add(new Ride(tempLine,rideID++));
        }
        for (int i = 0; i < vehicleCount; i++) {
            vehicles.add(new Vehicle(new LinkedList<Integer>(), 0, 0, true));
        }

        for (int i = 0; i < turn; i++) {
            for (Vehicle vehicle: vehicles) {
                vehicle.move();
                if(vehicle.currentRide != null && vehicle.checkIsFinished()) {
                    vehicle.isAvailable = true;
                }
                if(vehicle.isAvailable) {
                   Ride ride = vehicle.getRide(rides, i, bonus);
                   if (ride == null) {

                       break;
                   }
                   vehicle.rides.add(ride.rideId);
                   vehicle.currentRide = ride;
                   int index = getRideIndex(vehicle.currentRide);
                   vehicle.currX = vehicle.currentRide.x2;
                   vehicle.currY = vehicle.currentRide.y2;
                   rides.remove(index);
                   vehicle.isAvailable = false;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("d_metropolis.out"));
        for (Vehicle vehicle:vehicles) {
            out.print(vehicle.rides.size() + " ");
            for (Integer ride:vehicle.rides) {
                out.print(ride.toString() + " ");
            }
            out.println();
        }
        out.close();
    }
    public static int getRideIndex(Ride ride) {
        for (int i = 0; i < rides.size(); i++) {
            if (ride.rideId == rides.get(i).rideId)
                return i;
        }
        return -1;
    }


    }


