import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		ArrayList<User> network = createFakeNetwork(25000, 150000);
		
		SocialNetwork graph = new SocialNetwork(network);
		graph.writeGraphToFile();
		
		

	}
	
	

	public static void writeCode(){
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mark Miller\\Desktop\\lastnames.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       System.out.println("Names.add(\"" + line + "\");");
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<User> createFakeNetwork(int numberOfUsers, int numberOfConnections){
		ArrayList<User> network = new ArrayList<>();
		Random rand = new Random();
		
		int Age;
		String gender, Name, email, State, userID;
		String firstName, lastName;
		
		//generates fake network of users with no connections
		for(int i = 0; i < numberOfUsers; i++){
			System.out.println("Adding User: " + i + " to the Network");
			Age = Faker.getRandomAge();
			gender = Faker.getRandomGender();
			Name = Faker.getRandomName(gender);
			firstName = Name.substring(0, Name.indexOf(" "));
			lastName = Name.substring(Name.indexOf(" ") + 1);
			email = Faker.getRandomEmail(firstName,lastName);
			State = Faker.getRandomState();
			userID = email.substring(0, email.indexOf("@"));
			
			network.add(new User(Age, Name, "10/03/1997", "United States", State, "Greenwood", "46143", userID, gender, "English", email, "1234"));
		}
		
		//generates random friendships throughout the network
		for(int j = 0; j < numberOfConnections; j++){
			int a = rand.nextInt(network.size() - 1) + 1;
			int b = rand.nextInt(network.size() - 1) + 1;
			System.out.println("Creating Friendship between " + network.get(a).getName() + " and " + network.get(b).getName());
			network.get(a).addFriend(network.get(b));
		}
		
		
		return network;
		
	}





}
