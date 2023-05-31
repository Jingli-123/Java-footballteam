import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Condition;
public class AFLMatch {
    private double homeScore;
    private double homefinal;
    private double awayScore;
    private double awayfinal;
    public AFLMatch(double homeScore, double homefinal, double awayScore, double awayfinal){
        this.homeScore = homeScore;
        this.homefinal = homefinal;
        this.awayScore = awayScore;
        this.awayfinal = awayfinal;
    }
    public AFLMatch(){
        homeScore = 0.0;
        awayScore = 0.0;
    }
    public void setHomeScore(double homeScore) {
        this.homeScore = homeScore;
    }
    public void setHomefinal(double homefinal) {
        this.homefinal = homefinal;
    }
    public void setAwayScore(double awayScore) {
        this.awayScore = awayScore;
    }
    public void setAwayfinal(double awayfinal) {
        this.awayfinal = awayfinal;
    }
    public double getHomeScore() {
        return homeScore;
    }
    public double getHomefinal() {
        return homefinal;
    }
    public double getAwayScore() {
        return awayScore;
    }
    public double getAwayfinal() {
        return awayfinal;
    }
    public static void main(String[] args) throws IOException {
        AFLMatch test = new AFLMatch();
        String out1 = test.loadlineup(args);
        String out2 = test.playGame().toString();
        System.out.println(out1);
        System.out.println(out2);
        File myfFile = new File("Finalscore.txt");
        PrintWriter out = new PrintWriter(myfFile);
        out.println(out1);
        out.println(out2);
        out.close();

        
    }
    public String playGame(){
        Boolean condition = true;
        Scanner kb = new Scanner(System.in);
        while (condition){
            System.out.println("Which team scored?");
            String answer1 = kb.nextLine();
            
            if (answer1.equals("h")){
                System.out.println("Goal or behind?");
                String answer2 = kb.nextLine();
                if(answer2.equals("g")){
                    homeScore += 1.0;
                    homefinal += 6;
                    System.out.println("The current score is " + homeScore + "(" + homefinal + ") to " + + awayScore + "(" + awayfinal + ").");
                }else if (answer2.equals("b")){
                    homeScore += 0.1;
                    homefinal += 1;
                    System.out.println("The current score is " + homeScore + "(" + homefinal + ") to " + + awayScore + "(" + awayfinal + ").");
            } 
        }else if (answer1.equals("a")){
                System.out.println("Goal or behind?");
                String answer2 = kb.nextLine();
                if (answer2.equals("g")){
                    awayScore += 1.0;
                    awayfinal += 6;
                    System.out.println("The current score is " + homeScore + "(" + homefinal + ") to " + + awayScore + "(" + awayfinal + ").");
                }else if (answer2.equals("b")){
                    awayScore += 0.1;
                    awayfinal += 1;
                    System.out.println("The current score is " + homeScore + "(" + homefinal + ") to " + + awayScore + "(" + awayfinal + ").");
            }}else if (answer1.equals("f")){
                break;
                
            }
        }
     
        return "Home team Final Score is: " + homefinal + ". \n " +"Away team Final Score is: " + awayfinal;
    
}
    
