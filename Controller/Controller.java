package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import View.ViewGame;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	private Model.Model theModel;
	private View.View theView;

	public Controller(View.View view, Model.Model model) {
		theModel = model;
		theView = view;
		List<String> names = new ArrayList<>();
		theView.addNameButton(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert A = new Alert(AlertType.INFORMATION);
				int nameCount = 0;
				boolean flag = true;
				String name = theView.getTfInsertName().getText();
				char[] chars = name.toCharArray();
				for (char c : chars) {
					if (!Character.isLetter(c))
						flag = false;
				}
				if (flag) {
					names.add(name); // insert the name from textField
					theView.namesCount();
					theView.addName(name);
					theView.clearNameText();
					nameCount = theView.getNamesCount();
					A.setHeaderText("Good job!");
					A.setContentText(name + " was added succesfully! \n" + "You need to insert " + (8 - nameCount)
							+ " more names");
					A.show();
				} else
					A.setContentText("You can't put an empty name as a participant!");
				A.show();
				if (nameCount == 8) {
					theView.setVbNames();
				}
			}
		});
		theView.startChampion(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int chose = theView.GameType();
				if (theView.getNamesCount() == 8 && chose != 0) {
					theView.setTurnamnt();
					if (chose == 1) { // tennis
						theModel.getTennis().createPlayerOrTeam(names);
					}
					if (chose == 2) {
						theModel.getBasketball().createPlayerOrTeam(names);
					}
					if (chose == 3) {
						theModel.getSoccer().createPlayerOrTeam(names);
					}
				}
			}
		});

		theView.playGameFirstQuarter(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (theView.getArrPlayAgame()[0]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(1, 1, viewGame, model, theView);
					theView.arrToFalse(0);
				}
			}
		});
		theView.playGameSecondQuarter(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (theView.getArrPlayAgame()[1]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(2, 1, viewGame, model, theView);
					theView.arrToFalse(1);
				}
			}
		});
		theView.playGameThirdQuarter(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (theView.getArrPlayAgame()[2]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(3, 1, viewGame, model, theView);
					theView.arrToFalse(2);
				}
			}
		});
		theView.playGameFourthQuarter(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (theView.getArrPlayAgame()[3]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(4, 1, viewGame, model, theView);
					theView.arrToFalse(3);
				}
			}
		});
		theView.playGameFirstSemi(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (theView.getArrPlayAgame()[4]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(1, 2, viewGame, model, theView);
					theView.arrToFalse(4);
				}
			}
		});
		theView.playGameSecondSemi(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (theView.getArrPlayAgame()[5]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(2, 2, viewGame, model, theView);
					theView.arrToFalse(5);
				}
			}
		});
		theView.playGameFinals(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (theView.getArrPlayAgame()[6]) {
					View.ViewGame viewGame = new ViewGame(new Stage(), theView);
					ControllerGame controllerGame = new ControllerGame(1, 3, viewGame, model, theView);
					theView.arrToFalse(6);
				}
			}
		});
	}

}
