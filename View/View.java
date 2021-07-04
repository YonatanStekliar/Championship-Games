package View;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.text.FontPosture;
import javafx.scene.effect.Bloom;

public class View {
	private int namesCount, gameType, conuterShowDontBt;
	private boolean [] arrPlayAgame = {true,true,true,true,true,true,true};
	private Group root;
	private ToggleGroup tgr;
	private BorderPane bp;
	private GridPane gridPane;
	private Text Tchampionship, TinsertName, TtitlleteamOrPlayers, TnameOrTeam1, TnameOrTeam2, TnameOrTeam3,
			TnameOrTeam4, TnameOrTeam5, TnameOrTeam6, TnameOrTeam7, TnameOrTeam8, TnameOrTeamSemi1, TnameOrTeamSemi2,
			TnameOrTeamSemi3, TnameOrTeamSemi4, TnameOrTeamFinal1, TnameOrTeamFinal2, TnameOrTeamWinner, TShowPlayer1,
			TShowPlayer2;
	private TextField TfInsertName, tfP1FirstScore, tfP1SecondScore, tfP1ThirdScore, tfP1FourthScore, tfP1FifthScore,
			tfP2FirstScore, tfP2SecondScore, tfP2ThirdScore, tfP2FourthScore, tfP2FifthScore;
	private HBox hbinsertName, hbAddAndStart;
	private VBox vbShowTeam, vbNamesAddStart, vbGameType;
	private RadioButton rbTennis, rbSoccer, rbBaskerball;
	private Button BtAddPlayer, BtStartChampion, BtPlayAGameFirstQuarter, BtPlayAGameSecondQuarter,
			BtPlayAGameThirdQuarter, BtPlayAGameFourthQuarter, BtPlayAGameFirstSemi, BtPlayAGameSecondSemi,
			BtPlayAGameFinals, btDone;

	public View(Stage stage) {
		bp = new BorderPane();
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(2);
		gridPane.setHgap(2);
		root = new Group();
		tgr = new ToggleGroup();
		hbAddAndStart = new HBox();
		hbinsertName = new HBox();
		vbShowTeam = new VBox();
		vbNamesAddStart = new VBox();
		vbGameType = new VBox();
		TnameOrTeamWinner = new Text();
		TnameOrTeamFinal1 = new Text();
		TnameOrTeamFinal2 = new Text();
		TnameOrTeamSemi1 = new Text();
		TnameOrTeamSemi2 = new Text();
		TnameOrTeamSemi3 = new Text();
		TnameOrTeamSemi4 = new Text();

		TShowPlayer1 = new Text();
		TShowPlayer2 = new Text();
		btDone = new Button("Done");
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
		// create Hbox for insert name
		TinsertName = new Text("Participant name:");
		TinsertName.setFont(new Font(20));
		TfInsertName = new TextField();
		hbinsertName.getChildren().addAll(TinsertName, TfInsertName);
		// create Hbox for add player or team and start
		BtAddPlayer = new Button("Add participant");
		BtAddPlayer.setFont(new Font(20));
		BtStartChampion = new Button("Start championship");
		BtStartChampion.setFont(new Font(25));
		BtStartChampion.setTextFill(Color.DARKTURQUOISE);
		hbAddAndStart.getChildren().add(BtAddPlayer);
		vbNamesAddStart.getChildren().addAll(hbinsertName, hbAddAndStart);
		vbNamesAddStart.setAlignment(Pos.CENTER);
		// need to show the players
		Tchampionship = new Text("Championship");
		Tchampionship.setFill(Color.GOLD);
		Tchampionship.setFont(new Font(50));
		rbTennis = new RadioButton("Tennis");
		rbTennis.setFont(new Font(20));
		rbTennis.setToggleGroup(tgr);
		rbBaskerball = new RadioButton("Basketball");
		rbBaskerball.setFont(new Font(20));
		rbBaskerball.setToggleGroup(tgr);
		rbSoccer = new RadioButton("Soccer");
		rbSoccer.setFont(new Font(20));
		rbSoccer.setToggleGroup(tgr);
		vbGameType.getChildren().addAll(rbTennis, rbBaskerball, rbSoccer);
		vbGameType.setAlignment(Pos.CENTER_RIGHT);
		BtPlayAGameFirstQuarter = new Button("Play game");
		BtPlayAGameSecondQuarter = new Button("Play game");
		BtPlayAGameThirdQuarter = new Button("Play game");
		BtPlayAGameFourthQuarter = new Button("Play game");
		BtPlayAGameFirstSemi = new Button("Play game");
		BtPlayAGameSecondSemi = new Button("Play game");
		BtPlayAGameFinals = new Button("Play game");

		gridPane.add(Tchampionship, 41, 1);
		gridPane.add(vbNamesAddStart, 40, 25);
		gridPane.add(vbGameType, 120, 26);
		Scene scene = new Scene(gridPane, 1100, 900);
		stage.setScene(scene);
		stage.show();

	}

