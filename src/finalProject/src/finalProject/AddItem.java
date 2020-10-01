package finalProject;

public class AddItem implements Command{
	
	Burger burger;
	
	public AddItem(Burger burger) {
		this.burger=burger;
	}
	
	public void execute() {
		burger.cost();
		burger.getDesc();
	}
	
	public void undo() {
		burger.cost();
	}

}
