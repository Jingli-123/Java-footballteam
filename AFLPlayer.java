public class AFLPlayer extends AFLTeamMember{
    protected int PlayerNumber;
    protected Boolean isCaptain;
    
    public AFLPlayer(String FirstName, String LastName, String Position, int PlayerNumber, Boolean isCaptain){
        super(FirstName, LastName, Position);
        setPlayerNumber(PlayerNumber);
        setisCaptain(isCaptain);
    }
    
    public void setPlayerNumber(int PlayerNumber){
        if (PlayerNumber > 0 && PlayerNumber <= 100){
            this.PlayerNumber = PlayerNumber;
        }else {
            PlayerNumber = 0;
        }
        
    }
    public void setisCaptain(Boolean isCaptain){
        this.isCaptain = isCaptain;
        
        
    }
    
    public int getPlayNumber(){
        return PlayerNumber;
    }
    public Boolean getisCaptain(){
        return isCaptain;
    }
    
    public String toString(){
        if (isCaptain == false){
            return "[" + PlayerNumber + "]" + getFirstName() + " " + getLastName() + " " + getPosition(); 
        }else{
            return "[" + PlayerNumber + "]" + getFirstName() + " " + getLastName() + " " + getPosition() + " " + "( c )";
        }
             
    }   
}
