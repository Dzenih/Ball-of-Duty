package application.gui;

import application.communication.GameClient;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUI extends Application
{

    public static GameClient gameManager;
    private static int windowWidth = 1280;
    private static int windowHeight = 720;

    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * Gets the scenes relative location. The relative location is based on how the scene's is located relative to the operating system.
     * 
     * @param The
     *            stage of which scene to get the relative location.
     * @return The relative location of the scene. The relative location is based on how the scene's is located relative to the operating
     *         system.
     */
    private Point2D getRelativeSceneLocation(Stage stage)
    {
        return new Point2D(stage.getX() + stage.getScene().getX(), stage.getY() + stage.getScene().getY());
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle("Ball of Duty");
        theStage.setHeight(windowHeight);
        theStage.setWidth(windowWidth);
        theStage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            public void handle(WindowEvent we)
            {
                gameManager.quitGame();
                System.exit(0);
            }
        });

        BorderPane startMenuRoot = new BorderPane();
        Scene startMenu = new Scene(startMenuRoot);

        BorderPane gameBox = new BorderPane();
        Scene gameScene = new Scene(gameBox);

        BorderPane createAccountRoot = new BorderPane();
        BorderPane lohInRoot = new BorderPane();

        theStage.setScene(startMenu);

        gameManager = new GameClient(getRelativeSceneLocation(theStage));
        theStage.xProperty().addListener(e ->
        {
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
        });
        theStage.yProperty().addListener(e ->
        {
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
        });
        gameScene.xProperty().addListener(e ->
        {
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
        });
        gameScene.yProperty().addListener(e ->
        {
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
        });
        Image image = new Image("images/frontpage.png");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        startMenuRoot.setBackground(background);

        Label lblNickname = new Label("Nickname:");
        TextField tfNickname = new TextField();
        Button loginStart = new Button("Log in");
        Button createStart = new Button("Create Account");
        theStage.getIcons().add(new Image("images/ball_red.png"));
        VBox mainButtonBox = new VBox();
        Button joinBtn = new Button("Join game");
        
        Button viewLB = new Button("Leaderboard");
        viewLB.setPrefSize(150, 50);
        viewLB.setId("viewLB");
        viewLB.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
        
        BorderPane lbBorder = new BorderPane();
        VBox lbBox = new VBox();
        Scene lbScene = new Scene(lbBorder);
        
        Button lbBack = new Button("Start menu");
        lbBox.getChildren().add(lbBack);
        lbBorder.setLeft(lbBox);
        lbBack.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
        
        viewLB.setOnAction(ActionEvent ->
        {
            theStage.setScene(lbScene);
            
            
            lbBack.setOnAction(ActionEvent1 ->
            {
                theStage.setScene(startMenu);
                startMenuRoot.setLeft(mainButtonBox);
                BorderPane.setMargin(mainButtonBox, new Insets(350, 0, 0, 150));
            });
        });
        

        joinBtn.setPrefSize(150, 50);
        tfNickname.setPrefSize(150, 20);
        joinBtn.setId("joinBtn");
        joinBtn.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
        lblNickname.setId("lblNickname");
        lblNickname.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
        createStart.setId("CreateStart");
        createStart.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
        loginStart.setId("loginStart");
        loginStart.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");

        joinBtn.setOnAction(ActionEvent ->
        {
            theStage.setScene(gameScene);
            gameManager.joinAsGuest(gameBox, tfNickname.getText());
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
            gameBox.requestFocus();

        });
        tfNickname.setOnAction(ActionEvent ->
        {
            theStage.setScene(gameScene);
            gameManager.joinAsGuest(gameBox, tfNickname.getText());
            gameManager.setSceneRelativeLocation(getRelativeSceneLocation(theStage));
            gameBox.requestFocus();

        });

        mainButtonBox.getChildren().add(lblNickname);
        mainButtonBox.getChildren().add(tfNickname);
        mainButtonBox.getChildren().add(joinBtn);
        mainButtonBox.getChildren().add(loginStart);
        mainButtonBox.getChildren().add(createStart);
        mainButtonBox.getChildren().add(viewLB);
        startMenuRoot.setLeft(mainButtonBox);

        createStart.setOnAction(ActionEvent ->
        {
            VBox createAccountButtonBox = new VBox();
            Label lblNickname2 = new Label("Nickname:");
            TextField tfNickname2 = new TextField();
            Label lblUserName = new Label("Name:");
            TextField tfUserName = new TextField();
            Label lblPassword = new Label("Password:");
            Label lblPassword2 = new Label("Repeat password:");
            PasswordField pf = new PasswordField();
            PasswordField pf2 = new PasswordField();
            Button createBtn = new Button("Create account");
            Button back = new Button("Start menu");

            createBtn.setId("join-yyyyy");
            createBtn.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            lblUserName.setId("join-game");
            lblUserName.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            lblPassword.setId("join-game");
            lblPassword.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            lblPassword2.setId("join-game");
            lblPassword2.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            back.setId("join-game");
            back.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");

            createAccountButtonBox.getChildren().add(lblNickname2);
            createAccountButtonBox.getChildren().add(tfNickname2);
            createAccountButtonBox.getChildren().add(lblUserName);
            createAccountButtonBox.getChildren().add(tfUserName);
            createAccountButtonBox.getChildren().add(lblPassword);
            createAccountButtonBox.getChildren().add(pf);
            createAccountButtonBox.getChildren().add(lblPassword2);
            createAccountButtonBox.getChildren().add(pf2);
            createAccountButtonBox.getChildren().add(createBtn);
            createAccountButtonBox.getChildren().add(back);

            startMenuRoot.setLeft(createAccountButtonBox);
            BorderPane.setMargin(createAccountButtonBox, new Insets(350, 0, 0, 150));

            createBtn.setOnAction(ActionEvent1 ->
            {
                gameManager.createAccount(tfUserName.getText(), tfNickname2.getText(), pf.getText().toCharArray(), pf2.getText().toCharArray());
                startMenuRoot.setLeft(mainButtonBox);
                BorderPane.setMargin(mainButtonBox, new Insets(350, 0, 0, 150));
            });

            back.setOnAction(ActionEvent1 ->
            {
                startMenuRoot.setLeft(mainButtonBox);
                BorderPane.setMargin(mainButtonBox, new Insets(350, 0, 0, 150));
            });
        });

        loginStart.setOnAction(ActionEvent ->
        {
            VBox loginButtonBox = new VBox();
            Button logInBtn = new Button("Log in");
            Label lblUserName2 = new Label("Name:");
            TextField tfUserName2 = new TextField();
            Label lblPassword2 = new Label("Password:");
            PasswordField pf3 = new PasswordField();
            Button back2 = new Button("Start Menu");

            logInBtn.setId("join-game");
            logInBtn.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            back2.setId("join-game");
            back2.setStyle("-fx-font: 20 arial; -fx-base: #ff0717;");
            
            loginButtonBox.getChildren().add(lblUserName2);
            loginButtonBox.getChildren().add(tfUserName2);
            loginButtonBox.getChildren().add(lblPassword2);
            loginButtonBox.getChildren().add(pf3);
            loginButtonBox.getChildren().add(logInBtn);
            loginButtonBox.getChildren().add(back2);
            
            startMenuRoot.setLeft(loginButtonBox);
            BorderPane.setMargin(loginButtonBox, new Insets(350, 0, 0, 150));
            
            logInBtn.setOnAction(ActionEvent1 ->
            {
                //TODO login
            });

            back2.setOnAction(ActionEvent1 ->
            {
                startMenuRoot.setLeft(mainButtonBox);
                BorderPane.setMargin(mainButtonBox, new Insets(350, 0, 0, 150));
            });
        });

        BorderPane.setMargin(mainButtonBox, new Insets(350, 0, 0, 150));

        Button quitBtn = new Button("Quit game");
        quitBtn.setPrefSize(80, 40);
        quitBtn.setId("quit-game");

        quitBtn.setOnAction(ActionEvent ->
        {
            gameManager.quitGame();
            theStage.setScene(startMenu);
        });
        Canvas canvas = new Canvas(1100, 660);

        gameBox.setCenter(canvas);
        gameBox.setBottom(quitBtn);
        BorderPane.setAlignment(quitBtn, Pos.BASELINE_LEFT);
        theStage.show();
    }
}
