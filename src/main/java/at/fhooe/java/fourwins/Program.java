package at.fhooe.java.fourwins;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Program extends Application {
	
	private final Label status = new Label("Player one has to choose:");
	
	private final Button column1 = new Button("⬇");
	private final Button column2 = new Button("⬇");
	private final Button column3 = new Button("⬇");
	private final Button column4 = new Button("⬇");
	private final Button column5 = new Button("⬇");
	private final Button column6 = new Button("⬇");
	private final Button column7 = new Button("⬇");
	
	private final Rotate cameraRotateY = new Rotate(0, Rotate.Y_AXIS);
	private final Rotate cameraRotateX = new Rotate(-22.5, Rotate.X_AXIS);
	private final Translate cameraTranslate = new Translate(0,  0, -100);
	private final PerspectiveCamera camera = new PerspectiveCamera(true);
	
	private final Group content = new Group();
	private final Group root = new Group(camera, content);
	private final SubScene subScene = new SubScene(root, 100, 100);
	private final Pane pane = new Pane(subScene);
	
	private final Button reset = new Button("Reset");

	private final GridPane grid = new GridPane();
	
	private final Scene scene = new Scene(grid);

	@Override
	public void start(Stage stage) throws Exception {
		column1.setMaxWidth(Double.MAX_VALUE);
		column1.setOnAction(event -> {
			// TODO
		});
		column2.setMaxWidth(Double.MAX_VALUE);
		column2.setOnAction(event -> {
			// TODO
		});
		column3.setMaxWidth(Double.MAX_VALUE);
		column3.setOnAction(event -> {
			// TODO
		});
		column4.setMaxWidth(Double.MAX_VALUE);
		column4.setOnAction(event -> {
			// TODO
		});
		column5.setMaxWidth(Double.MAX_VALUE);
		column5.setOnAction(event -> {
			// TODO
		});
		column6.setMaxWidth(Double.MAX_VALUE);
		column6.setOnAction(event -> {
			// TODO
		});
		column7.setMaxWidth(Double.MAX_VALUE);
		column7.setOnAction(event -> {
			// TODO
		});
		
		camera.setNearClip(0.1);
		camera.setFarClip(1000.0);
		camera.getTransforms().add(cameraRotateY);
		camera.getTransforms().add(cameraRotateX);
		camera.getTransforms().add(cameraTranslate);
		
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 6; y++) {
				PhongMaterial material = new PhongMaterial(Color.AQUAMARINE);
				
				Translate translate = new Translate((x - 3) * 8, (y - 2.5) * 8, 0);
				
				Box box = new Box(5, 5, 5);
				box.setMaterial(material);
				box.setDrawMode(Math.random() > 0.5 ? DrawMode.LINE : DrawMode.FILL);
				box.setDepthTest(DepthTest.ENABLE);
				box.getTransforms().add(translate);
				
				content.getChildren().add(box);
			}
		}
		
		subScene.setFill(Color.GRAY);
		subScene.setCamera(camera);
		subScene.setDepthTest(DepthTest.ENABLE);
		subScene.widthProperty().bind(pane.widthProperty());
		subScene.heightProperty().bind(pane.heightProperty());
		
		pane.setMaxWidth(Double.MAX_VALUE);
		pane.setMaxHeight(Double.MAX_VALUE);
		
		reset.setMaxWidth(Double.MAX_VALUE);
		reset.setOnAction(event -> {
			// TODO
		});
		
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		grid.getColumnConstraints().add(createColumnConstraints());
		
		grid.getRowConstraints().add(createRowConstraints(Priority.NEVER));
		grid.getRowConstraints().add(createRowConstraints(Priority.NEVER));
		grid.getRowConstraints().add(createRowConstraints(Priority.ALWAYS));
		grid.getRowConstraints().add(createRowConstraints(Priority.NEVER));
		
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		//stageRoot.setGridLinesVisible(true);
		grid.add(status, 0, 0, 7, 1);
		grid.add(column1, 0, 1);
		grid.add(column2, 1, 1);
		grid.add(column3, 2, 1);
		grid.add(column4, 3, 1);
		grid.add(column5, 4, 1);
		grid.add(column6, 5, 1);
		grid.add(column7, 6, 1);
		grid.add(pane, 0, 2, 7, 1);
		grid.add(reset, 0, 3, 7, 1);
		
		stage.setScene(scene);
		stage.setTitle("Final Project Hackenberg");
		stage.setMaximized(true);
		stage.show();
	}
	
	private ColumnConstraints createColumnConstraints() {
		ColumnConstraints result = new ColumnConstraints();
		result.setFillWidth(true);
		result.setPercentWidth(100/7.);
		result.setHgrow(Priority.ALWAYS);
		result.setHalignment(HPos.CENTER);
		return result;
	}
	
	private RowConstraints createRowConstraints(Priority vgrow) {
		RowConstraints result = new RowConstraints();
		result.setFillHeight(true);
		result.setVgrow(vgrow);
		result.setValignment(VPos.CENTER);
		return result;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
