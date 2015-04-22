package Copy_Move;

import java.io.File;
import java.util.ArrayList;

import Compare.FEWS_Compare;

public class Copy {

	public static void main(String[] args) {
		
	
		String path = "E:\\test";
		File ff = new File(path);
		ArrayList<String> fileList = new ArrayList<String>();
		String [] DataName =ff.list();
		  for(int i=0;i<DataName.length;i++){
			  fileList.add(DataName[i]);
			  
		  }		
		
		 File source = new File("E:/a.mp3");
		    File dest = new File("E:/a.mp3");
		    source.renameTo(dest);
	}

}
