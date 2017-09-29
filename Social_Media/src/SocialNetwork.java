/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Miller
 */
public class SocialNetwork {

    private ArrayList<User> allUsers = new ArrayList<>();

    public SocialNetwork(ArrayList<User> allusers) {
       setAllUsers(allusers);
    }




    public void printUndirectedGraph() {
       
    }

    public List<User> findPathDFS(User Start, User Target) {
        ArrayList<User> Path = new ArrayList<>();
        return Path;
        }
    public List<User> findPathDFS(int Start, int Target) {
        ArrayList<User> Path = new ArrayList<>();
        return Path;
    }
    public List<User> findPathBFS(User Start, User Target) {
        ArrayList<User> Path = new ArrayList<>();

        return Path;
    }
    public List<User> findPathBFS(int Start, int Target) {
        ArrayList<User> Path = new ArrayList<>();

        return Path;
    }




	public ArrayList<User> getAllUsers() {
		return allUsers;
	}




	public void setAllUsers(ArrayList<User> allUsers) {
		this.allUsers = allUsers;
	}

    
    //Prints graph info into two CSV files
    //CSV files are meant to be imported into Gephi0.9.2 for visualization purposes
    public void writeGraphToFile() {
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\Mark Miller\\Desktop\\SocialNetworkEdges.csv", "UTF-8");
            writer.println("Source,Target");
            for(int i = 0; i < allUsers.size(); i++){
                for(int j = 0; j < allUsers.get(i).getFriends().size(); j++){
                    writer.println(allUsers.get(i).getUserID() + "," + allUsers.get(i).getFriends().get(j).getUserID());
                }
            }
            writer.close();
        } catch (IOException e) {
        	System.out.println("Error: Edge");
        }
        
        
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\Mark Miller\\Desktop\\SocialNetworkNodes.csv", "UTF-8");
            writer.println("id,label,Birthday,Country,State,City,Zipcode,Age,Gender,Email");
            for(int i = 0; i < allUsers.size(); i++){
                writer.println(allUsers.get(i).getUserID() + "," + allUsers.get(i).getName() + "," 
                			   + allUsers.get(i).getDateOfBirth() + "," + allUsers.get(i).getCountry()
                			   + "," + allUsers.get(i).getState() + "," + allUsers.get(i).getCity()
                			   + "," + allUsers.get(i).getZIP() + "," + allUsers.get(i).getAge()
                			   + "," + allUsers.get(i).getGender()+ "," + allUsers.get(i).getEmail());
                
            }
            writer.close();
        } catch (IOException e) {
        	System.out.println("Error: Node");
        }
    }
}