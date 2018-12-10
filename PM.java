import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.*;

class Point
{                                      //created structure
	int x=0;
	int y=0;
}

interface intfmat
{
	 Point allocate(char type);
	 boolean remove(Point locate);
	 void display();
	 char mat[][]=new char [32][32];
}

class matc implements intfmat
{
	 public char mat[][];
	 matc(){
	 mat=new char[32][32];
	 for(int j=0;j<32;j++)
	     for(int k=0;k<32;k++){
	       mat[j][k]=' ';
	 }

	 for(int j=0;j<32;j++)
		for(int k=0;k<32;k++){
			if(j==0||(j==31&&(k!=31&&k!=30&&k!=29)))
				mat[j][k]='-';
			if(k==0||k==31)
				mat[j][k]='|';
		}

	  for(int j=2;j<31;j+=4)
		 for(int k=1;k<29;k+=2){
		   mat[j][k]=' ';
		}

	  for(int j=1;j<31;j+=2)
		 for(int k=1;k<29;k+=1){
		 	mat[j][k]='-';
		}

    for(int j=2;j<31;j+=4)
		 for(int k=2;k<29;k+=2){
		mat[j][k]='|';}
	 }

	 public Point allocate(char type){                                         //allocating location
		int m=1;
		Point locate=new Point();
		locate.x=-1;
		locate.y=-1;
		for(int j=2;j<31;j+=4){
		 for(int k=1;k<29;k+=2){
		   if(mat[j][k]==' '&&m==1){
		       mat[j][k]=type;m=0;

		       locate.x=((j-2)/4)+1;
		       locate.y=((k-1)/2)+1;
		       return locate;
		       }
		 }
	}
		return locate;
}


	public boolean remove(Point locate)                                            //removing vehicle
	{
		if(mat[locate.x][locate.y]==' '){
			return false;
		}

		mat[locate.x][locate.y]=' ';
		return true;
	}

		public void display()
		{
		for(int j=0;j<32;j++){System.out.print("\t\t\t\t\t\t");
		 for(int k=0;k<32;k++){
			System.out.print(mat[j][k]+" ");
		}
			System.out.println("");
			}
	}
}


class PM{


