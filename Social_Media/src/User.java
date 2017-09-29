/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mark Miller
 */
public class User {
	//Instance Variables
	private int Age;
	private String Name, DateOfBirth, State, Country, City, ZIP, userID, Gender, Language, Email, Password;
	private ArrayList<User> friends = new ArrayList<>();
	private ArrayList<Post> posts = new ArrayList<>();
    
	
	
	//Constructor
    public User(int age, String name, String dateofbirth, 
    			String country, String state, String city, String zip, 
    			String userid, String gender, String language,
    			String email, String password){
    	

    	Age = age;
    	Name = name;
    	DateOfBirth = dateofbirth;
    	Country = country;
    	State = state;
    	City = city;
    	ZIP = zip;
    	userID = userid;
    	Gender = gender;
    	Language = language;
    	Email = email;
    	Password = password;
    }  
   
    

    //Getters and Setters
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zip) {
		ZIP = zip;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	public ArrayList<User> getFriends(){
        return friends;
    }
    public void addFriend(User v){
        //System.out.println("Connection Created Between " + v.getLabel() + "and " + this.getLabel());
        if(v != this){
            if(!friends.contains(v)){
               friends.add(v);
            }
            if(!v.getFriends().contains(this)){
               v.addFriend(this);
            }         
        }  
    }



	
    public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	//User Methods
	public void addPost(String message){
		posts.add(new Post(message));
	}
	public void removePost(int i){
		posts.remove(i);
	}
	public Post getPost(int i){
		return posts.get(i);
	}
 	public Post getPostByDate(Date d){
		for(int i = 0; i < posts.size(); i++){
			if(posts.get(i).getTimeStamp() == d){
				return posts.get(i);
			}
		}
		return null;
		
	}
	public ArrayList<Post> getPostsContaining(String substring){
		ArrayList<Post> results = new ArrayList<>();
		for(int i = 0; i < posts.size(); i++){
			if(posts.get(i).getMessage().contains(substring)){
				results.add(posts.get(i));
			}
		}
		return results;
		
	}
    public ArrayList<Post> getPostsFromTo(Date from, Date to){
    	ArrayList<Post> results = new ArrayList<>();
		for(int i = 0; i < posts.size(); i++){
			if(posts.get(i).getTimeStamp().after(from) && posts.get(i).getTimeStamp().before(to)){
				results.add(posts.get(i));
			}
		}
    	return results;
    }
	public ArrayList<Post> getAllPosts(){
		return posts;
	}

	
}
