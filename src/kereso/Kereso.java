package kereso;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * @author BenZe
 */
public class Kereso {
    
    private String path;
    private int tombLength;
    
    public Kereso(String filePath){
        this.path = filePath;
    }
    
    public void Lines() throws IOException{
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
        Lines();
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
    
       public String[] olvass() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        int linesNum = tombLength;
        String[] Datas = new String[linesNum];
        for(int i = 0; i < linesNum; i++){
            Datas[i] = br.readLine();
        }
        br.close();
        return Datas;
    } 
    
    
    public void Keres(String[][] places, String searchThis){
        for(int i = 0; i < tombLength; i++) {
            if(places[i][0].toLowerCase().equals(searchThis.toLowerCase())){
                System.out.println("> " + places[i][0]);
                System.out.println("- Zóna: " + places[i][1]);
                System.out.println("- Épület: " + places[i][2]);
                System.out.println("Egyéb információ: \n" + places[i][3]);
            }
            else if(places[i][0].toLowerCase().contains(searchThis.toLowerCase())){
                System.out.println("> " + places[i][0]);
            }
        }
    }
      
    
    
    
}