	public void setVbNames() {
		vbNamesAddStart.getChildren().clear();
		gridPane.add(BtStartChampion, 40, 20);
	}

	public void setTurnamnt() {
		getVbGameType().getChildren().clear();
		getVbNamesAddStart().getChildren().clear();
		gridPane.getChildren().clear();
		setGpPlayQuarterFirst();
		setbpPlayQuarterSecond();
		setbpPlayQuarterThird();
		setbpPlayQuarterfourth();
	}

	private void setGpPlayQuarterFirst() {
		gridPane.add(TnameOrTeam1, 10, 1);
		gridPane.add(TnameOrTeam2, 10, 3);
		gridPane.add(BtPlayAGameFirstQuarter, 18, 2);

	}

	private void setbpPlayQuarterSecond() {
		gridPane.add(TnameOrTeam3, 10, 11);
		gridPane.add(TnameOrTeam4, 10, 13);
		gridPane.add(BtPlayAGameSecondQuarter, 18, 12);
	}

	private void setbpPlayQuarterThird() {
		gridPane.add(TnameOrTeam5, 10, 21);
		gridPane.add(TnameOrTeam6, 10, 23);
		gridPane.add(BtPlayAGameThirdQuarter, 18, 22);
	}

	private void setbpPlayQuarterfourth() {
		gridPane.add(TnameOrTeam7, 10, 31);
		gridPane.add(TnameOrTeam8, 10, 33);
		gridPane.add(BtPlayAGameFourthQuarter, 18, 32);
	}

	public void showSemiFirstWinner(String s1) {
		TnameOrTeamSemi1.setText(s1);
		TnameOrTeamSemi1.setFont(new Font(35));
		TnameOrTeamSemi1.setFill(Color.RED);
		gridPane.add(TnameOrTeamSemi1, 45, 2);
	}

	public void showSemiSecondWinner(String s2) {
		TnameOrTeamSemi2.setText(s2);
		TnameOrTeamSemi2.setFont(new Font(35));
		TnameOrTeamSemi2.setFill(Color.BLUE);
		gridPane.add(TnameOrTeamSemi2, 45, 12);
	}

	public void showSemiThirdWinner(String s3) {
		TnameOrTeamSemi3.setText(s3);
		TnameOrTeamSemi3.setFont(new Font(35));
		TnameOrTeamSemi3.setFill(Color.GREEN);
		gridPane.add(TnameOrTeamSemi3, 45, 22);
	}

	public void showSemiFourWinner(String s4) {
		TnameOrTeamSemi4.setText(s4);
		TnameOrTeamSemi4.setFont(new Font(35));
		gridPane.add(TnameOrTeamSemi4, 45, 32);
	}

	public void showFirstSemiPlayGame() {
		gridPane.add(BtPlayAGameFirstSemi, 50, 7);
	}

	public void showSecondSemiPlayGame() {
		gridPane.add(BtPlayAGameSecondSemi, 50, 27);
	}

	public void showFinalFirstWinner(String s1) {
		TnameOrTeamFinal1.setText(s1);
		TnameOrTeamFinal1.setFont(new Font(35));
		TnameOrTeamFinal1.setFill(Color.RED);
		gridPane.add(TnameOrTeamFinal1, 60, 7);
	}

	public void showFinalSecondWinner(String s2) {
		TnameOrTeamFinal2.setText(s2);
		TnameOrTeamFinal2.setFont(new Font(35));
		TnameOrTeamFinal2.setFill(Color.BLUE);
		gridPane.add(TnameOrTeamFinal2, 60, 27);
	}

	public void showFinalPlayGame() {
		gridPane.add(BtPlayAGameFinals, 70, 17);
	}

