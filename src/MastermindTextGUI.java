import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MastermindTextGUI extends Application{
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override 
	public void start(Stage mastermind) {
		mastermind.setTitle("Mastermind");
		MastermindModel model = new MastermindModel();
		MastermindController controller = new MastermindController(model);
		BorderPane window = new BorderPane();

		TextArea text1 = new TextArea();
		//text1.setEditable(false);
		text1.setPrefRowCount(12);

		TextField text2 = new TextField();
		text2.setPromptText("Type your guess (Enter to submit)");

		int guesses = 0;
		while(guesses <= 10) {
			text2.setOnAction( e-> {
					String guess = text2.getText();
					try {
						if(controller.isCorrect(guess)) {
							//System.out.println("here");

							text1.appendText("Guess is correct");
							text2.setEditable(false);
						}
						else {
							text1.appendText("Colors in the right place and right order: " + controller.getRightColorRightPlace(guess) + "\n");
							text1.appendText("Colors in the right place but wrong order: " + controller.getRightColorWrongPlace(guess)+ "\n");
						} 
					
					}
					catch(MastermindIllegalColorException color ) {
						new Alert(Alert.AlertType.ERROR, "You used the wrong color!"  + color.getMessage()).showAndWait();

					}
					catch(MastermindIllegalLengthException length) {
						new Alert(Alert.AlertType.ERROR, "You used an illegal length!" + length.getMessage()).showAndWait();

					}
			});
			guesses++;
			
		}
		//text2.setEditable(false);
        Scene scene = new Scene(window, 500, 500);

		window.setCenter(text1);
		window.setBottom(text2);

		mastermind.setScene(scene);
		mastermind.show();
		
	}
}

