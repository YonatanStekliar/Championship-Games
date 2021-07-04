package View;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

public class ViewPenalty {
	private GridPane gpGame;
	private Button btDone;
	private Stage stage;
	TextField tfP1FirstScore, tfP2FirstScore;

	public ViewPenalty(Text title, Text tShowPlayer1, Text tShowPlayer2, TextField tfP1FirstScore,
			TextField tfP2FirstScore, Stage stage) {
		this.tfP1FirstScore = tfP1FirstScore;
		this.tfP2FirstScore = tfP2FirstScore;
		this.stage = stage;
		gpGame = new GridPane();
		gpGame.setPadding(new Insets(10, 10, 10, 10));
		gpGame.setVgap(5);
		gpGame.setHgap(5);
		btDone = new Button("done");
		title.setText("Soccer game - penalties ");
		title.setFont(new Font(20));
		title.setFill(Color.CORAL);
		gpGame.add(title, 15, 1);
		gpGame.add(tShowPlayer1, 3, 10); // add name 1
		gpGame.add(tfP1FirstScore, 10, 10);
		gpGame.add(tShowPlayer2, 3, 20); // add name 1
		gpGame.add(tfP2FirstScore, 10, 20);
		gpGame.add(btDone, 15, 25);
		Scene scene = new Scene(gpGame, 500, 400);
		stage.setScene(scene);
		stage.show();
	}

	public void donepenaltiesButton(EventHandler<ActionEvent> event) {
		btDone.setOnAction(event);
	}

	public void closePenalty() {
		stage.close();
	}

	public int getIntTfP1FirstScore() {
		return Integer.parseInt(tfP1FirstScore.getText());
	}

	public int getIntTfP2FirstScore() {
		return Integer.parseInt(tfP2FirstScore.getText());
	}
}
