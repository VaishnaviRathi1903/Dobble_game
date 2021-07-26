package dobbleGame;  //packages
import java.util.*;

class dobble{   //class
	String note;   //instance variable
	char c;
	dobble(String note){  //constructor
		this.note=note;   //usage of this keyword
	}
	dobble(char c,String note){  //constructor overloading (same constructor having different parameters)
		this.c=c;
		this.note=note;
	}
	void show() {
		System.out.println(c+note+c);
	}
	void display(){   //overriding (same function in both super and sub-class)
		System.out.println(note);
	}
}

class instruction extends dobble{  //inheritence
	int num;
	instruction(int num,String note){
		super(note); //super keyword is used (to access dobble class instances)
		this.num=num;
	}
	void display() {   //overriding (same function in both super and sub-class)
		System.out.println(num + ")"+ note);
	}
	
}
interface cards{   //interface
	void print();
}
class show implements cards{  //class implementation of interface.
	public void print() {
		System.out.println("Enter the size of the card!!");
	}
}

class greetings extends Thread{  //thread implementation
	public void run() {
		System.out.println("\nThank you for playing the game!!\nHave a nice day :) ");
	}
}

public class My_game
{
    public static char randomchar(String s) {  //generating random character
    	Random r=new Random();
    	int k=r.nextInt(s.length());
    	char c=s.charAt(k);
    	return c;	
    }
	public static void main(String[] args) {
		int u;
		dobble d=new dobble("WELCOME TO THE DOBBLE-GAME\n"); //declaring object of class dobble
		d.display();
		dobble e=new dobble('*',"INSTRUCTIONS");
		e.show();
		instruction o=new instruction(1,"Here two cards are given.");
		instruction p=new instruction(2,"The player has to choose the common element among the two cards.");
		instruction q=new instruction(3,"If the choosen element is common then the program prints correct\n else the program prints wrong.\n");
		o.display();
		p.display();
		q.display();
		
		Scanner sc = new Scanner(System.in);
		Random r1=new Random();
		do {
		String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!#$%&?/~|+=";
		show w=new show();//interface implementation
		w.print();
		int n=sc.nextInt();
	    char[] card1= new char[n];
	    char[] card2=new char[n];
	    char samesym=randomchar(s);
	    s=s.replace(samesym,' ');
	    int pos1,pos2;
	    pos1=r1.nextInt(n);
	    pos2=r1.nextInt(n);
	    if(pos1==pos2) {
	    	card1[pos1]=samesym;
	    	card2[pos2]=samesym;
	    }
	    else {
	    	card1[pos1]=samesym;
	        card2[pos2]=samesym;
	        card1[pos2]=randomchar(s);
	        s=s.replace(card1[pos2],' ');
	        card2[pos1]=randomchar(s);
	        s=s.replace(card2[pos1],' ');//string handleing
	    }
	    int i=0;
		while(i<n) {
			if(i!=pos1 && i!=pos2) {
				char c1=randomchar(s);
				char c2=randomchar(s);
				s=s.replace(c1, ' ');
				s=s.replace(c2, ' ');
				card1[i]=c1;
				card2[i]=c2;
			}
			i=i+1;
		}
		System.out.println(card1);
		System.out.println(card2);
		System.out.println("Guess the common symbol");
		char ch=sc.next().charAt(0);
		if(ch==samesym) {
			System.out.println("Correct\n");
		}
		else {
			try {                      //exception handling
				throw new Exception();
			}
			catch(Exception E) {
			System.out.println("Wrong\n");}
		}
		System.out.println("Do you want to continue?(1 to continue, 0 to quit.)");
		 u=sc.nextInt();
	}while(u==1);
		greetings g=new greetings();
		g.start();  //thread start
	}

}
