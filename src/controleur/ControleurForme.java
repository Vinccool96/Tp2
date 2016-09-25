package controleur;

import code_formes.VueForme;
import modele.FormesFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControleurForme extends Application {
	private VueForme vf;
	public FormesFactory frmFact;
	private boolean started = false;
	private ActionStart start = new ActionStart();

	@Override
	public void start(Stage stage) {
		vf = new VueForme();
		stage.setScene(vf.getScene());
		stage.setTitle("Dessin de formes");

		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, start);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public class ActionStart implements EventHandler<WindowEvent> {

		@Override
		public void handle(WindowEvent event) {
			if (!started) {
				vf.getTheChosenOne().setDisable(true);
				vf.getChkBxEffet().setDisable(true);
				vf.getTxtFldPositionX().setDisable(true);
				vf.getTxtFldPositionY().setDisable(true);
				vf.getTxtFldCoteA().setDisable(true);
				vf.getTxtFldCoteB().setDisable(true);
				vf.getTxtFldCoteC().setDisable(true);
				vf.getIo().setDisable(true);
			}
		}
	}
}