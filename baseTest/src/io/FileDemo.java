package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileDemo {
	
	//默认盘符 要用反斜杠 /
	private static String path = "D:/";
	
	//路径名
	private static String filenameTemp;

	/*
	 * java.iO.File类表示文件或目录 File类只用于表示文件或目录的信息（名称，大小等），不能用于文件内容的访问。
	 */
	public static void main(String[] args) throws IOException  {
		File file = new File("D:\\111");// 创建文件对象时指定目录需要用双斜杠，因为“\”是转义字符
		/* 目录的中间的分隔符可以用双斜杠，也可以用反斜杠，也可以用File.separator设置分隔符 */
		// File file1=new File("d:"+File.separator);
		// System.out.println(file.exists());//exists()判断文件或文件夹是否存在
		if (!file.exists()) {// 如果文件不存在
			file.mkdir();// 创建文件夹mkdir()，还有mkdirs()创建多级目录
		} else {
			file.delete();// 删除文件或文件夹
		}
		// 判断是否是一个目录isDirectory,如果是目录返回true，如果不是目录或者目录不存在返回false
		System.out.println(file.isDirectory());
		// 判断是否是一个文件isFile
		System.out.println(file.isFile());
		
		boolean creatTxt= creatTxtFile("fileTest");
		
		if(creatTxt) {
			System.out.println("creatTxt  success");
		}else {
			
			System.out.println("Txt  was exist");
			System.out.println("Txt is going to write something");
			writeTxtFile("啦啦啦啦德玛西亚");
		}

//		File file2 = new File("D:\\222", "123.txt");
//		if (!file.exists()) {// 如果文件不存在
//			file.mkdir();// 创建文件夹mkdir()，还有mkdirs()创建多级目录
//		} else {
//			file.delete();// 删除文件或文件夹
//		}
		// 常用API：
		System.out.println(file);// 打印的是file.toString()的内容
		System.out.println(file.getAbsolutePath());// 获取绝对路径
		System.out.println(file.getName());// 获取文件名称
		//System.out.println(file2.getName());
		System.out.println(file.getParent());// 获取父级绝对路径
		//System.out.println(file2.getParentFile().getAbsolutePath());

	}

	/**
	 * 
	 * @throws IOException
	 */
	public static boolean creatTxtFile(String name) throws IOException {
		boolean flag = false;
		//创建 路径+ 文件名+文件格式
		//例如: D:/1111.txt
		filenameTemp = path + name + ".txt";
		//创建新文件
		File filename = new File(filenameTemp);
		
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * 写文件
	 * 
	 * @param newStr
	 *            新内容
	 * @throws IOException
	 */
	public static boolean writeTxtFile(String newStr) throws IOException {
		// 先读取原有文件内容，然后进行写入操作
		boolean flag = false;
		String filein = newStr + "\r\n";
		String temp = "";
		
		//输入流   把文件转成流形式
		FileInputStream fis = null;
		//输出流
		FileOutputStream fos = null;
		
		//BufferedReader 是缓冲字符输入流。它继承于Reader。
		//BufferedReader 的作用是为其他字符输入流添加一些缓冲功能。
		//分批读取数据，每次读取一部分到缓冲中；操作完缓冲中的这部分数据之后，再从Reader中读取下一部分的数据。
		BufferedReader br = null;
		
		// 处理字符流的抽象类
		//InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
		//OutputStreamWriter是字符流通向字节流的桥梁，它将字符流转换为字节流.
		InputStreamReader isr = null;
		//向文本输出流打印对象的格式化表示形式。
		PrintWriter pw = null;
		try {
			// 文件路径
			File file = new File(filenameTemp);
			// 将文件读入输入流/读取文件的数据
			fis = new FileInputStream(file);
			 //将字节流向字符流的转换。要启用从字节到字符的有效转换，
	        //可以提前从底层流读取更多的字节.
			isr = new InputStreamReader(fis);
			//创建字符流缓冲区
			br = new BufferedReader(isr);
			
			//重新拼接内容
			StringBuffer buf = new StringBuffer();
			// 保存该文件原有的内容
			for (int j = 1; (temp = br.readLine()) != null; j++) {
				buf = buf.append(temp);
				// System.getProperty("line.separator")
				// 行与行之间的分隔符 相当于“\n”
				buf = buf.append(System.getProperty("line.separator"));
			}
			buf.append(filein);
			
			//创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
			fos = new FileOutputStream(file);
			//向文件输入新的内容
			pw = new PrintWriter(fos);
			pw.write(buf.toString().toCharArray());
			//刷新该流的缓冲/刷新文件内容信息
			pw.flush();
			flag = true;
		} catch (IOException e1) {
			// TODO 自动生成 catch 块
			throw e1;
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return flag;
	}

}
