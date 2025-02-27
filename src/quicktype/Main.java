package quicktype;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import quicktype.model.GameModel;
import quicktype.util.ColorConstants;

public class Main extends Application {
    Stage stage;
    GameModel model = new GameModel(20);
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        initConfigs();

        BorderPane borderPane = new BorderPane();
        scene = new Scene(borderPane);

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.setBackground(Background.fill(ColorConstants.DT_GRAY_1));

        borderPane.setCenter(hBox);
        handleWordSwitchKeyEvents();
        stage.setScene(scene);
        stage.show();
    }

    private void handleWordSwitchKeyEvents() {
        scene.setOnKeyTyped(e -> {
            if(e.getCharacter().equals(" ")) {
                model.moveToNextWord();
            }
        });
    }

    private void initConfigs() {
        stage.setTitle("QuickType");
        stage.setHeight(800);
        stage.setWidth(1000);
    }
}
