import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

// Everything is commented out for the time being. All parsing currently exists in the Model for M6.
// The database will eventually handle parsing the data and the Model will be able to access the
// database for the information.

//public class ReadCSV {
	/*
	Unique Key.  0
	Location Type 7
	Incident Zip 8
	Incident Address 9
	City 16
	Borough 17
	Latitude len - 3
	Longitude len - 2
	*/


	/*public static void main(String[] args) throws IOException {
		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader(
				"Rat_Sightings.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		String[] data = null;
		String db = null;
		HashMap<String, String> map = new HashMap<>();
		//List<Employee> empList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			scanner = new Scanner(line);
			//scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				data = scanner.nextLine().split(",");
				String lat = data[data.length - 2].replace("\"(","");
				//System.out.println(scanner.nextLine());
				db = data[0] + " " + data[1] + " " + data[7] + " " + data[8] + " " + data[9] + " " + 
					data[16] + " " + data[17] + " " + data[23] + " " + data[data.length - 3] + " " + 
					data[data.length - 2].replace("\"(","");
				System.out.println(db);
				break;
			}
			index = 0;

		}
		
		//close reader
		reader.close();
		

		
	}*/

//}