/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kereso;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author BenZe
 */
public class keres {
    public static void main(String[] args) {

        String file_name = "E:/places.bqf";
        String searchThis = "";
        try {

            Kereso file = new Kereso(file_name);
            String[][] Places = file.readUp();
            
            while(!searchThis.equals("stop")){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Keres: ");
            searchThis = br.readLine();
            System.out.println("TALÁLATOK: ");
            String ez = file.Keres(Places, searchThis);
            System.out.println(ez);
            }
    }
        catch (Exception exc){
            System.out.println("Hiba: " + exc);
        }              
    }
}