  public static void main(String[] args)throws IOException, InterruptedException  {                           //main method


	  Point locate=new Point();
	  matc grid=new matc();
  //  File f1=new File("matrix.txt");

	Scanner scan=new Scanner(System.in);


	System.out.print("\033[H\033[2J");                                                                         //clear screen
  System.out.println("\n\n*****************************************************************************************************************************************************");
  System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tWelcome To Parking Management System\n\n\n\n\n\n");
  System.out.print("Made By:\t\t\t\t\t\t\t\t\t\t\t\t\t\tGuided By:\n");
  System.out.println("\n\t16BIT001 AAKASH VASWANI\t\t\t\t\t\t\t\t\t\t\t\t\tProf. Daiwat Vyas");
  System.out.println("\t16BIT012 ANISH JAIN\n\t16BIT015 PARTHESH SONI\n\t16BIT027 POOJAN KHATRI\n");
  System.out.println("*****************************************************************************************************************************************************");

	char k;
  System.out.print("\t\t\t\t\t\t\t");System.out.println("Press ENTER to continue");
	String line=null;
	System.out.print("\t\t\t\t\t\t\t");
	while ((line =scan.nextLine()).length() > 0)
 {
    }
//  System.out.print("\t\t\t\t\t\t");k=scan.next().charAt(0);
//  String dv=scan.nextLine();
	System.out.println("\033[H\033[2J\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tLoading the database information...");


	try{
	Thread.sleep(2000);
    }
    catch(InterruptedException e){
			System.out.println("Interruption Detected!");
		}



	BufferedReader br = null;
	try{
	 br=new BufferedReader(new InputStreamReader(new FileInputStream("Matrix.txt")));                                           //loading the previous matrix into progran
	for(int i=0; i<32; i++){
		for(int j=0;j<32; j++){
			grid.mat[i][j]=(char)br.read();
		}
	}
	if(br!=null)
	br.close();
	 }
	catch(IOException e)
	{
	System.out.println("\033[H\033[2J\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\tDatabase not present. A new empty file will be created.");
	File f1=new File("Matrix.txt");
	//f1.createNewFile();
	}


	System.out.print("\033[H\033[2J");
    stop:
    while(true){
			System.out.println("\t\t\t\t\t\t\t\tThe following are the choices:\n\t\t\t\t\t\t\t\t1. Enter new vehicle\n\t\t\t\t\t\t\t\t2. Exit a vehicle\n\t\t\t\t\t\t\t\t3. View grid\n\t\t\t\t\t\t\t\t4. Display logs\n\t\t\t\t\t\t\t\t5. Exit\n\t\t\t\t\t\t\t\tEnter your choice: ");


		int choice=0;

		while(true){
			try{
				System.out.print("\t\t\t\t\t\t\t\t");
		choice=scan.nextInt();
		if(choice<=5&&choice>=1)
			break;
		else
			throw new InputMismatchException();
		}
		catch(InputMismatchException e){
			System.out.print("\n\n\t\t\t\t\t\t\tEnter valid choice: \n");
			scan.next();
		}
	}

    switch(choice){

			case 1:
			System.out.print("\033[H\033[2J");
		  System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\tEnter the vehicle type...'#' for car and '$' for two-wheeler.");

		  char type=' ';
		  while(true){
		    try{
        System.out.print("\t\t\t\t\t\t\t");
    	  type=scan.next().charAt(0);
			    if(type!='#'&&type!='$')
				    throw new InputMismatchException();
			    else
			      break;
	      }
			  catch(InputMismatchException e){
				System.out.println("\n\n\t\t\t\t\t\t\tEnter valid choice.");
			 }
		  }

		locate =grid.allocate(type);
		if(locate.x!=-1){
			System.out.print("Enter name: ");
			scan.nextLine();
			System.out.print("");
			String name=scan.nextLine();
			String vehNo;
			while(true){
			System.out.print("Enter Vehicle number (Example: GJ01-HN-4561): ");
			System.out.print("");
			vehNo=scan.next();

			if(vehNo.charAt(0)>=65&&vehNo.charAt(0)<=90&&vehNo.charAt(1)>=65&&vehNo.charAt(1)<=90&&vehNo.charAt(2)>=48&&vehNo.charAt(2)<=90&&vehNo.charAt(3)>=48&&vehNo.charAt(3)<=57&&vehNo.charAt(5)>=65&&vehNo.charAt(5)<=90&&vehNo.charAt(6)>=65&&vehNo.charAt(6)<=90&&vehNo.charAt(8)>=48&&vehNo.charAt(8)<=57&&vehNo.charAt(9)>=48&&vehNo.charAt(9)<=57&&vehNo.charAt(10)>=48&&vehNo.charAt(10)<=57&&vehNo.charAt(11)>=48&&vehNo.charAt(11)<=57)
				break;
			else
			System.out.println("\n\n\t\t\t\tPlease enter a valid Indian Standard number plate as shown.\n\n");
		}
			String cellNo;
			while(true){
			System.out.print("Enter Cell Phone number: ");
			System.out.print("");
			cellNo=scan.next();
			if(cellNo.length()!=10)
					System.out.println("\n\n\t\t\t\tEnter a valid cell no.\n\n");
					else{
					System.out.println();
					break;
				}
			}


			File file;
			try{
				file=new File("log.txt");
				if(!file.exists()){
					file.createNewFile();
				}
				PrintWriter pw=new PrintWriter(new FileWriter(file, true));
				pw.println("Entry:");
				pw.println("Name: "+name);
				if(type=='#')
					pw.println("Vehicle type: Car");
				else
					pw.println("Vehicle type: Two-wheeler");
				pw.println("Vehicle Number: "+vehNo);
				pw.println("Cell Phone: "+ cellNo);
				pw.println("Location of parking(Coordinates): "+locate.x+" ,"+locate.y);

				int day, month, year;
		 		int second, minute, hour;
		 		GregorianCalendar date = new GregorianCalendar();                                              //created object for calender

		 day = date.get(Calendar.DAY_OF_MONTH);
		 month = date.get(Calendar.MONTH);
		 year = date.get(Calendar.YEAR);

		 second = date.get(Calendar.SECOND);
		 minute = date.get(Calendar.MINUTE);
		 hour = date.get(Calendar.HOUR);
		 pw.println("Date: "+day+"/"+(month+1)+"/"+year);                                                    //printing data into file
		 	pw.println("Time: "+hour+":"+minute+":"+second);
				pw.println();
				pw.println();
				pw.close();

			}
			catch(IOException e){
				System.out.println("\t\t\t\t\t\t\tProblem in creating logs, enter logs manually.");
				System.out.print("\033[H\033[2J");
			}

			System.out.println("\n\n\n\n\t\t\t\t\t\t\tYour parking location is row "+locate.x+" and column "+locate.y+" .\n\n");
			try{
				Thread.sleep(3000);
			}
			catch(InterruptedException e){
				System.out.println("Interruption.");
			}
			System.out.print("\033[H\033[2J");

		}else
		System.out.println("\033[H\033[2J\n\n\n\n\t\t\t\t\t\t\tSorry, all the parking spaces are full.\n\n\n\n\n\n\n");

      break;

      case 2:
			System.out.println("\n\n\n\n");
			grid.display();
			System.out.println("\t\t\t\t\t\t\tEnter the coordinates for removal:(Example: x y)");
			System.out.print("\t\t\t\t\t\t\t");
    	locate.x=scan.nextInt();
			locate.x=4*(locate.x-1)+2;
		 locate.y=scan.nextInt();
		 locate.y=2*(locate.y-1)+1;
			boolean check=false;
			check=grid.remove(locate);

			if(check==true){
		 System.out.print("Enter vehicle number: ");
		 System.out.print("");
		 scan.nextLine();
		 System.out.print("");
		 String exiting=scan.nextLine();
		 try{
			 File file=new File("log.txt");
			 if(!file.exists())
			 	file.createNewFile();

			 PrintWriter pw=new PrintWriter(new FileWriter(file, true));
			 pw.println("Exit:");
			 pw.println("Vehicle Number: "+exiting);
			 /*DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			 LocalDateTime now=LocalDateTime.now();
			 pw.println("Date & Time: "+dtf.format(now));*/
			 int day, month, year;
		 int second, minute, hour;
		GregorianCalendar date = new GregorianCalendar();

		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);

		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);
		pw.println("Date: "+day+"/"+(month+1)+"/"+year);
		 pw.println("Time: "+hour+":"+minute+":"+second);
			 pw.println();
			 pw.println();
			 pw.close();
		 }
		 catch(IOException e){
			 System.out.println("\t\t\t\t\t\t\tExit log entry failed, please enter to file manually.");
		 }

	 }
	 else
	 	System.out.println("\n\n\t\t\t\t\t\t\tThere is no vehicle in the plot.\n\n");

      break;

      case 3:
      grid.display();
      break;

			case 4:
			try{
					File file=new File("log.txt");
					BufferedReader bri=new BufferedReader(new FileReader(file));
					String buffer;
					System.out.println("\033[H\033[2J\n\t\t\t\t\t\t\tDisplaying previous Logs...");
					System.out.println();
					System.out.println();
					while((buffer=bri.readLine())!=null){
						System.out.println(buffer);
					}
					bri.close();

			}
			catch(IOException e){
				System.out.println("\033[H\033[2J\t\t\t\t\t\t\tError displaying Logs on the console, please refer to file manually.");
			}
			break;

			default:
			break stop;
    }


    //scan.next();

  }
	BufferedWriter bo = null;
	System.out.println("\033[H\033[2J\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\tSaving the database information...");
	try{
	Thread.sleep(2000);
    }
    catch(InterruptedException e){
			System.out.println("Interruption Detected!");
		}

try{
bo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Matrix.txt")));
for(int i=0; i<32;  i++){
	for(int j=0; j<32; j++){
		bo.write(grid.mat[i][j]);
	}
}
if(bo!=null)
bo.close();
}
catch(IOException e){
System.out.println("IO error.");

  }
System.out.println("\033[H\033[2J\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\tThanks for using our Software and have a good day ahead!!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
}
}
