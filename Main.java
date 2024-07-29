import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Game game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        game = new Game();
        game.start();

        VBox root = new VBox();
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        TextField inputField = new TextField();
        Button submitButton = new Button("Submit");

        root.getChildren().addAll(outputArea, inputField, submitButton);

        submitButton.setOnAction(e -> handleCommand(inputField.getText(), outputArea));
        inputField.setOnAction(e -> handleCommand(inputField.getText(), outputArea));

        primaryStage.setTitle("Text Adventure Game");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        // Show the initial game status
        updateOutput(outputArea, getGameStatus());
    }

    private void handleCommand(String input, TextArea outputArea) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        game.executeCommand(command, argument);
        updateOutput(outputArea, getGameStatus());
    }

    private void updateOutput(TextArea outputArea, String message) {
        outputArea.appendText(message + "\n");
    }

    private String getGameStatus() {
        StringBuilder status = new StringBuilder();

        status.append("Current Location: ").append(game.getPlayer().getCurrentLocation().getName()).append("\n");
        status.append("Available Locations: ").append(String.join(", ", game.getAvailableLocations())).append("\n");
        status.append("Available Commands: ").append(String.join(", ", game.getAvailableCommands())).append("\n");

        return status.toString();
    }
}
