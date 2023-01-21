public class ReportManager implements Reportable{

    @Override
    public void report(User user) {
        System.out.println("Report for user: " + user.getName());
    }
}
