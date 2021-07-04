package View;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

public class ViewGame {
	View theView;
	private Text TShowPlayer1, TShowPlayer2, title;
	private TextField tfP1FirstScore, tfP1SecondScore, tfP1ThirdScore, tfP1FourthScore, tfP1FifthScore, tfP2FirstScore,
			tfP2SecondScore, tfP2ThirdScore, tfP2FourthScore, tfP2FifthScore;
	private GridPane gpGame;
	private Button btDone, btDonePenalties;
	private int gameType;
	private Stage stage;

	public ViewGame(Stage stage, View theView) {
		this.theView = theView;
		this.stage = stage;
		gpGame = new GridPane();
		gpGame.setPadding(new Insets(10, 10, 10, 10));
		btDone = new Button("Done");
		btDonePenalties = new Button("Done");
		gpGame.setVgap(5);
		gpGame.setHgap(5);
		TShowPlayer1 = new Text();
		TShowPlayer1.setFont(new Font(20));
		TShowPlayer2 = new Text();
		TShowPlayer2.setFont(new Font(20));
		title = new Text();
		tfP1FirstScore = new TextField();
		tfP1SecondScore = new TextField();

		tfP1ThirdScore = new TextField();

		tfP1FourthScore = new TextField();

		tfP1FifthScore = new TextField();

		tfP2FirstScore = new TextField();

		tfP2SecondScore = new TextField();

		tfP2ThirdScore = new TextField();

		tfP2FourthScore = new TextField();

		tfP2FifthScore = new TextField();

		Scene scene = new Scene(gpGame, 500, 400);

		stage.setScene(scene);
		stage.show();
	}

	public void playAgameQuarter(int playGameIndex) { // displays for each type of game the scores textfield
		if (playGameIndex == 1) {
			TShowPlayer1.setText(theView.getTnameOrTeam1().getText());
			TShowPlayer2.setText(theView.getTnameOrTeam2().getText());
		}
		if (playGameIndex == 2) {
			TShowPlayer1.setText(theView.getTnameOrTeam3().getText());
			TShowPlayer2.setText(theView.getTnameOrTeam4().getText());
		}
		if (playGameIndex == 3) {
			TShowPlayer1.setText(theView.getTnameOrTeam5().getText());
			TShowPlayer2.setText(theView.getTnameOrTeam6().getText());
		}
		if (playGameIndex == 4) {
			TShowPlayer1.setText(theView.getTnameOrTeam7().getText());
			TShowPlayer2.setText(theView.getTnameOrTeam8().getText());
		}
		InsertNamesAndTextField();
	}

	public void playAgameSemi(int playGameIndex) { // displays for each type of game the scores textfield
		if (playGameIndex == 1) {
			TShowPlayer1.setText(theView.getTnameOrTeamSemi1().getText());
			TShowPlayer2.setText(theView.getTnameOrTeamSemi2().getText());
		}
		if (playGameIndex == 2) {
			TShowPlayer1.setText(theView.getTnameOrTeamSemi3().getText());
			TShowPlayer2.setText(theView.getTnameOrTeamSemi4().getText());
		}
		InsertNamesAndTextField();
	}

	public void playAgameFinal(int playGameIndex) {
		TShowPlayer1.setText(theView.getTnameOrTeamFinal1().getText());
		TShowPlayer2.setText(theView.getTnameOrTeamFinal2().getText());
		InsertNamesAndTextField();
	}

