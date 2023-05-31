import java.util.*;
public class AFLTeam {
    private String name;
    private AFLTeamMember coach;
    private ArrayList<AFLPlayer> lineup;

    public AFLTeam (String name, AFLTeamMember coach, ArrayList<AFLPlayer> lineup){
        this.name = name;
        this.coach = coach;
        this.lineup = lineup;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoach(AFLTeamMember coach) {
        this.coach = coach;
    }
    public void setLineup(ArrayList<AFLPlayer> lineup) {
        this.lineup = lineup;
    }
    public AFLTeamMember getCoach() {
        return coach;
    }
    public String getName() {
        return name;
    }
    public ArrayList<AFLPlayer> getLineup() {
        return lineup;
    }

    

}
