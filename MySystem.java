package ObjectAndClass.Array;

  

public class MySystem {
	Contact[] array;
	
	public MySystem(Contact[] array1) {
		this.array=array1;
	}
	
	public void add(Contact newOne) {
		Contact[] newArray=new Contact[array.length+1];
		for(int i=0;i<array.length;i++) {
			newArray[i]=array[i];
		}
		
		newArray[newArray.length-1]=newOne;
		this.array=newArray;
		System.out.println("user added!");
	}
	
	public void delete(String name1, String name2) {
		boolean found=false;
		Contact[] newArray=new Contact[array.length-1];
		int index=0;
		for(int i=0;i<array.length;i++) {
			if(array[i].firstName.equals(name1) && array[i].lastName.equals(name2)) {
				found=true;
			}
			else {
				newArray[index]=array[i];
				index++;
			}
		}
		
		if(found) {
			System.out.println("User deleted");
			this.array=newArray;
		}
		else {
			System.out.println("user not found");
		}
	}
	
	public void search(String name1, String name2) {
		boolean found=false;
		for(int i=0;i<array.length;i++) {
			if(array[i].firstName.equals(name1)&& array[i].lastName.equals(name2)) {
				found=true;
				System.out.println("phone number: "+array[i].phoneNumber);
			}
		}
		if(!found) {
			System.out.println("user not found!");
		}
	}
	
	public void list() {
		int x=0;
		for(int i=0;i<array.length;i++) {
			x++;
			System.out.println(x+"."+array[i].firstName+" "+array[i].lastName);
		}
	}
	
	public void entryMessage() {
		System.out.println("My phone book application");
		System.out.println("please choose an operation: ");
	}
	
	public void byeMessage() {
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Thank you for using this app!");
		System.out.println("------------------------------");
	}
}

  