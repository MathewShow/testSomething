package testSomething;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	����createNewFile
 * @author hy513
 *
 */
public class TestNewFile {
	
	public static void main(String[] args) {
		newFile1() ;
		
	}
	
	public static void newFile1() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); //�������ڸ�ʽ
        String time = df.format(new Date()); // new Date()Ϊ��ȡ��ǰϵͳʱ��
        System.out.println("D:" + File.separator + "Pic" + File.separator + time + "small.jpg");
		File facePic = new File("D:" + File.separator + "Pic" + File.separator + time + "small.jpg");
    	File backPic = new File("D:" + File.separator + "Pic" + File.separator + time + "big.jpg");
    	try {
    		if(!facePic.exists()) {
        		facePic.createNewFile();
        	}
    		if(!backPic.exists()) {
    			backPic.createNewFile();
    		}
    		System.out.println("ͼƬ����ɹ�");
		} catch (Exception e) {
			System.out.println("ͼƬ����ʧ��");
			e.printStackTrace();
		}
    	
	}
	
	public static void newFile2() {
		try {
			File file = new File("D:"+File.separator+"123.jpg");
			if(!file.exists()) {
				file.createNewFile();
			}
			//�����ֽڻ���������
			FileInputStream fis = 
					new FileInputStream("22.jpg");
			//�����ֽڻ������������ - д����
			FileOutputStream fos = 
					new FileOutputStream(file);
			byte[] bytes = new byte[1025];
			int len = -1;
			while((len = fis.read(bytes))!=-1) {
				fos.write(bytes, 0, len);
			}
			fos.close();
			fis.close();
			System.out.println("ͼƬ����ɹ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
