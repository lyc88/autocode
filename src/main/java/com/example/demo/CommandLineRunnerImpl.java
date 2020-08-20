package com.example.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: lyc
 * @date: 2020/8/20 16:00
 * @describe
 */
@Component
public class CommandLineRunnerImpl extends Application implements CommandLineRunner  {
    @Override
    public void run(String... args) throws Exception {
      launch(args);
    }

    @Override
    public void start(final Stage stage) {
        stage.setWidth(400);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());


        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);

        webEngine.getLoadWorker().stateProperty()
                .addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {

                        if (newState == Worker.State.SUCCEEDED) {
                            stage.setTitle(webEngine.getLocation());
                        }

                    }
                });
        webEngine.load("http://127.0.0.1:8666/index.html");

        scene.setRoot(scrollPane);

        stage.setScene(scene);
        stage.show();
    }
}
