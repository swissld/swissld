package io.github.swissld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FX extends Application
	{
	@Override
	public void start(Stage primaryStage)
		{
		primaryStage.setTitle("Hello World!");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		/*
		btn.setOnAction(new EventHandler<ActionEvent>()
			{
			@Override
			public void handle(ActionEvent event)
				{
				System.out.println("Hello World!");
				}
			});
		*/
		btn.setOnAction(sddd -> System.out.println("Hello World!"));

		AnchorPane anchorPane = new AnchorPane();
		ObservableList<String> names = FXCollections.observableArrayList(
          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
 //ListView<String> listView = new ListView<String>(names);
     // List should stretch as anchorPane is resized
     ListView<String> list = new ListView<String>(names);
     AnchorPane.setTopAnchor(list, 10.0);
     AnchorPane.setLeftAnchor(list, 10.0);
     AnchorPane.setRightAnchor(list, 65.0);
     // Button will float on right edge
     Button button = new Button("Add");
     AnchorPane.setTopAnchor(button, 10.0);
     AnchorPane.setRightAnchor(button, 10.0);
     anchorPane.getChildren().addAll(list, button);

	 HBox hbox = new HBox();
     Button button1 = new Button("Add");
     Button button2 = new Button("Remove");
     HBox.setHgrow(button1, Priority.ALWAYS);
     HBox.setHgrow(button2, Priority.ALWAYS);
     button1.setMaxWidth(Double.MAX_VALUE);
	 button1.setMinWidth(120d);
     button2.setMaxWidth(Double.MAX_VALUE);
     hbox.getChildren().addAll(button1, button2);

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(hbox, 300, 250));
		primaryStage.show();
		}

	public static void main(String[] args)
		{
		launch(args);
		}
	}
