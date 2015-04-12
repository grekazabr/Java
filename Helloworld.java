import java.io.File;

public class Helloworld {
	public static void main(String[] args){
		File myFolder = new File("C:/Program Files");
		File[] files = myFolder.listFiles();
		for(int i = 0; i < files.length; i++)
		{
			System.out.println(files[i]);	
		}
	}
}