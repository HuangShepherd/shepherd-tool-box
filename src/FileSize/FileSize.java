package FileSize;

import java.io.File;
import java.text.DecimalFormat;
import java.io.FileInputStream;
public class FileSize
{
public long getFileSizes(File f) throws Exception{//���o�ɮפj�p
long s=0;
if (f.exists()) {
FileInputStream fis = null;
fis = new FileInputStream(f);
s= fis.available();
} else {
f.createNewFile();
System.out.println("�ɤ��s�b");
}
return s;
}
// ���j
public long getFileSize(File f)throws Exception//���o��Ƨ��j�p
{
long size = 0;
File flist[] = f.listFiles();
for (int i = 0; i < flist.length; i++)
{
if (flist[i].isDirectory())
{
size = size + getFileSize(flist[i]);
} else
{
size = size + flist[i].length();
}
}
return size;
}

public String FormetFileSize(long fileS) {//�ഫ�ɮפj�p
DecimalFormat df = new DecimalFormat("#.00");
String fileSizeString = "";
if (fileS < 1024) {
fileSizeString = df.format((double) fileS) + "B";
} else if (fileS < 1048576) {
fileSizeString = df.format((double) fileS / 1024) + "K";
} else if (fileS < 1073741824) {
fileSizeString = df.format((double) fileS / 1048576) + "M";
} else {
fileSizeString = df.format((double) fileS / 1073741824) + "G";
}
return fileSizeString;
}

public long getlist(File f){//���j�D���ؿ��ɭӼ�
long size = 0;
File flist[] = f.listFiles();
size=flist.length;
for (int i = 0; i < flist.length; i++) {
if (flist[i].isDirectory()) {
size = size + getlist(flist[i]);
size--;
}
}
return size;

}

public static void main(String args[])
{
	FileSize g = new FileSize();
long startTime = System.currentTimeMillis();
try
{
long l = 0;
String path = "E:\\test";
File ff = new File(path);
if (ff.isDirectory()) { //�p�G���|�O��Ƨ����ɭ�
System.out.println("�ɭӼ� " + g.getlist(ff));
System.out.println("�ؿ�");
l = g.getFileSize(ff);
System.out.println(path + "�ؿ����j�p���G" + g.FormetFileSize(l));
} else {
System.out.println(" �ɭӼ� 1");
System.out.println("��");
l = g.getFileSizes(ff);
System.out.println(path + "�ɪ��j�p���G" + g.FormetFileSize(l));
}

} catch (Exception e)
{
e.printStackTrace();
}
long endTime = System.currentTimeMillis();
System.out.println("�`�@��O�ɶ����G" + (endTime - startTime) + "�@��...");
}
}