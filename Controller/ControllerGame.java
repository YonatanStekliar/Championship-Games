package Controller;

import java.util.Random;
import Model.Model;
import View.ViewGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerGame {
	private Model theModel;
	private static View.ViewGame theViewGame;

	public ControllerGame(int whichPlayGameWasPressed, int tourmanant, ViewGame theViewGame, Model theModel,
			View.View view) {
		this.theModel = theModel;
		this.theViewGame = theViewGame;
		if (tourmanant == 1)
			theViewGame.playAgameQuarter(whichPlayGameWasPressed);
		if (tourmanant == 2)
			theViewGame.playAgameSemi(whichPlayGameWasPressed);
		if (tourmanant == 3)
			theViewGame.playAgameFinal(whichPlayGameWasPressed);

		theViewGame.doneButton(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.ConuterShowDontBt();
				Alert A = new Alert(AlertType.INFORMATION);
				int gameType = theViewGame.getGameType(); // which game we are playing
				int[] score1, score2; // scoreboards for the participants
				score1 = new int[5];
				score2 = new int[5];
				if (gameType == 1) { // tennis game
					score1[0] = (theViewGame.getIntTfP1FirstScore());
					score2[0] = (theViewGame.getIntTfP2FirstScore());
					score1[1] = (theViewGame.getIntTfP1SecondScore());
					score2[1] = (theViewGame.getIntTfP2SecondScore());
					score1[2] = (theViewGame.getIntTfP1ThirdScore());
					score2[2] = (theViewGame.getIntTfP2ThirdScore());
					score1[3] = (theViewGame.getIntTfP1FourScore());
					score2[3] = (theViewGame.getIntTfP2FourScore());
					score1[4] = (theViewGame.getIntTfP1FifthScore());
					score2[4] = (theViewGame.getIntTfP2FifthScore());
					int winner = theModel.getTennis().whichPlayerWinsIn3sets(score1, score2);
					if (winner == 0) {
						winner = theModel.getTennis().whichPlayerWinsIn5Sets(score1, score2);
						if (winner == 0) {
							Random rand = new Random();
							winner = rand.nextInt(2) + 1;
							A.setContentText("There was a tie - We chose the winner by EN-DEN-DINO!");
							A.show();
						}
					}
					theModel.getTennis().winAGame(winner, whichPlayGameWasPressed, tourmanant);
					winAgame(whichPlayGameWasPressed, tourmanant, winner);

				}
				if (gameType == 2) {
					score1[0] = (theViewGame.getIntTfP1FirstScore());
					score2[0] = (theViewGame.getIntTfP2FirstScore());
					score1[1] = (theViewGame.getIntTfP1SecondScore());
					score2[1] = (theViewGame.getIntTfP2SecondScore());
					score1[2] = (theViewGame.getIntTfP1ThirdScore());
					score2[2] = (theViewGame.getIntTfP2ThirdScore());
					score1[3] = (theViewGame.getIntTfP1FourScore());
					score2[3] = (theViewGame.getIntTfP2FourScore());
					int winner = theModel.getBasketball().whichTeamWin(score1, score2);
					if (winner == 0) {
						Random rand = new Random();
						winner = rand.nextInt(2) + 1;
						A.setContentText("There was a tie - We chose the winner by EN-DEN-DINO!");
						A.show();

					}
					theModel.getBasketball().winAGame(winner, whichPlayGameWasPressed, tourmanant);
					winAgame(whichPlayGameWasPressed, tourmanant, winner);

				}
				if (gameType == 3) {
					score1[0] = (theViewGame.getIntTfP1FirstScore());
					score2[0] = (theViewGame.getIntTfP2FirstScore());
					score1[1] = (theViewGame.getIntTfP1SecondScore());
					score2[1] = (theViewGame.getIntTfP2SecondScore());
					score1[2] = (theViewGame.getIntTfP1ThirdScore());
					score2[2] = (theViewGame.getIntTfP2ThirdScore());
					int winner = theModel.getSoccer().whichTeamWin(score1, score2);
					if (winner == 0) {
						A.setContentText("There was a tie - the winner was decided by the overtime!");
						A.show();
						winner = theModel.getSoccer().overTime(score1, score2);
						if (winner == 0) {
							A.setContentText("There was a tie - We are going to penalties!");
							A.show();
							theViewGame.clearTf();
							View.ViewPenalty viewP = theViewGame.showPenalty();
							ControllerPenalty Cp = new ControllerPenalty(viewP, theViewGame, theModel,
									whichPlayGameWasPressed, tourmanant);
							winner = Cp.getWinner();

						}
					}

					theModel.getSoccer().winAGame(winner, whichPlayGameWasPressed, tourmanant);
					winAgame(whichPlayGameWasPressed, tourmanant, winner);
				}
				theViewGame.closeGame();
				view.updatePlayAGame(tourmanant);
			}

		});

	}

	public static boolean winAgame(int whichPlayGameWasPressed, int tourmanant, int winner) {
		if (tourmanant == 1) {
			if (whichPlayGameWasPressed == 1) {
				if (winner == 1) {
					theViewGame.getTheView().showSemiFirstWinner(theViewGame.getTheView().getTnameOrTeam1().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView().showSemiFirstWinner(theViewGame.getTheView().getTnameOrTeam2().getText());
					return true;
				}
			}
			if (whichPlayGameWasPressed == 2) {
				if (winner == 1) {
					theViewGame.getTheView().showSemiSecondWinner(theViewGame.getTheView().getTnameOrTeam3().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView().showSemiSecondWinner(theViewGame.getTheView().getTnameOrTeam4().getText());
					return true;
				}
			}

			if (whichPlayGameWasPressed == 3) {
				if (winner == 1) {
					theViewGame.getTheView().showSemiThirdWinner(theViewGame.getTheView().getTnameOrTeam5().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView().showSemiThirdWinner(theViewGame.getTheView().getTnameOrTeam6().getText());
					return true;
				}
			}
			if (whichPlayGameWasPressed == 4) {
				if (winner == 1) {
					theViewGame.getTheView().showSemiFourWinner(theViewGame.getTheView().getTnameOrTeam7().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView().showSemiFourWinner(theViewGame.getTheView().getTnameOrTeam8().getText());
					return true;
				}
			}

		}
		if (tourmanant == 2) {
			if (whichPlayGameWasPressed == 1) {
				if (winner == 1) {
					theViewGame.getTheView()
							.showFinalFirstWinner(theViewGame.getTheView().getTnameOrTeamSemi1().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView()
							.showFinalFirstWinner(theViewGame.getTheView().getTnameOrTeamSemi2().getText());
					return true;
				}
			}
			if (whichPlayGameWasPressed == 2) {
				if (winner == 1) {
					theViewGame.getTheView()
							.showFinalSecondWinner(theViewGame.getTheView().getTnameOrTeamSemi3().getText());
					return true;
				}
				if (winner == 2) {
					theViewGame.getTheView()
							.showFinalSecondWinner(theViewGame.getTheView().getTnameOrTeamSemi4().getText());
					return true;
				}
			}
		}
		if (tourmanant == 3) {
			if (winner == 1) {
				theViewGame.getTheView().ShowWinner(theViewGame.getTheView().getTnameOrTeamFinal1().getText());
				return true;
			}
			if (winner == 2) {
				theViewGame.getTheView().ShowWinner(theViewGame.getTheView().getTnameOrTeamFinal2().getText());
				return true;
			}
		}
		return false;
	}

}
