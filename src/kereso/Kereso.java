package kereso;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BenZe
 */
public class Kereso {
    
    private final String path;
    private int tombLength;
    
    private String Company;
    private String Building;
    private String Zone;
    private String Information;
    
    public Kereso(String filePath) throws Exception{
        this.path = filePath;
        Lines();      
    }   
    
    public final void Lines() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        int count = 0;
        while (br.readLine() != null)  count++;        
        br.close();
        tombLength = count;
    }
    
    public String[][] readUp() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        //Lines();
        int linesNum = tombLength;
        String[][] Datas = new String[linesNum][4];
        for(int i = 0; i < linesNum; i++){
            String[] sor = br.readLine().split("\\|");
            Datas[i][0] = sor[0];
            Datas[i][1] = sor[1];
            Datas[i][2] = sor[2];
            Datas[i][3] = sor[3];    
        }
        br.close();
        return Datas;
    }
    
    public boolean searchTheOne(String searchThis) throws IOException{ 
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        for(int i = 0; i < tombLength; i++){
            String[] sor = br.readLine().split("\\|");
            if(sor[0].toLowerCase().equals(searchThis.toLowerCase())){
                this.Company  = sor[0];
                this.Building = sor[1];
                this.Zone = sor[2];
                this.Information = sor[3];
                return true;     
            }
        }
        br.close();
        return false;
    }  
    
    public String getCompany(){
        return this.Company;
    }
    public String getBuilding(){
        return Building;
    }    
    public String getZone(){
        return Zone;
    }   
    public String getInformation(){
        return Information;
    }  
    
     public List<String> searchOthers(String searchThis) throws IOException{         
        List<String> matches = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        for(int i = 0; i < tombLength; i++){
            String[] sor = br.readLine().split("\\|");
            if(sor[0].toLowerCase().contains(searchThis.toLowerCase())){
                matches.add(sor[0]);
            } 
        }
        br.close();
        return matches;
    }    
    
    
    //TODO: Javítani - Erre átszabni
    public Map<Integer, List<String>> loadPlaces() throws IOException {
        Map<Integer, List<String>> places = new HashMap<>();
        List<String> datas = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        Lines();
        for (int i = 0; i < tombLength; i++){
            String[] sor = br.readLine().split("\\|");
            datas.add(sor[0]);
            datas.add(sor[1]);
            datas.add(sor[2]);
            datas.add(sor[3]);
            places.put(i, datas); 
            datas.clear();
        }
        br.close();       
        return places;
    }
    
    
    public String Keres(String[][] places, String searchThis){
        String Matched = "";
        for(int i = 0; i < tombLength; i++) {
            if(places[i][0].toLowerCase().equals(searchThis.toLowerCase())){
                return "> " + places[i][0] + "\n- Épület: " + places[i][1] + "\n- Zóna: " + places[i][2] + 
                     "\nEgyéb információ: \n" + places[i][3] + "\n";
            }
            else if(places[i][0].toLowerCase().contains(searchThis.toLowerCase())){
                Matched += "> " + places[i][0] + "\n";
            }
        }
        return (!Matched.equals(""))? Matched : "Nincs találat";
    }      

    
    
}
