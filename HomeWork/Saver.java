public class Saver implements FileSaver {
    private User user;

    public Saver(User user) {
        this.user = user;
    }

    @Override
    public void save() {
        System.out.println("Save user: " + user.getName());
    }
}
