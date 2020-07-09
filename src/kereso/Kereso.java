package kereso;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * @author BenZe
 */
public class Kereso {
    
    private String path;
    private int fileLines;
    
    public Kereso(String filePath){
        this.path = filePath;
    }
    
    public int Lines() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        int count = 0;
        while (br.readLine() != null)  count++;        
        br.close();
        return count;
    }
    
    
    public String[] readUp() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr); 
        int linesNum = Lines();
        String[] Datas = new String[linesNum];
        for(int i = 0; i < linesNum; i++){
            Datas[i] = br.readLine();
        }       
        br.close();
        return Datas;
    }
    
}
