import java.io.File;
import java.util.Scanner;
public class Helloworld {
	public static void main(String[] args){
		Scanner in = new Scanner(System. in);
		String path = in.nextLine();
		File myFolder = new File(path);
		File[] files = myFolder.listFiles();
		for(int i = 0; i < files.length; i++)
		{
			System.out.println(files[i]);	
		}
	}
}