/*Name: Julia Smith
 *Final Project
 */ 

package application;
 

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.element.Element;

public class Main extends Application implements Patterns {

	static String object1;
	static String object2;
	static String option1;
	static String option2;
	static String option3;
	static String option4;
	static String answer;
	static boolean isCorrect = false;
	static int point;
	private static double opacity = 1;
	private static Label lbl;

	public static void main(String[] args) {

		ArrayList<Object> listOfLines = new ArrayList<>();

		readFile(listOfLines);

		getObject1(listOfLines);
		getObject2(listOfLines);
		getOption1(listOfLines);
		getOption2(listOfLines);
		getOption3(listOfLines);
		getOption4(listOfLines);

		// GUI
		launch(args);

		checkAnswer();
		System.out.println(point + " points");

		trimList(listOfLines);

	}

	private static ArrayList readFile(ArrayList listOfLines) {
		//// Saved into ArrayList of type Object

		try {
			BufferedReader bufReader = new BufferedReader(
					new FileReader("C:\\Users\\Julia\\Documents\\OOP\\Final\\input-1.txt"));

			String line = bufReader.readLine();
			while (line != null) {
				listOfLines.add(line);
				line = bufReader.readLine();
			}

			System.out.println(listOfLines);
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Object> result = listOfLines;
		return result;

	}

	private static <String> ArrayList trimList(ArrayList listOfLines) {
		listOfLines.subList(0, 2).clear();
		// listOfLines.subList(0, 2).remove(1);
		System.out.println("Current list looks like this: " + listOfLines);

		ArrayList result = listOfLines;
		return result;
	}

	private static int checkAnswer() {

		// Round1 :for double + int
		if ((object1.toString().matches(DOUBLE)
				& (object2.toString().matches(SINGLEINT) & answer.toString().matches(DOUBLE)))) {

			isCorrect = true;
			point = point + 1;

		} else {
			isCorrect = false;
			point = point + 0;

		}

//		// Round2 :for double + double
		if ((object1.toString().matches(DOUBLE)
				& (object2.toString().matches(DOUBLE) & answer.toString().matches(DOUBLE)))) {

			isCorrect = true;
			point++;

		} else {
			isCorrect = false;
			point = point + 0;

		}
//		//Round3, round4,round7, round9: for Strings
//		if ((object1.toString().matches(STRING)&(object2.toString().matches(STRING)&answer.toString().matches(STRING)))) {
//			
//			if(object1.toString()+object2.toString() == answer.toString()) {
//				isCorrect = true;
//			point ++;
//			}
//		} else {
//			isCorrect = false;
//			point = point+0;
//			
//		}
//		
//		// Round5, round10 :for int + int
//		if ((object1.toString().matches(SINGLEINT)&(object2.toString().matches(SINGLEINT)&answer.toString().matches(DOUBLEINT)))) {
//			
//			isCorrect = true;
//			point ++;
//			
//		} else {
//			isCorrect = false;
//			point = point+0;
//			
//		}
//		
//		// Round6 :for float + float
//				if ((object1.toString().matches(FLOAT)&(object2.toString().matches(FLOAT)&answer.toString().matches(FLOAT)))) {
//					
//					isCorrect = true;
//					point ++;
//					
//				} else {
//					isCorrect = false;
//					point = point+0;
//					
//				}
//				
//				// Round8 :for float + int
//				if ((object1.toString().matches(FLOAT)&(object2.toString().matches(SINGLEINT)&answer.toString().matches(FLOAT)))) {
//					
//					isCorrect = true;
//					point ++;
//					
//				} else {
//					isCorrect = false;
//					point = point+0;
//					
//				}

//
////		switch(answer) {
//		  case x:
//		    // code block
//		    break;
//		  case y:
//		    // code block
//		    break;
//		  default:
//		    // code block

		int result = point;
		return result;

	}

	private static String getObject1(ArrayList listOfLines) {

		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}
		object1 = roundQO[0];
		String result = object1;
		return result;

	}

