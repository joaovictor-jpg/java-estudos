Buffepackage application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.next();
		
		File path = new File(strPath);
		
		System.out.println("getPath: " + path.getPath());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getName: " + path.getName());
		
		sc.close();
	}

	private static void foldersworking(String strPath) {
		File path = new File(strPath);
		
		File[] folders =  path.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files:");
		for (File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(strPath + "\\newFolder").mkdir();
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}
	}

	private static void writefile() {
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good nigth"};
		String path = "C:\\\\Users\\\\joao\\\\Desktop\\\\Write.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void try_with_resources() {
		String path = "C:\\Users\\joao\\Desktop\\in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void filesreader_bufferedreader() {
		String path = "C:\\Users\\joao\\Desktop\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	private static void filereader() {
		File file = new File("C:\\Users\\joao\\Desktop\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}

