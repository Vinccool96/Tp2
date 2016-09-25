package code_formes;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class VueForme {

	private boolean start = true;

	private ActionButton ecouteurButton = new ActionButton();
	private ActionForme ecouteurForme = new ActionForme();

	private Button buttonGenerer;
	private Button buttonReinitialiser;
	private Button buttonQuitter;
	private Scene scene;
	private BorderPane root;
	private HBox hbBottom;
	private ListView<TextFlow> listFormes;
	private ColorPicker theChosenOne;
	private CheckBox chkBxEffet;
	private TextField txtFldPositionX;
	private TextField txtFldPositionY;
	private TextField txtFldCoteA;
	private TextField txtFldCoteB;
	private TextField txtFldCoteC;
	private Slider io;

	private Label lbA;
	private Label lbB;

	public VueForme() {
		construireInterface();

	}

	public Button getButtonGenerer() {
		return buttonGenerer;
	}

	public void setButtonGenerer(Button buttonGenerer) {
		this.buttonGenerer = buttonGenerer;
	}

	public Button getButtonReinitialiser() {
		return buttonReinitialiser;
	}

	public void setButtonReinitialiser(Button buttonReinitialiser) {
		this.buttonReinitialiser = buttonReinitialiser;
	}

	public Button getButtonQuitter() {
		return buttonQuitter;
	}

	public void setButtonQuitter(Button buttonQuitter) {
		this.buttonQuitter = buttonQuitter;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public HBox getHbBottom() {
		return hbBottom;
	}

	public void setHbBottom(HBox hbBottom) {
		this.hbBottom = hbBottom;
	}

	public StackPane addCenter() {
		StackPane pn = new StackPane();

		pn.setPrefSize(500, 500);
		pn.getStyleClass().add("pn");
		Circle c = new Circle(100);

		c.centerXProperty().bind(pn.widthProperty().divide(2));
		c.centerYProperty().bind(pn.heightProperty().divide(2));
		c.setFill(Paint.valueOf("RED"));
		pn.getStyleClass().add("stack_pane");
		pn.getChildren().add(c);

		return pn;
	}

	public HBox addBottom() {

		buttonGenerer = new Button("Générer");
		buttonReinitialiser = new Button("Réinitialiser");
		buttonQuitter = new Button("Quitter");

		buttonQuitter.setOnMouseClicked(ecouteurButton);

		hbBottom = new HBox();
		hbBottom.setPadding(new Insets(10, 10, 10, 10));
		hbBottom.setSpacing(60);
		hbBottom.getChildren().addAll(buttonGenerer, buttonReinitialiser, buttonQuitter);

		return hbBottom;
	}

	public VBox addRight() {
		VBox vb = new VBox();
		vb.setSpacing(10);
		VBox vbFormes = addVBoxFormes();
		VBox vbCouleur = addVBoxCouleur();
		VBox vbEffet = addVBoxEffet();
		HBox hbPositions = addHBoxPositions();
		HBox hbCotes = addHBoxCotes();
		VBox vbOpacite = addVBoxOpacite();

		vb.getChildren().addAll(vbFormes, vbCouleur, vbEffet, hbPositions, hbCotes, vbOpacite);

		VBox.setMargin(vbFormes, new Insets(5));
		VBox.setMargin(vbCouleur, new Insets(5));
		VBox.setMargin(vbEffet, new Insets(5));
		VBox.setMargin(hbPositions, new Insets(5));
		VBox.setMargin(hbCotes, new Insets(5));
		VBox.setMargin(vbOpacite, new Insets(5));

		return vb;
	}

	private VBox addVBoxFormes() {
		VBox vb = new VBox();

		Label lb = new Label("Formes");

		Text txt1 = new Text("Ovale");
		Text txt2 = new Text("Rectangle");
		Text txt3 = new Text("Triangle");
		Text txt4 = new Text("Ligne");

		TextFlow lb1 = new TextFlow(txt1);
		TextFlow tf2 = new TextFlow(txt2);
		TextFlow tf3 = new TextFlow(txt3);
		TextFlow tf4 = new TextFlow(txt4);

		listFormes = new ListView<>();
		ObservableList<TextFlow> ol = FXCollections.observableArrayList(lb1, tf2, tf3, tf4);

		listFormes.setItems(ol);
		listFormes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		listFormes.getItems().get(0).setOnMouseClicked(ecouteurForme);
		listFormes.getItems().get(1).setOnMouseClicked(ecouteurForme);
		listFormes.getItems().get(2).setOnMouseClicked(ecouteurForme);
		listFormes.getItems().get(3).setOnMouseClicked(ecouteurForme);
		listFormes.setPrefHeight(150);
		listFormes.setMinWidth(120);

		vb.getChildren().addAll(lb, listFormes);

		return vb;
	}

	private VBox addVBoxCouleur() {
		VBox vb = new VBox();

		Label lb = new Label("Couleur");

		theChosenOne = new ColorPicker(Color.ORANGE);

		vb.getChildren().addAll(lb, theChosenOne);
		return vb;
	}

	private VBox addVBoxEffet() {
		VBox vb = new VBox();

		Label lb = new Label("Effet");

		chkBxEffet = new CheckBox();

		vb.getChildren().addAll(lb, chkBxEffet);

		return vb;
	}

	private VBox addVBoxPositionX() {
		VBox vb = new VBox();

		Label lb = new Label("PositionX");

		txtFldPositionX = new TextField();
		txtFldPositionX.setPrefWidth(10);

		vb.getChildren().addAll(lb, txtFldPositionX);

		return vb;

	}

	private VBox addVBoxPositionY() {
		VBox vb = new VBox();

		Label lb = new Label("PositionY");

		txtFldPositionY = new TextField();
		txtFldPositionY.setPrefWidth(10);

		vb.getChildren().addAll(lb, txtFldPositionY);

		return vb;

	}

	private HBox addHBoxPositions() {
		HBox hb = new HBox(10);

		hb.getChildren().addAll(addVBoxPositionX(), addVBoxPositionY());

		return hb;
	}

	private VBox addVBoxCoteA() {
		VBox vb = new VBox();

		lbA = new Label("Côté A");

		txtFldCoteA = new TextField();
		txtFldCoteA.setPrefWidth(10);

		vb.getChildren().addAll(lbA, txtFldCoteA);

		return vb;

	}

	private VBox addVBoxCoteB() {
		VBox vb = new VBox();

		lbB = new Label("Côté B");
		txtFldCoteB = new TextField();
		txtFldCoteB.setPrefWidth(10);

		vb.getChildren().addAll(lbB, txtFldCoteB);

		return vb;

	}

	private VBox addVBoxCoteC() {
		VBox vb = new VBox();

		Label lbC = new Label("Côté C");

		txtFldCoteC = new TextField();
		txtFldCoteC.setPrefWidth(10);

		vb.getChildren().addAll(lbC, txtFldCoteC);

		return vb;

	}

	private HBox addHBoxCotes() {
		HBox hb = new HBox(10);

		hb.getChildren().addAll(addVBoxCoteA(), addVBoxCoteB(), addVBoxCoteC());

		return hb;
	}

	private VBox addVBoxOpacite() {
		VBox vb = new VBox();

		Label lb = new Label("Opacité");

		io = new Slider();

		vb.getChildren().addAll(lb, io);

		return vb;

	}

	private void construireInterface() {
		root = new BorderPane();
		root.setRight(addRight());
		root.setBottom(addBottom());
		root.setCenter(addCenter());

		BorderPane.setMargin(root.getCenter(), new Insets(25));
		scene = new Scene(root);
		scene.getStylesheets().setAll("/styles/style_forme.css");

	}

	public class ActionButton implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// FIXME Auto-generated method stub
			if (event.getSource() == buttonQuitter) {
				Platform.exit();
			}
		}
	}

	public class ActionForme implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			if (start) {
				start = false;
				theChosenOne.setDisable(false);
				txtFldPositionX.setDisable(false);
				txtFldPositionY.setDisable(false);
				chkBxEffet.setDisable(false);
				io.setDisable(false);
			}

			if (event.getSource() == listFormes.getItems().get(0)) {
				lbA.setText("Largeur");
				lbB.setText("Hauteur");
				txtFldCoteA.setDisable(false);
				txtFldCoteB.setDisable(false);
				txtFldCoteC.setDisable(true);
				System.out.println("Ovale");

			} else if (event.getSource() == listFormes.getItems().get(1)) {
				lbA.setText("Largeur");
				lbB.setText("Hauteur");
				txtFldCoteA.setDisable(false);
				txtFldCoteB.setDisable(false);
				txtFldCoteC.setDisable(true);
				System.out.println("Rectangle");
			} else if (event.getSource() == listFormes.getItems().get(2)) {
				lbA.setText("Côté A");
				lbB.setText("Côté B");
				txtFldCoteA.setDisable(false);
				txtFldCoteB.setDisable(false);
				txtFldCoteC.setDisable(false);
				System.out.println("Triangle");
			} else if (event.getSource() == listFormes.getItems().get(3)) {
				System.out.println("Ligne");
			}

		}
	}

	public ListView<TextFlow> getListFormes() {
		return listFormes;
	}

	public ColorPicker getTheChosenOne() {
		return theChosenOne;
	}

	public CheckBox getChkBxEffet() {
		return chkBxEffet;
	}

	public void setChkBxEffet(CheckBox chkBxEffet) {
		this.chkBxEffet = chkBxEffet;
	}

	public TextField getTxtFldPositionX() {
		return txtFldPositionX;
	}

	public TextField getTxtFldPositionY() {
		return txtFldPositionY;
	}

	public TextField getTxtFldCoteA() {
		return txtFldCoteA;
	}

	public TextField getTxtFldCoteB() {
		return txtFldCoteB;
	}

	public TextField getTxtFldCoteC() {
		return txtFldCoteC;
	}

	public Slider getIo() {
		return io;
	}

	public void setIo(Slider io) {
		this.io = io;
	}

}