
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DownloadImages {

	static String folderpath = null;
	static String foldername = null;
	static String path = null;
	static String CPPUtilitypath = null;
	public static void main(String[] args) {
	
		String s = args[0];
		String src = null;
		Document doc = null;
		try {
			
			// Use Jsoup HTML parser to parse HTML pages and return all elements with <img> tag
			doc = Jsoup.connect(s).get();
			Elements images = doc.getElementsByTag("img");
			
			// Get the title of the webpage
			String title = doc.title();
			
			//Print the title of the webpage
			System.out.println(title);
			
			// If there are no images on the webpage
			if(images.isEmpty())
			{
				System.out.println("No Images found on this page!");
				System.exit(1);
			}
			
			// Get PWD
			path = System.getProperty("user.dir");
			//System.out.println(path);
			// Get Unique name for folder and that can be achieved by adding "timestamp" to the folder
			SimpleDateFormat sdf = new SimpleDateFormat("'Images'_yyyyMMMdd_hhmmss_SSS");
			foldername = sdf.format(new Date());
			
			// Create a directory to save images
			File dir = new File(foldername);
			if(!dir.exists())
			{
				if(dir.mkdir())
				{
					//System.out.println("Directory Created!");
				}
				else
				{
					System.out.println("Failed to Create Directory to save Images!");
					System.exit(1);
				}
			}
			else
			{
				//System.out.println("Directory Exists!");
			}
		
			
			//Append folder name with PWD to get absolute folder path
			folderpath = path+System.getProperty("file.separator")+foldername;
			
			
			// Compiling the given CPP program
			CPPUtilitypath = path+"/cpp_utility/cpp_utility/";
			String scriptpath = CPPUtilitypath+"compile1.sh";
			compileCPPScript(scriptpath);
			
			
			// Image path for every image
			String imagepath = null;
			String imagename = null;
			int indexofdot;
			String name = null;
			// Loop over all images to save them in a folder
			// and also run them through CPP and Python Utility!
			for(Element img : images)
			{
				src = img.absUrl("src");
				indexofdot = src.lastIndexOf(".");
				name = src.substring(indexofdot+1);
				
				if(name.equalsIgnoreCase("jpg") || name.equalsIgnoreCase("jpeg") || name.equalsIgnoreCase("jpe"))
				{
					System.out.print("\n"+src);
					imagename = saveImage(src);
					imagepath = folderpath+System.getProperty("file.separator")+imagename;
					
					//Running Python utility on image
					executePythonUtility(imagepath);
					
					// Running a CPP utility on image
					executeCPPUtility(imagepath);
				}
			}
			
		} catch (IOException e) {
			// Provide correct URL
			System.out.println("Falied to fetch the given URL!");
			e.printStackTrace();
		} 
		
	}
	
	private static void executeCPPUtility(String imagepath){
		try{
			String executeCommand = "./cpp_utility/cpp_utility/hist "+imagepath;
 			Process p = Runtime.getRuntime().exec(executeCommand);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			try{
				p.waitFor();
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			if(error.ready()){
				System.out.println("Following Error(s) occured while compiling the CPP Utility:\n\n");
				do{
					System.out.println(error.readLine());
				}while(error.ready());
				System.exit(1);
			}
			// No Errors!
			// Display the output!
			while(input.ready()){
				System.out.print(","+input.readLine());
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void compileCPPScript(String scriptpath)
	{
		try{
			Process p = Runtime.getRuntime().exec(scriptpath);
			//BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			try{
				p.waitFor();
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			if(error.ready()){
				System.out.println("Following Error(s) occured while running the CPP Utility:\n");
				do{
					System.out.println(error.readLine());
				}while(error.ready());
				System.exit(1);
			}
			else{
				//Okay No error File successfully compiled!
				//System.out.println("File successfully compiled!");
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static void executePythonUtility(String imagepath){
		try{
			String PythonUtilityPath = path+"/python_pil_example/dim.py";
			String executeCommand = "python"+" "+PythonUtilityPath+" "+imagepath;
 			Process p = Runtime.getRuntime().exec(executeCommand);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			try{
				p.waitFor();
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			if(error.ready()){
				System.out.println("Following Error(s) occured while running the Python file:\n");
				do{
					System.out.println(error.readLine());
				}while(error.ready());
				System.exit(1);
			}
			
			// No Errors!
			// Display the output!
			String dim = null;
			String delims = "[ (),]+";
			while(input.ready()){
				dim = input.readLine();
				String[] tokens = dim.split(delims);
				
				for(String s:tokens){
					if(!s.equals(""))
						System.out.print(","+s);
				}
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	private static String saveImage(String src) throws IOException {
		
		int indexname = src.lastIndexOf("/");
		int b;
		
		String name = src.substring(indexname+1);
		//System.out.println(name);
		
		// Open a connection to fetch the image
		URL url = new URL(src);
		InputStream in = url.openStream();
		OutputStream out = new BufferedOutputStream(new FileOutputStream(folderpath+System.getProperty("file.separator")+name));
		
		// Read from connection and write image to file
		while((b=in.read())!=-1){
			out.write(b);
		}
		
		// Close connection and file
		out.close();
		in.close();
		return name;
	}
	
}