	private static String getObject2(ArrayList listOfLines) {

		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}
		object2 = roundQO[1];
		String result = object2;
		return result;
	}

	private static String getOption1(ArrayList listOfLines) {

		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}

		option1 = roundQO[2];
		String result = option1;
		return result;

	}

	private static String getOption2(ArrayList listOfLines) {

		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}

		option2 = roundQO[3];
		String result = option2;
		return result;

	}

	private static String getOption3(ArrayList listOfLines) {

		System.out.println(listOfLines.subList(0, 2));
		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}

		option3 = roundQO[4];
		String result = option3;
		return result;

	}

	private static String getOption4(ArrayList listOfLines) {

		String round = listOfLines.subList(0, 2).toString();

		String roundForm = round.toString().replace(",", "") // remove the commas
				.replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();

		String[] roundQO = roundForm.split(" ");
		for (int i = 0; i < roundQO.length; i++) {
			// Fetch the item, trim it and put it back in
			roundQO[i] = roundQO[i].trim();

		}
		option4 = roundQO[5];
		String result = option4;

		return result;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 600, 700);
			root.setPadding(new Insets(10, 10, 10, 10));
			root.setStyle("-fx-border-width: 30;-fx-border-color: #4d4b4b;");
			root.setCenter(addGridPane());
			root.setRight(addFlowPane());

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		

//		

	}

	public static GridPane addGridPane() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		ColumnConstraints col = new ColumnConstraints();
		col.setHalignment(HPos.CENTER);
		grid.getColumnConstraints().add(col);

		RowConstraints row = new RowConstraints();
		row.setValignment(VPos.CENTER);
		grid.getRowConstraints().add(row);

		// Left label in column 1 (top), row 2
		Text name = new Text("Name Area");
		GridPane.setValignment(name, VPos.CENTER);
		GridPane.setHalignment(name, HPos.CENTER);
		grid.add(name, 0, 1);

		// Middle label in column 2 (top), row 2
		Text points = new Text("Points Total");
		GridPane.setValignment(points, VPos.CENTER);
		GridPane.setHalignment(points, HPos.CENTER);
		grid.add(points, 1, 1);

		// Right label in column 3 (top), row 2
		Text clock = new Text("Countdown Clock");
		GridPane.setValignment(clock, VPos.CENTER);
		GridPane.setHalignment(clock, HPos.CENTER);
		grid.add(clock, 2, 1);

		// Textarea for name in column 1, row 3 >>>>> change to text all of them
		TextArea nameArea = new TextArea("Enter \nYour \n\n\nname");
		nameArea.setPrefHeight(150.0);
		nameArea.setWrapText(true);
		GridPane.setValignment(nameArea, VPos.CENTER);
		GridPane.setHalignment(nameArea, HPos.CENTER);
		grid.add(nameArea, 0, 2);

		Button clear = new Button("Clear");
		grid.add(clear, 0, 2);
		clear.setOnAction((ActionEvent event) -> {
			nameArea.clear();

		});

		// Textarea for points in column 2, row 3
		Label pointsArea = new Label();
		pointsArea.setPrefHeight(150.0);
		GridPane.setValignment(pointsArea, VPos.CENTER);
		GridPane.setHalignment(pointsArea, HPos.CENTER);
		grid.add(pointsArea, 1, 2);
		pointsArea.setWrapText(true);
		pointsArea.setText("You have " + point + " points");

		// Textarea for clock in column 3, row 3
		Label clockArea = new Label();
		clockArea.setPrefHeight(150.0);
		GridPane.setValignment(clockArea, VPos.CENTER);
		GridPane.setHalignment(clockArea, HPos.CENTER);

		grid.add(clockArea, 2, 2);
