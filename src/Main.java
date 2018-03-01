import java.io.*;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Ride> rides = new LinkedList<>();
    public static void main(String [] args) throws IOException {
        File file = new File("a_example.in");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        st = br.readLine();
        String [] firstLine = st.split(" ");
        Integer rowCount = Integer.parseInt(firstLine[0]);
        Integer colCount = Integer.parseInt(firstLine[1]);
        Integer carCount = Integer.parseInt(firstLine[2]);
        Integer rideCount = Integer.parseInt(firstLine[3]);
        Integer bonus = Integer.parseInt(firstLine[4]);
        Integer turn = Integer.parseInt(firstLine[5]);

        while ((st = br.readLine()) != null)
        {
            String [] tempLine = st.split(" ");
            rides.add(new Ride(tempLine));
        }
    }
    }