    public String loadlineup(String args[])throws IOException{   
        String result; 
        //Home team loading.
        File f1 = new File(args[0]);
        FileReader file1 = new FileReader(f1);
        BufferedReader br1 = new BufferedReader(file1);
        ArrayList<String> team1 = new ArrayList<>();
        String line1;   
       
        while ((line1 = br1.readLine())!= null){
            String str1 = line1.replaceAll(",", " ");
            
            String[] teamStrings1 = str1.trim().split("\\s+");
            for (int i = 0; i < teamStrings1.length; i++){
                team1.add(teamStrings1[i]);
            } 
        }
        ArrayList<AFLPlayer> home_team = new ArrayList<>();
        String firstNC1 = team1.get(2);
        String lastNC1 = team1.get(3);
        String posNC1 = team1.get(4);
        AFLTeamMember homeCoach = new AFLTeamMember(firstNC1, lastNC1, posNC1);
        String homeTname = team1.get(0) + " " +team1.get(1);
        
        while (team1.contains("c")){
            int c_index1 = team1.indexOf("c");
            Boolean isCaptain = true;
            int pN = Integer.valueOf(team1.get(c_index1-4)).intValue();
            String fString = team1.get(c_index1-3);
            String lString = team1.get(c_index1-2);
            String pString = team1.get(c_index1-1);
            AFLPlayer homPlayerC = new AFLPlayer(fString, lString, pString, pN, isCaptain);
            team1.remove(c_index1);
            team1.remove(c_index1-4);
            team1.remove(c_index1-4);
            team1.remove(c_index1-4);
            team1.remove(c_index1-4);    
            home_team.add(homPlayerC);    
            break;          
        }
        team1.remove(0);
        team1.remove(0);
        team1.remove(0);
        team1.remove(0);
        team1.remove(0);

        
        while (team1.size() != 0){
            int PlayerNumber = Integer.valueOf(team1.get(0)).intValue();
            String firstNp1 = team1.get(1);
            String lastNp1 = team1.get(2);
            String posNp1 = team1.get(3); 
            Boolean isCaptain = false;
            AFLPlayer homPlayer = new AFLPlayer(firstNp1, lastNp1, posNp1, PlayerNumber, isCaptain);
            home_team.add(homPlayer);
            
            team1.remove(0);
            team1.remove(0);
            team1.remove(0);
            team1.remove(0);
        }
        br1.close();
        file1.close();
        result = "Home team is " + homeTname;
        //Away team loading.
        String result2;
        String awayTname;
        File f2 = new File(args[1]);
        FileReader file2 = new FileReader(f2);
        BufferedReader br2 = new BufferedReader(file2);
        ArrayList<String> team2 = new ArrayList<>();
        String line2;
        while ((line2 = br2.readLine())!= null){
            String str2 = line2.replaceAll(",", " ");
            
            String[] teamStrings2 = str2.trim().split("\\s+");
            for (int i = 0; i < teamStrings2.length; i++){
                team2.add(teamStrings2[i]);
            } 
            
        }
        
        ArrayList<AFLPlayer> away_team = new ArrayList<>();
        String firstNC2 = team2.get(2);
        String lastNC2 = team2.get(3);
        String posNC2 = team2.get(4);
        AFLTeamMember awayCoach = new AFLTeamMember(firstNC2, lastNC2, posNC2);
        awayTname = team2.get(0) + " " +team2.get(1);
        
        while (team2.contains("c")){
            int c_index = team2.indexOf("c");
            Boolean isCaptain = true;
            int pN = Integer.valueOf(team2.get(c_index-4)).intValue();
            String fString = team2.get(c_index-3);
            String lString = team2.get(c_index-2);
            String pString = team2.get(c_index-1);
            AFLPlayer awayPlayerC = new AFLPlayer(fString, lString, pString, pN, isCaptain);
            team2.remove(c_index-4);
            team2.remove(c_index-4);
            team2.remove(c_index-4);
            team2.remove(c_index-4);
            team2.remove(c_index-4);     
            away_team.add(awayPlayerC);
            break;          
        }
            
        team2.remove(0);
        team2.remove(0);
        team2.remove(0);
        team2.remove(0);
        team2.remove(0);
            
        while (team2.size() != 0){
            int PlayerNumber2 = Integer.valueOf(team2.get(0)).intValue();
            String firstNp2 = team2.get(1);
            String lastNp2 = team2.get(2);
            String posNp2 = team2.get(3); 
            Boolean isCaptain = false;
            AFLPlayer awayPlayer = new AFLPlayer(firstNp2, lastNp2, posNp2, PlayerNumber2, isCaptain);
            away_team.add(awayPlayer);
            
            team2.remove(0);
            team2.remove(0);
            team2.remove(0);
            team2.remove(0);
        }
    
        br2.close();
        file2.close();    
        
        result2 = "Away team is " + awayTname;
        return result + ", " + result2 + " .";
    }
    
}
  

