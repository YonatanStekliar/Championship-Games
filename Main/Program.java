package Main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Model.Model model = new Model.Model();
		View.View view = new View.View(arg0);
		Controller.Controller controller = new Controller.Controller(view, model);
	}

}