	private void InsertNamesAndTextField() {
		int gameType = theView.getGameType();
		if (gameType == 1) { // tennis
			title.setText("Tennis game");
			title.setFont(new Font(20));
			title.setFill(Color.CORAL);
			gpGame.add(title, 15, 1);
			gpGame.add(TShowPlayer1, 3, 10); // add name 1
			gpGame.add(tfP1FirstScore, 10, 10);
			gpGame.add(tfP1SecondScore, 15, 10);
			gpGame.add(tfP1ThirdScore, 20, 10);
			gpGame.add(tfP1FourthScore, 25, 10);
			gpGame.add(tfP1FifthScore, 30, 10);
			gpGame.add(TShowPlayer2, 3, 20); // add name 1
			gpGame.add(tfP2FirstScore, 10, 20);
			gpGame.add(tfP2SecondScore, 15, 20);
			gpGame.add(tfP2ThirdScore, 20, 20);
			gpGame.add(tfP2FourthScore, 25, 20);
			gpGame.add(tfP2FifthScore, 30, 20);
		}
		if (gameType == 2) { // bASKEtball
			title.setText("Basketball game");
			title.setFont(new Font(20));
			title.setFill(Color.CORAL);
			gpGame.add(title, 15, 1);
			gpGame.add(TShowPlayer1, 3, 10); // add name 1
			gpGame.add(tfP1FirstScore, 10, 10);
			gpGame.add(tfP1SecondScore, 13, 10);
			gpGame.add(tfP1ThirdScore, 16, 10);
			gpGame.add(tfP1FourthScore, 19, 10);
			gpGame.add(TShowPlayer2, 3, 20); // add name 1
			gpGame.add(tfP2FirstScore, 10, 20);
			gpGame.add(tfP2SecondScore, 13, 20);
			gpGame.add(tfP2ThirdScore, 16, 20);
			gpGame.add(tfP2FourthScore, 19, 20);
		}
		if (gameType == 3) { // soccer
			title.setText("Soccer game");
			Text T = new Text("overtime");
			title.setFont(new Font(20));
			title.setFill(Color.CORAL);
			gpGame.add(title, 15, 1);
			gpGame.add(TShowPlayer1, 3, 10); // add name 1
			gpGame.add(tfP1FirstScore, 10, 10);
			gpGame.add(tfP1SecondScore, 13, 10);
			gpGame.add(tfP1ThirdScore, 16, 10);
			gpGame.add(TShowPlayer2, 3, 20); // add name 1
			gpGame.add(tfP2FirstScore, 10, 20);
			gpGame.add(tfP2SecondScore, 13, 20);
			gpGame.add(tfP2ThirdScore, 16, 20);
			gpGame.add(T, 18, 15);
		}
		gpGame.add(btDone, 15, 30);
	}

	public void doneButton(EventHandler<ActionEvent> event) {
		btDone.setOnAction(event);
	}

	public View getTheView() {
		return theView;
	}

	public Text getTShowPlayer1() {
		return TShowPlayer1;
	}

	public Text getTShowPlayer2() {
		return TShowPlayer2;
	}

	public Text getTitle() {
		return title;
	}

	public TextField getTfP1FirstScore() {
		return tfP1FirstScore;
	}

	public TextField getTfP1SecondScore() {
		return tfP1SecondScore;
	}

	public TextField getTfP1ThirdScore() {
		return tfP1ThirdScore;
	}

	public TextField getTfP1FourthScore() {
		return tfP1FourthScore;
	}

	public TextField getTfP1FifthScore() {
		return tfP1FifthScore;
	}

	public TextField getTfP2FirstScore() {
		return tfP2FirstScore;
	}

	public TextField getTfP2SecondScore() {
		return tfP2SecondScore;
	}

	public TextField getTfP2ThirdScore() {
		return tfP2ThirdScore;
	}

	public TextField getTfP2FourthScore() {
		return tfP2FourthScore;
	}

	public TextField getTfP2FifthScore() {
		return tfP2FifthScore;
	}

	public GridPane getGpGame() {
		return gpGame;
	}

	public Button getBtDone() {
		return btDone;
	}

	public int getGameType() {
		this.gameType = theView.getGameType();
		return gameType;
	}

	public Button getBtDonePenalties() {
		return btDonePenalties;
	}

	public void closeGame() {
		stage.close();
	}

	public Stage getStage() {
		return stage;
	}

	public int getIntTfP1FirstScore() {
		return cheackIfLegal(tfP1FirstScore.getText());
	}

	public int getIntTfP1SecondScore() {
		return cheackIfLegal(tfP1SecondScore.getText());
	}

	public int getIntTfP1ThirdScore() {
		return cheackIfLegal(tfP1ThirdScore.getText());
	}

	public int getIntTfP1FourScore() {
		return cheackIfLegal(tfP1FourthScore.getText());
	}

	public int getIntTfP1FifthScore() {
		return cheackIfLegal(tfP1FifthScore.getText());
	}

	public int getIntTfP2FirstScore() {
		return cheackIfLegal(tfP2FirstScore.getText());
	}

	public int getIntTfP2SecondScore() {
		return cheackIfLegal(tfP2SecondScore.getText());
	}

	public int getIntTfP2ThirdScore() {
		return cheackIfLegal(tfP2ThirdScore.getText());
	}

	public int getIntTfP2FourScore() {
		return cheackIfLegal(tfP2FourthScore.getText());
	}

	public int getIntTfP2FifthScore() {
		return cheackIfLegal(tfP2FifthScore.getText());
	}

	private int cheackIfLegal(String str) {
		if (str.isEmpty())
			return 0;
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (!Character.isDigit(c))
				return 0;
		}
		return Integer.parseInt(str);

	}

	public ViewPenalty showPenalty() {
		return new ViewPenalty(title, TShowPlayer1, TShowPlayer2, tfP1FirstScore, tfP2FirstScore, new Stage());
	}

	public void clearTf() {
		tfP1FirstScore.clear();
		tfP2FirstScore.clear();
	}

}