//		AnimationTimer timer = new MyTimer();
//        timer.start();
//        clockArea.setText(timer.toString());

		///////////////////// TIMER///////////////////////////////////

		// *****************************************************

		/////////////////////////////////////////////////////////////

		// Left label in column 1 , row 11
		Text obj1 = new Text("Object 1");
		GridPane.setValignment(name, VPos.CENTER);
		GridPane.setHalignment(name, HPos.CENTER);
		grid.add(obj1, 0, 10);

		// Right label in column 3 , row 11
		Text obj2 = new Text("Object 2");
		GridPane.setValignment(obj2, VPos.CENTER);
		GridPane.setHalignment(obj2, HPos.CENTER);
		grid.add(obj2, 2, 10);

		// Textarea for object1 in column 1, row 12
		Label obj1Area = new Label();
		obj1Area.setPrefHeight(50.0);
		obj1Area.setPrefWidth(70.0);
		GridPane.setValignment(obj1Area, VPos.CENTER);
		GridPane.setHalignment(obj1Area, HPos.CENTER);
		obj1Area.setText(object1.toString());
		grid.add(obj1Area, 0, 11);

		// Middle image in column 2 , row 12

		final ImageView imv = new ImageView(new Image(Main.class.getResourceAsStream("plus.png")));

		final HBox pictureRegion = new HBox();

		pictureRegion.getChildren().add(imv);
		grid.setHalignment(pictureRegion, HPos.CENTER);
		grid.setValignment(pictureRegion, VPos.CENTER);
		GridPane.setHalignment(imv, HPos.CENTER);
		GridPane.setValignment(imv, VPos.CENTER);
		pictureRegion.setMaxHeight(10);
		pictureRegion.setMaxWidth(10);
		grid.add(pictureRegion, 1, 11);

		// Textarea for object2 in column 3, row 12
		Label obj2Area = new Label();
		obj2Area.setPrefHeight(50.0);
		obj1Area.setPrefWidth(70.0);
		GridPane.setValignment(obj2Area, VPos.CENTER);
		GridPane.setHalignment(obj2Area, HPos.CENTER);
		obj2Area.setText(object2.toString());
		grid.add(obj2Area, 2, 11);

		// Answers area in column 0 - 5 , row 20
		Text answers = new Text("Answers area on this row");
		GridPane.setValignment(answers, VPos.CENTER);
		GridPane.setHalignment(answers, HPos.CENTER);
		answers.setText("POSSIBLE ANSWERS: \n" + "\n" + option1.toString() + "       " + option2.toString() + "       "
				+ option3.toString() + "       " + option4.toString());
		grid.add(answers, 0, 19, 4, 1); // column#, row#, column span, row span

		// Button in column 1, row 31
		ToggleButton choice1 = new ToggleButton("Choice 1");
		GridPane.setValignment(choice1, VPos.CENTER);
		GridPane.setHalignment(choice1, HPos.CENTER);
		grid.add(choice1, 0, 30);
		choice1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// linking button to choice

				System.out.println("Choice1 is pressed");
				answer = option1.toString();
				System.out.println("Answer is " + answer);
			}
		});

		// Button in column 2, row 31
		ToggleButton choice2 = new ToggleButton("Choice 2");
		GridPane.setValignment(choice2, VPos.CENTER);
		GridPane.setHalignment(choice2, HPos.CENTER);
		grid.add(choice2, 1, 30);
		choice2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// linking button to choice

				answer = option2;
				System.out.println("Choice2 is pressed");
				System.out.println("Answer is " + answer);
			}
		});

		// Button in column 3, row 31
		ToggleButton choice3 = new ToggleButton("Choice 3");
		GridPane.setValignment(choice3, VPos.CENTER);
		GridPane.setHalignment(choice3, HPos.CENTER);
		grid.add(choice3, 2, 30);
		choice3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// linking button to choice

				answer = option3;
				System.out.println("Choice3 is pressed");
				System.out.println("Answer is " + answer);
			}
		});

		// Button in column 4, row 31
		ToggleButton choice4 = new ToggleButton("Choice 4");
		GridPane.setValignment(choice4, VPos.CENTER);
		GridPane.setHalignment(choice4, HPos.CENTER);
		grid.add(choice4, 3, 30);
		choice4.setMinWidth(70.0);
		choice4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// linking button to choice

				answer = option4;
				System.out.println("Choice4 is pressed");
				System.out.println("Answer is " + answer);
			}
		});

		// Button in columns 2 -3, row 35
		Button report = new Button("Generate Report");
		GridPane.setValignment(report, VPos.CENTER);
		GridPane.setHalignment(report, HPos.CENTER);
		grid.add(report, 1, 34, 2, 1);

		return grid;
	}

	public FlowPane addFlowPane() {
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(170); // preferred width allows for two columns
		flow.setStyle("-fx-background-color: #FFFF00;");
		flow.setMaxHeight(450.0);

		return flow;
	}

	static class MyTimer extends AnimationTimer {

		@Override
		public void handle(long now) {

			doHandle();
		}

		private void doHandle() {

			opacity -= 0.01;
			lbl.opacityProperty().set(opacity);

			if (opacity <= 0) {

				stop();
				System.out.println("Animation stopped");
			}
		}
	}

}
