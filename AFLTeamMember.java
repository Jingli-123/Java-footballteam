import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AFLTeamMember {
    protected String FirstName; 
    protected String LastName;
    protected String Position;
    //constructor
    public AFLTeamMember(String FirstName, String LastName, String Position){
        this.FirstName = FirstName;
        this.LastName = LastName;
        setPosition(Position);
    }
    //setter
    public void setFirstName(String newFirstName){
        this.FirstName = newFirstName;
    }
    public void setLastName(String newLastName){
        this.LastName = newLastName;
    }
    public void setPosition(String newPosition){
        List<String> Position_list = new ArrayList<>(Arrays.asList("FB", "HB", "C", "HF", "FF", "FOL", "IC", "COACH"));
        Boolean P = Position_list.contains(newPosition);
        if (P == true){
            Position = newPosition;
        }else{
            Position = "Not a voild position.";
        }
    }
    //Getter
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getPosition(){
        return Position;
        
    }
    //to string method
    public String toString(){
        return FirstName + " " + LastName + ", " + Position;
    }
}
