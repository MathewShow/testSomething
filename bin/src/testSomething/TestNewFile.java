package testSomething;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	测试createNewFile
 * @author hy513
 *
 */
public class TestNewFile {
	
	public static void main(String[] args) {
		newFile1() ;
		
	}
	
	public static void newFile1() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); //设置日期格式
        String time = df.format(new Date()); // new Date()为获取当前系统时间
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
    		System.out.println("图片保存成功");
		} catch (Exception e) {
			System.out.println("图片保存失败");
			e.printStackTrace();
		}
    	
	}
	
	public static void newFile2() {
		try {
			File file = new File("D:"+File.separator+"123.jpg");
			if(!file.exists()) {
				file.createNewFile();
			}
			//创建字节缓冲输入流
			FileInputStream fis = 
					new FileInputStream("22.jpg");
			//创建字节缓冲输出流对象 - 写数据
			FileOutputStream fos = 
					new FileOutputStream(file);
			byte[] bytes = new byte[1025];
			int len = -1;
			while((len = fis.read(bytes))!=-1) {
				fos.write(bytes, 0, len);
			}
			fos.close();
			fis.close();
			System.out.println("图片保存成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
