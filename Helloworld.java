
import java.io.File;
import java.util.Scanner;

public class Helloworld {

    public static void main(String[] args) {        
        Scanner in = new Scanner(System. in);
        String path="",menu = "2";
        boolean exitFromProgramCase=false;
        int os = 0, lengthOfFiles = 0, numOfFiles = 0, numberOfIterationOfProgram = 0;
        //allows repeats of programm work
        for(;menu!="1";){
            exitFromProgramCase = false;
            path = "";
            os = 0;
            lengthOfFiles = 0;
            numOfFiles = 0;
            //selector of main menu is there
            menu = mainMenuBlock(numberOfIterationOfProgram,menu,in);
            //shows files in chosen directory
            showingFilesInTheDirectory(menu, 
                                        in,
                                        lengthOfFiles,
                                        path,
                                        exitFromProgramCase,
                                        os);
            numberOfIterationOfProgram++;
        }	
    }    
    public static String mainMenuBlock(int numberOfIterationOfProgram,String menu,Scanner in){
        if(numberOfIterationOfProgram>0)
            {
                    System.out.println("1-exit, 2-continue");
                    menu = in.nextLine();
            }
            else{
                    System.out.println("This progam will allow you to list content of directory that you can choose");
            }
        return menu;
    }
    public static String operatingSystemMenuBlock(boolean exitFromProgramCase,int os, String path){
        for(;exitFromProgramCase==false;){
            switch (os){
                case 1:
                    System.out.println("You have chosed 1-Windows");
                    exitFromProgramCase = true;
                    break;
                case 2:
                    System.out.println("You have chosed 2-Linux");
                    exitFromProgramCase = true;
                    path = "/";
                    break;
                default:
                    System.out.println("!!!I don't know such OS, try again");
            }
        }
        return path;
    }
    public static void displayingOfContentOfDirectory(int amountofpages,
                                                        Scanner in,
                                                        String punktMenuOfLists,
                                                        int currentDecadeOfFiles,
                                                        int numberOfFilesPerPage,
                                                        int lengthOfFiles,
                                                        int quantityOfList,
                                                        boolean exitFromWhile,
                                                        File[] files){
        do{
            System.out.println("next page \"n\", previous page \"b\", \"e\" to exit \n"
                    + "or you can choose page. enter pagenumber to go on direct page (the number of pages allowed = "
                    + amountofpages);
            punktMenuOfLists = in.nextLine();
            int nextDecade = currentDecadeOfFiles+numberOfFilesPerPage,
                    previousDecade = currentDecadeOfFiles-numberOfFilesPerPage,
                    amountOfDecades = ((lengthOfFiles/numberOfFilesPerPage)*numberOfFilesPerPage),
                    amountOfFilesOnPage = (lengthOfFiles%numberOfFilesPerPage);
            //menu for changing pages of files that are viewed
            switch(punktMenuOfLists)
            {
                //exit from that block (to go in the main menu)
                case "e":
                    exitFromWhile = true;
                    break;
                    //display a page that is situated before current one
                case "b":
                    if(previousDecade>=0){
                        currentDecadeOfFiles-=numberOfFilesPerPage;
                        quantityOfList=numberOfFilesPerPage;                                                                            
                    }else{
                        currentDecadeOfFiles=amountOfDecades;
                        quantityOfList = amountOfFilesOnPage;
                        if(quantityOfList==0){
                            quantityOfList=numberOfFilesPerPage;
                            currentDecadeOfFiles=amountOfDecades-numberOfFilesPerPage;                                                                                
                        }
                    }
                    for(int i = 0; i < quantityOfList; i++){
                                System.out.println(files[currentDecadeOfFiles+i]);
                        }
                    break;
                    //display a page that is situated after current one
                case "n":                                                                                                                                        
                    if(nextDecade==amountOfDecades){
                            currentDecadeOfFiles+=numberOfFilesPerPage;
                            quantityOfList = amountOfFilesOnPage;
                            if(quantityOfList==0){
                                quantityOfList=numberOfFilesPerPage;
                                currentDecadeOfFiles=0;
                            }
                            for(int i = 0; i < quantityOfList; i++){
                                System.out.println(files[currentDecadeOfFiles+i]);
                            }
                    }  
                    if(nextDecade<amountOfDecades){
                        currentDecadeOfFiles+=numberOfFilesPerPage;
                        quantityOfList=numberOfFilesPerPage;
                        for(int i = 0; i < quantityOfList; i++){
                                System.out.println(files[currentDecadeOfFiles+i]);
                        }
                    }
                    if((nextDecade>amountOfDecades)){
                        currentDecadeOfFiles=0;
                        quantityOfList=numberOfFilesPerPage;
                        for(int i = 0; i < quantityOfList; i++){
                            System.out.println(files[currentDecadeOfFiles+i]);
                        }
                    }
                    break;
                    //the block that chooses between incorrect input and number of page that you want to display
                default:
                    int numberofpageinmenu = 0;
                    try{
                        numberofpageinmenu = Integer.parseInt(punktMenuOfLists);
                        if((numberofpageinmenu<amountofpages)&&(numberofpageinmenu>0)){
                           quantityOfList = numberOfFilesPerPage;
                           currentDecadeOfFiles = (numberofpageinmenu-1)*numberOfFilesPerPage;
                           for(int i = 0; i < quantityOfList; i++){
                                System.out.println(files[currentDecadeOfFiles+i]);
                            }
                        }
                        if((numberofpageinmenu==amountofpages)&&(numberofpageinmenu>0)){
                            quantityOfList = amountOfFilesOnPage;
                            currentDecadeOfFiles = (numberofpageinmenu-1)*numberOfFilesPerPage;
                            for(int i = 0; i < quantityOfList; i++){
                                System.out.println(files[currentDecadeOfFiles+i]);
                            }
                        }
                        if(!((numberofpageinmenu<=amountofpages)&&(numberofpageinmenu>0))){
                            System.out.println("!!!that number of page is not available, try more");
                        }
                    }
                    catch(NumberFormatException e){
                         System.out.println("!!!this case is not available, try more");
                    }                                                            
                    break;
            }
        }while(!exitFromWhile);
    }
    public static void showingFilesInTheDirectory(String menu, 
                                                        Scanner in,
                                                        int lengthOfFiles,
                                                        String path,
                                                        boolean exitFromProgramCase,
                                                        int os){
        switch(menu){
                case "1":{
                    System.exit(0);
                }
                case "2":{
                    menu = "";
                    System.out.println("Choose your operating system (1-Windows, 2-Linux:");
                    os = in.nextInt();
                    System.out.println("Write a way to your folder");
                    in.nextLine();
                    //selector of os menu (choosing needed os)
                    path = operatingSystemMenuBlock(exitFromProgramCase, os, path);
                    path = path + in.nextLine();
                    File myFolder = new File(path);
                    File[] files = myFolder.listFiles();
                    lengthOfFiles = files.length;					
                    {
                        int currentDecadeOfFiles = 0, quantityOfList=10;
                        boolean exitFromWhile = false;
                        String punktMenuOfLists = "";
                        for(int i = 0; i < quantityOfList; i++){
                                        System.out.println(files[i]);
                        }
                        int numberOfFilesPerPage=10,
                                amountOfPages = 0;
                        //defines if the number of files is even ot not
                        if((lengthOfFiles%numberOfFilesPerPage)==0){
                            amountOfPages = lengthOfFiles/numberOfFilesPerPage;
                        }else{
                            amountOfPages = lengthOfFiles/numberOfFilesPerPage + 1;
                        }
                        //this function allows displaying files in the chosen directory in pages and allows switching between them
                        displayingOfContentOfDirectory(amountOfPages, 
                                in, 
                                punktMenuOfLists, 
                                currentDecadeOfFiles,
                                numberOfFilesPerPage,
                                lengthOfFiles,
                                quantityOfList,
                                exitFromWhile,
                                files);
                    }
                    break;
                }
                default:{
                    System.out.println("!!!incorrect case, try again");
                    break;
                }
            }
    }
}
