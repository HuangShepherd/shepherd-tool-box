package Compare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import FileSize.FileSize;

public class FEWS_Compare {

	
	public static void main(String[] args) throws IOException{
		String path = "E:\\work\\Spatial_Interpolation_Historical\\1\\";
		File ff = new File(path);
		ArrayList<String> fileList = new ArrayList<String>();
		String [] DataName =ff.list();
		  for(int i=0;i<DataName.length;i++){
			  fileList.add(DataName[i]);
			  
		  }		
	
			BufferedWriter data = new BufferedWriter(new FileWriter("E:\\work\\data\\data.txt"));
		 for(int i=1;i<DataName.length;i++){

		BufferedReader config =new BufferedReader(new FileReader(path+DataName[i-1]));
		BufferedReader config2 =new BufferedReader(new FileReader(path+DataName[i]));
	
		String line1,line2;
		int a=0;
		while((line1=config.readLine())!=null && (line2=config2.readLine())!=null){
			a=line1.compareTo(line2);
			
			if(a!=0){
				System.out.println(line2);
				data.write(line2);
				data.write("\r\n");
				a=1;
				
			}
		
		}
		config.close();
		config2.close();
		 }
			data.close();

		
	}

	public long getlist(File f){//遞迴求取目錄檔個數
		long size = 0;
		File flist[] = f.listFiles();
		size=flist.length;
		
		for (int i = 0; i < flist.length; i++) {//夾層
		if (flist[i].isDirectory()) {
		size = size + getlist(flist[i]);
		size--;
		}
		}
		return size;

		}
	
	
	
	
}
