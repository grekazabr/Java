
import java.io.File;
import java.util.Scanner;

public class Helloworld {

    public static void main(String[] args) {        
        Scanner in = new Scanner(System. in);
        String path="",menu = "2";
        boolean exitfromprogramcase=false;
        int os = 0, lengthoffiles = 0, numoffiles = 0, numberofiterationofprogram = 0;
        for(;menu!="1";){
            exitfromprogramcase = false;
            path = "";
            os = 0;
            lengthoffiles = 0;
            numoffiles = 0;
            if(numberofiterationofprogram>0)
            {
                    System.out.println("1-exit, 2-continue");
                    menu = in.nextLine();
            }
            else{
                    System.out.println("This progam will allow you to list content of directory that you can choose");
            }
            switch(menu){
                case "1":{
                    System.exit(0);
                }
                case "2":{
                    menu = "";
                    System.out.println("Choose your operating system (1-Windows, 2-Linux:");
                    os = in.nextInt();
                    for(;exitfromprogramcase==false;){
                            switch (os){
                                    case 1:
                                            System.out.println("You have chosed 1-Windows");
                                            exitfromprogramcase = true;
                                            break;
                                    case 2:
                                            System.out.println("You have chosed 2-Linux");
                                            exitfromprogramcase = true;
                                            path = "/";
                                            break;
                                    default:
                                            System.out.println("I don't know such OS, try again");
                            }
                    }
                    System.out.println("Write a way to your folder");
                    in.nextLine();
                    path = path + in.nextLine();
                    File myFolder = new File(path);
                    File[] files = myFolder.listFiles();
                    lengthoffiles = files.length;					
                    {
                        int currentdecadeoffiles = 0, quantityoflist=10;
                        boolean exitfromwhile = false;
                        String punktmenuoflists = "";
                        for(int i = 0; i < quantityoflist; i++){
                                        System.out.println(files[i]);
                                }
                        int numberoffilesperpage=10,
                                amountofpages = 0;
                        if((lengthoffiles%numberoffilesperpage)==0){
                            amountofpages = lengthoffiles/numberoffilesperpage;
                        }else{
                            amountofpages = lengthoffiles/numberoffilesperpage + 1;
                        }
                        do{
                            System.out.println("next page \"n\", previous page \"b\", \"e\" to exit \n"
                                    + "or you can choose page. enter pagenumber to go on direct page (the number of pages allowed = "
                                    + amountofpages);
                            punktmenuoflists = in.nextLine();
                            int nextdecade = currentdecadeoffiles+numberoffilesperpage,
                                    previousdecade = currentdecadeoffiles-numberoffilesperpage,
                                    amountofdecades = ((lengthoffiles/numberoffilesperpage)*numberoffilesperpage),
                                    amountoffilesonpage = (lengthoffiles%numberoffilesperpage);
                            switch(punktmenuoflists)
                            {
                                case "e":
                                    exitfromwhile = true;
                                    break;
                                case "b":
                                    if(previousdecade>=0){
                                        currentdecadeoffiles-=numberoffilesperpage;
                                        quantityoflist=numberoffilesperpage;                                                                            
                                    }else{
                                        currentdecadeoffiles=amountofdecades;
                                        quantityoflist = amountoffilesonpage;
                                        if(quantityoflist==0){
                                            quantityoflist=numberoffilesperpage;
                                            currentdecadeoffiles=amountofdecades-numberoffilesperpage;                                                                                
                                        }
                                    }
                                    for(int i = 0; i < quantityoflist; i++){
                                                System.out.println(files[currentdecadeoffiles+i]);
                                        }
                                    break;
                                case "n":                                                                                                                                        
                                    if(nextdecade==amountofdecades){
                                            currentdecadeoffiles+=numberoffilesperpage;
                                            quantityoflist = amountoffilesonpage;
                                            if(quantityoflist==0){
                                                quantityoflist=numberoffilesperpage;
                                                currentdecadeoffiles=0;
                                            }
                                            for(int i = 0; i < quantityoflist; i++){
                                                System.out.println(files[currentdecadeoffiles+i]);
                                            }
                                    }  
                                    if(nextdecade<amountofdecades){
                                        currentdecadeoffiles+=numberoffilesperpage;
                                        quantityoflist=numberoffilesperpage;
                                        for(int i = 0; i < quantityoflist; i++){
                                                System.out.println(files[currentdecadeoffiles+i]);
                                        }
                                    }
                                    if((nextdecade>amountofdecades)){
                                        currentdecadeoffiles=0;
                                        quantityoflist=numberoffilesperpage;
                                        for(int i = 0; i < quantityoflist; i++){
                                            System.out.println(files[currentdecadeoffiles+i]);
                                        }
                                    }
                                    break;
                                default:
                                    int numberofpageinmenu = 0;
                                    try{
                                        numberofpageinmenu = Integer.parseInt(punktmenuoflists);
                                        if((numberofpageinmenu<=amountofpages)&&(numberofpageinmenu>0)){
                                           quantityoflist = numberoffilesperpage;
                                           currentdecadeoffiles = (numberofpageinmenu-1)*numberoffilesperpage;
                                           for(int i = 0; i < quantityoflist; i++){
                                                System.out.println(files[currentdecadeoffiles+i]);
                                            }
                                        }else{
                                            System.out.println("the number of page is not avable");
                                        }
                                    }
                                    catch(Exception e){
                                        System.out.println("try more");
                                    }                         
                                    break;
                            }
                        }while(!exitfromwhile);
                    }
                    break;
                }
                default:{
                    System.out.println("incorrect case, try again");
                    break;
                }
            }
            numberofiterationofprogram++;
        }	
    }
    
}
