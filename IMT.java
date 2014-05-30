import java.util.*;

public class IMT extends Thread{

	private List<Character> chars;
	private String word;
	private int thread;
	private Date initialDate;

	public IMT(String word, int thread){
		this.chars = getChars();
		this.word = word;
		this.thread = thread;
		this.initialDate = new Date();
	}

	public void run(){

		String attempt;
		Boolean found = false;

		while(!found){
			attempt = "";
			for(int i=0; i<word.length();i++){
				attempt = attempt + randomChar();
			}
			//puts(threadId + ": " +word + "---" + attempt + " lenght: " + word.length());
			if(word.equals(attempt)){
				found = true;
				long seconds = (new Date().getTime() - this.initialDate.getTime()) / 1000;
				puts("thread " + thread + " found '" + word + "' in " + getTimeString(seconds));
			}
		}
	}
	
	public static void main(String[] args){
		puts("\nInfinite Monkey Theorem!");
		puts("------------------------");
		int threads = Integer.parseInt(args[0]);
		String word = args[1];
		for(int x=0; x<threads; x++){
			new IMT(word, x).start();
		}
	}

	private  List<Character> getChars(){
		List<Character> chars = new ArrayList<Character>();
		for(int i=97; i<=122; i++){
			puts(Character.toChars(i)[0]);
			chars.add(Character.toChars(i)[0]);
		}
		chars.add('_');
		return chars;
	}

	private String getTimeString(long seconds){
		if(seconds < 1){
			return "less than a second";
		}else if(seconds == 1){
			return "one second";
		}else{
			return seconds + " seconds";
		}
	}

	private static void puts(Object o){
		System.out.println(o);
	}

	private Character randomChar(){
		return chars.get(random(0,27));
	}

	private int random(int ri, int rf){
		return (int)((rf-ri) * Math.random() + ri);
	}
	
}
