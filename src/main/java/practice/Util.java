package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	public static final String VOICE_EXT = ".mp3";
	public static final String IMG_EXT = ".png";

	private Util() {
	}

	public static String makeBasicDirPath(String... paths) {
		String resultPath = "";
		for (String path : paths) {
			resultPath += path + File.separator;
		}

		return resultPath;
	}

	public static XSSFWorkbook loadExcel(String excelPath) {
		XSSFWorkbook wb = null;

		try {
			wb = new XSSFWorkbook(new FileInputStream(excelPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wb;
	}

	public static String getFileName(File file) {
		return file	.getName()
					.substring(0, file	.getName()
										.indexOf('.'))
					.trim();
	}

	public static void fileWrite(String source, File dest) {
		try {
			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(dest, true));

			// 파일안에 문자열 쓰기
			fw.write(source);
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fileCopy(File source, File dest) {
		try {
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			int data = 0;
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			bis.close();
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
