import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		 File myObj = new File("phone.txt");
	     Scanner myFile = new Scanner(myObj); 
	     Scanner fileToInsert=new Scanner(myObj);
	     ArrayList <Contact>newArrayList=new ArrayList();
	     
	     //int length=getFileLength(myFile);
	     //Contact[] contact=new Contact[length];
	     newArrayList=puttingContactInArrayList(newArrayList,fileToInsert);
	     gameLogic(newArrayList);
	     myFile.close();
	     fileToInsert.close();
	    }
		
		public static void Printing(Scanner myFile) {
	        // While myFIle has a next line ? Go inside
	        while (myFile.hasNextLine()) {
	            String data = myFile.nextLine();
	            System.out.println(data);
	        }
		}
		
		public static int getFileLength(Scanner file) {
			int count=0;
			while (file.hasNextLine()) {
				file.nextLine();
				count++;
			}
			return count;
		}
		
		public static ArrayList<Contact> puttingContactInArrayList(ArrayList<Contact> arrayList,Scanner file) {
			// While myFIle has a next line ? Go inside
			String firstName;
			String lastName;
			int phoneNumber;
			
	        while (file.hasNextLine()) {
	            String data = file.nextLine();
	            String[] line=data.split(" ");
	            firstName=line[0];
	            lastName=line[1];
	            phoneNumber=Integer.parseInt(line[2]);
	            Contact newContact=new Contact(firstName,lastName,phoneNumber);
	            arrayList.add(newContact);
	        }
	        return arrayList;
		}
		
		public static void entryMessage() {
			System.out.println("My phone book application");
			System.out.println("please choose an operation: ");
		}
		
		public static void byeMessage() {
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("Thank you for using this app!");
			System.out.println("------------------------------");
		}
		
		public static void gameLogic(ArrayList<Contact> arrayList) {
			//MySystem mySystem=new MySystem(array);
			String prompt=" A(add), S(search), D(delete), L(list), Q(quit) ";
			entryMessage();
			System.out.println(prompt);
			Scanner sc=new Scanner(System.in);
			String answer=sc.nextLine();
				
			while(true) {
				if(answer.equalsIgnoreCase("A")||answer.equalsIgnoreCase("add")) {
					Scanner add=new Scanner(System.in);
					System.out.println("Please enter the contact name: ");
					String name=add.nextLine();
					System.out.println("Please enter your phone number: ");
					int phone=add.nextInt();
					String[] splitName=name.split(" ");
					String firstName=splitName[0].toUpperCase();
					String lastName=splitName[1].toUpperCase();
					Contact newAdd=new Contact(firstName,lastName,phone);
					arrayList.add(newAdd);
					
					System.out.println();
					System.out.println(prompt);
					answer=sc.nextLine();
					
				}
				else if(answer.equalsIgnoreCase("L")||answer.equalsIgnoreCase("list")) {
					ListIterator<Contact> iterator=arrayList.listIterator();
					int x=1;
					while(iterator.hasNext()){
						System.out.println(x+". "+iterator.next().firstName+" "+iterator.next().lastName+" "+iterator.next().phoneNumber);
						x++;
					}
					System.out.println();
					System.out.println(prompt);
					answer=sc.nextLine();
				}
				else if(answer.equalsIgnoreCase("Q")||answer.equalsIgnoreCase("quit")) {
					byeMessage();
					break;
				}
				else if(answer.equalsIgnoreCase("S")||(answer.equalsIgnoreCase("search"))) {
					Scanner search=new Scanner(System.in);
					System.out.println("Please enter contact first & last name: ");
					String nameSearch=search.nextLine();
					String[] splitSearchName=nameSearch.split(" ");
					String firstName=splitSearchName[0].toUpperCase();
					String lastName=splitSearchName[1].toUpperCase();
					ListIterator<Contact> iterator=arrayList.listIterator();
					while(iterator.hasNext()) {
						if(iterator.next().firstName.equalsIgnoreCase(firstName)&&iterator.next().lastName.equalsIgnoreCase(lastName)) {
							System.out.println("phone number: "+iterator.next().phoneNumber);
						}
					}
					System.out.println(prompt);
					answer=sc.nextLine();
					
				}
				else if(answer.equalsIgnoreCase("D")||(answer.equalsIgnoreCase("delete"))){
					Scanner delete=new Scanner(System.in);
					System.out.println("Please enter first & last name");
					String deleteName=delete.nextLine();
					String[] splitDeleteName=deleteName.split(" ");
					String firstName=splitDeleteName[0].toUpperCase();
					String lastName=splitDeleteName[1].toUpperCase();
					ListIterator<Contact> iterator=arrayList.listIterator();
					while(iterator.hasNext()) {
						if(iterator.next().firstName.equalsIgnoreCase(firstName)&&iterator.next().lastName.equalsIgnoreCase(lastName)) {
							arrayList.remove(iterator.next());
							
						}
					}
					
					//arrayList.listIterator();
					System.out.println(prompt);
					answer=sc.nextLine();
					
			}
		}
	}
}