	public void ShowWinner(String s) {
		Bloom bl = new Bloom();
		bl.setThreshold(0.01);
		TnameOrTeamWinner.setText(s);
		TnameOrTeamWinner.setFont(Font.font("David", FontPosture.REGULAR, 40));
		TnameOrTeamWinner.setFill(Color.GOLD);
		TnameOrTeamWinner.setEffect(bl);
		TnameOrTeamWinner.setUnderline(true);
		Text T = new Text("The winner, and the new champion is:");
		T.setFont(new Font(20));
		gridPane.add(T, 85, 17);
		gridPane.add(TnameOrTeamWinner, 85, 19);
	}

	public void clearNameText() {
		TfInsertName.clear();
	}

	public int GameType() { // 1=Tannis 2=basketBall 3=soccer
		if (rbTennis.isSelected()) {
			gameType = 1;
			return 1;
		}

		if (rbBaskerball.isSelected()) {
			gameType = 2;
			return 2;
		}

		if (rbSoccer.isSelected()) {
			gameType = 3;
			return 3;
		}
		return 0;
	}

	public int getGameType() {
		return gameType;
	}

	public void changeTittleName(String titlle) {
		TtitlleteamOrPlayers.setText(titlle);
		TtitlleteamOrPlayers.setFill(Color.RED);
	}

	public boolean addName(String name) {
		if (namesCount == 1) {
			TnameOrTeam1 = new Text(name);
			TnameOrTeam1.setFont(new Font(40));
			TnameOrTeam1.setFill(Color.RED);
			return true;
		}
		if (namesCount == 2) {
			TnameOrTeam2 = new Text(name);
			TnameOrTeam2.setFont(new Font(40));
			TnameOrTeam2.setFill(Color.RED);
			return true;
		}
		if (namesCount == 3) {
			TnameOrTeam3 = new Text(name);
			TnameOrTeam3.setFont(new Font(40));
			TnameOrTeam3.setFill(Color.BLUE);
			return true;
		}
		if (namesCount == 4) {
			TnameOrTeam4 = new Text(name);
			TnameOrTeam4.setFont(new Font(40));
			TnameOrTeam4.setFill(Color.BLUE);
			return true;
		}
		if (namesCount == 5) {
			TnameOrTeam5 = new Text(name);
			TnameOrTeam5.setFont(new Font(40));
			TnameOrTeam5.setFill(Color.GREEN);
			return true;
		}
		if (namesCount == 6) {
			TnameOrTeam6 = new Text(name);
			TnameOrTeam6.setFont(new Font(40));
			TnameOrTeam6.setFill(Color.GREEN);
			return true;
		}
		if (namesCount == 7) {
			TnameOrTeam7 = new Text(name);
			TnameOrTeam7.setFont(new Font(40));
			return true;
		}
		if (namesCount == 8) {
			TnameOrTeam8 = new Text(name);
			TnameOrTeam8.setFont(new Font(40));
			return true;
		}
		return false;
	}

	public void namesCount() {
		namesCount++;
	}

	public Group getRoot() {
		return root;
	}

	public void addNameButton(EventHandler<ActionEvent> event) {
		BtAddPlayer.setOnAction(event);
	}

	public void startChampion(EventHandler<ActionEvent> event) {
		BtStartChampion.setOnAction(event);
	}

	public void playGameFirstQuarter(EventHandler<ActionEvent> event) {
		BtPlayAGameFirstQuarter.setOnAction(event);
	}

	public void playGameSecondQuarter(EventHandler<ActionEvent> event) {
		BtPlayAGameSecondQuarter.setOnAction(event);
	}

	public void playGameThirdQuarter(EventHandler<ActionEvent> event) {
		BtPlayAGameThirdQuarter.setOnAction(event);
	}

	public void playGameFourthQuarter(EventHandler<ActionEvent> event) {
		BtPlayAGameFourthQuarter.setOnAction(event);
	}

	public void playGameFirstSemi(EventHandler<ActionEvent> event) {
		BtPlayAGameFirstSemi.setOnAction(event);
	}

	public void playGameSecondSemi(EventHandler<ActionEvent> event) {
		BtPlayAGameSecondSemi.setOnAction(event);
	}

	public void playGameFinals(EventHandler<ActionEvent> event) {
		BtPlayAGameFinals.setOnAction(event);
	}

	public void DoneButton(EventHandler<ActionEvent> event) {
		btDone.setOnAction(event);
	}
	
	public void arrToFalse(int i) {
		arrPlayAgame[i] = false;
	}

