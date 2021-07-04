package Controller;

import java.util.Random;

import Model.Model;
import View.ViewGame;
import View.ViewPenalty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerPenalty {
	private ViewPenalty theViewPenalty;
	int winner;

	public ControllerPenalty(ViewPenalty viewP, ViewGame theViewGame, Model theModel, int whichPlayGameWasPressed,
			int tourmanant) {
		theViewPenalty = viewP;
		theViewPenalty.donepenaltiesButton(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert A = new Alert(AlertType.INFORMATION);
				int score1, score2; // scoreboards in penalties of the participants
				score1 = (viewP.getIntTfP1FirstScore());
				score2 = (viewP.getIntTfP2FirstScore());
				winner = theModel.getSoccer().penalty(score1, score2);
				if (winner == 0) {
					Random rand = new Random();
					winner = rand.nextInt(2) + 1;
					A.setContentText("There was a tie - We chose the winner by EN-DEN-DINO!");
					A.show();
				}
				ControllerGame.winAgame(whichPlayGameWasPressed, tourmanant, winner);
				viewP.closePenalty();

			}
		});
	}

	public int getWinner() {
		return winner;
	}

}
