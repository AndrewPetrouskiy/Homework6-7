public class Main{
	public static void main(String[] args){
		User user = new User("Bob");
		Saver saver = new Saver(user);
		new ReportManager().report(user);
		saver.save();
	}
}