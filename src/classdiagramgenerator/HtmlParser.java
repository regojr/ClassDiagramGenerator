/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classdiagramgenerator;

import org.jsoup.Jsoup;
import java.io.*;
import javax.swing.*;
import javax.swing.text.html.HTML;


@SuppressWarnings("unused")
public class HtmlParser {
        
        File[] files;
    
	public HtmlParser(){
            
        }
	
        public HtmlParser(File[] theFiles){
            files = theFiles;            
        }
        
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}
	
	public static void main(String args[]) throws IOException{
		
		// Open the file
		FileInputStream fin = new FileInputStream("Card.html");

		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fin);
		
		FileOutputStream fout = new FileOutputStream("htmltext.txt");
		DataOutputStream out = new DataOutputStream(fout);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

		String strLine;
		String result = "Hello World";
		bw.write(result);

		//Read File Line By Line
		while (((in.available()) != 0))   {
		  strLine = in.readLine();
		  result = html2text(strLine);
		  out.writeChars(result);
		  out.writeChars("\n");
		}	

		//Close the input stream
		in.close();
		out.close();
	}
}