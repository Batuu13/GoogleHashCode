import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Ride> rides = new LinkedList<>();
    public static LinkedList<Vehicle> vehicles = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("a_example.in");

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

        while ((st = br.readLine()) != null) {
            String[] tempLine = st.split(" ");
            rides.add(new Ride(tempLine));


            for (int i = 0; i < vehicleCount; i++) {
                vehicles.add(new Vehicle(new int[]{}, 0, 0, true));




            }
        }
    }
}

