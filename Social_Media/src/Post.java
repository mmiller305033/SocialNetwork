
import java.util.Date;

public class Post {
	private String Message;
	private Date timeStamp = new Date();
	
	public Post(String message){
		Message = message;
	}
	public void editPost(String message){
		Message = message;
	}
	public String getMessage(){
		return Message;
	}
	public Date getTimeStamp(){
		return timeStamp;
	}
}
