package pkg03;

public class MainClass {

	public static void main(String[] args) {
		Database db = new Database();
		MainMenu instance = new MainMenu(db);
		instance.setVisible(true);
	}

}