	public Button getBtPlayAGameFirstQuarter() {
		return BtPlayAGameFirstQuarter;
	}

	public Button getBtPlayAGameSecondQuarter() {
		return BtPlayAGameSecondQuarter;
	}

	public Button getBtPlayAGameThirdQuarter() {
		return BtPlayAGameThirdQuarter;
	}

	public Button getBtPlayAGameFourthQuarter() {
		return BtPlayAGameFourthQuarter;
	}

	public Button getBtPlayAGameFirstSemi() {
		return BtPlayAGameFirstSemi;
	}

	public Button getBtPlayAGameSecondSemi() {
		return BtPlayAGameSecondSemi;
	}

	public Button getBtPlayAGameFinals() {
		return BtPlayAGameFinals;
	}

	public int getNamesCount() {
		return namesCount;
	}

	public VBox getVbGameType() {
		return vbGameType;
	}

	public ToggleGroup getTgr() {
		return tgr;
	}

	public BorderPane getbp() {
		return bp;
	}

	public Text getTchampionship() {
		return Tchampionship;
	}

	public BorderPane getBp() {
		return bp;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public Text getTnameOrTeamSemi1() {
		return TnameOrTeamSemi1;
	}

	public Text getTnameOrTeamSemi2() {
		return TnameOrTeamSemi2;
	}

	public Text getTnameOrTeamSemi3() {
		return TnameOrTeamSemi3;
	}

	public Text getTnameOrTeamSemi4() {
		return TnameOrTeamSemi4;
	}

	public Text getTnameOrTeamFinal1() {
		return TnameOrTeamFinal1;
	}

	public Text getTnameOrTeamFinal2() {
		return TnameOrTeamFinal2;
	}

	public Text getTnameOrTeamWinner() {
		return TnameOrTeamWinner;
	}

	public Text getTinsertName() {
		return TinsertName;
	}

	public Text getTtitlleteamOrPlayers() {
		return TtitlleteamOrPlayers;
	}

	public Text getTnameOrTeam1() {
		return TnameOrTeam1;
	}

	public Text getTnameOrTeam2() {
		return TnameOrTeam2;
	}

	public Text getTnameOrTeam3() {
		return TnameOrTeam3;
	}

	public Text getTnameOrTeam4() {
		return TnameOrTeam4;
	}

	public Text getTnameOrTeam5() {
		return TnameOrTeam5;
	}

	public Text getTnameOrTeam6() {
		return TnameOrTeam6;
	}

	public Text getTnameOrTeam7() {
		return TnameOrTeam7;
	}

	public int getConuterShowDontBt() {
		return conuterShowDontBt;
	}

	public boolean[] getArrPlayAgame() {
		return arrPlayAgame;
	}

	public Text getTnameOrTeam8() {
		return TnameOrTeam8;
	}

	public TextField getTfInsertName() {
		return TfInsertName;
	}

	public HBox getHbinsertName() {
		return hbinsertName;
	}

	public HBox getHbAddAndStart() {
		return hbAddAndStart;
	}

	public VBox getVbShowTeam() {
		return vbShowTeam;
	}

	public Text getTShowPlayer1() {
		return TShowPlayer1;
	}

	public Text getTShowPlayer2() {
		return TShowPlayer2;
	}

	public VBox getVbNamesAddStart() {
		return vbNamesAddStart;
	}

	public RadioButton getRbTennis() {
		return rbTennis;
	}

	public RadioButton getRbSoccer() {
		return rbSoccer;
	}

	public RadioButton getRbBaskerball() {
		return rbBaskerball;
	}

	public Button getBtAddPlayer() {
		return BtAddPlayer;
	}

	public Button getBtStartChampion() {
		return BtStartChampion;
	}

	public Button getBtDone() {
		return btDone;
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

	public void ConuterShowDontBt() {
		conuterShowDontBt++;
	}

	public void setConuterShowDontBt(int n) {
		this.conuterShowDontBt = n;
	}

	public void updatePlayAGame(int tourmanant) {
		if (conuterShowDontBt == 4 && tourmanant == 1) {
			setConuterShowDontBt(0);
			showFirstSemiPlayGame();
			showSecondSemiPlayGame();
		}
		if (conuterShowDontBt == 2 && tourmanant == 2) {
			setConuterShowDontBt(0);
			showFinalPlayGame();
		}
	}
}
