package kereso;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
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
    
    public String searchTheOne(String searchThis) throws IOException{ 
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        for(int i = 0; i < tombLength; i++){
            String[] sor = br.readLine().split("\\|");
            if(sor[0].toLowerCase().equals(searchThis.toLowerCase())){
                return "> " + sor[0] + "\n- Épület: " + sor[1] + "\n- Zóna: " + sor[2] + 
                     "\nEgyéb információ: \n" + sor[3] + "\n";       
            }
        }
        br.close();
        return "-";
    }  
    
     public String searchOthers(String searchThis) throws IOException{ 
        String Matched = "";
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        for(int i = 0; i < tombLength; i++){
            String[] sor = br.readLine().split("\\|");
            if(sor[0].toLowerCase().contains(searchThis.toLowerCase())){
                Matched += "> " + sor[0] + "\n";
            } 
        }
        br.close();
        return (!Matched.equals(""))? Matched : "-";
    }    
    
    
    //TODO: Javítani
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
    
    public void Beszur(String[][] Places, String newCompany, String newBuilding, String newZone, String newInfo){
        String ncFirstChar = String.valueOf(newCompany.toLowerCase().charAt(0));
        String thisWord;
        for(int i = 0; i < tombLength; i++){
            thisWord = Places[i][0].toLowerCase();
            if(String.valueOf(thisWord.charAt(0)).equals(ncFirstChar)){
                for(int y = 0; y < thisWord.length(); y++){
                    
                }
            }
        }
    }
    
    
}
