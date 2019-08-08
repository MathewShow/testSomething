package testSomething;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	
	public static void main(String[] args) throws IOException {
		//创建字节缓冲输入流
		FileInputStream fis = 
				new FileInputStream("22.jpg");
		BufferedInputStream bis = 
				new BufferedInputStream(fis);
		//创建字节缓冲输出流对象 - 写数据
		FileOutputStream fos = 
				new FileOutputStream("b.txt");
		BufferedOutputStream bos = 
				new BufferedOutputStream(fos);
		String str = "hello world";
		byte[] byteArr = str.getBytes();
		ByteArrayInputStream b = new ByteArrayInputStream(byteArr);
		//复制图片
		byte[] bys = new byte[1024];
		int len = -1;
		while((len=b.read(bys))!=-1){
			bos.write(bys, 0, len);
			bos.flush();
		}
		
		/*while((len=bis.read(bys))!=-1){
			bos.write(bys, 0, len);
			bos.flush();
		}*/
		
		bos.close();
		bis.close();
		b.close();
	}
}
