package Compare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FEWS_Compare {

	
	public static void main() throws IOException{
		
		BufferedReader config =new BufferedReader(new FileReader("E:\test\\C1290_Ensemble_Rainfall_Transformation 1.00 default.xml"));
		BufferedReader config2 =new BufferedReader(new FileReader("E:\test\\C1300_Ensemble_Rainfall_Transformation 1.00 default.xml"));
		String line1,line2;
		int a=0;
		while((line1=config.readLine())!=null && (line2=config2.readLine())!=null){
			a=line1.compareTo(line2);
			
			if(a==0){
				System.out.println(line1);
				a=1;
			}
		}
		
		
		
	}
}
