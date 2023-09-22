package com.example.randomaccessfiles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class musicPlayController {

    @FXML
    private ImageView arcadeImageView;
    @FXML
    private ImageView partyImageView;
    @FXML
    private ImageView fadedImageView;
    @FXML
    private ImageView calmImageView;
    @FXML
    private ImageView shapeImageView;
    @FXML
    private ImageView happierImageView;

    private Stage primaryStage; //have to be used for switching
    private MediaPlayer mediaPlayer;

    private final String[] songs = {
            "arcade",
            "party",
            "faded",
            "calm",
            "shape",
            "happier"
    };

    public void setPrimaryStage(Stage primaryStage) {  //will be used while switching
        this.primaryStage = primaryStage;
    }

    @FXML
    private void initialize() {
        arcadeImageView.setOnMouseClicked(this::onImageClicked);
        partyImageView.setOnMouseClicked(this::onImageClicked);
        fadedImageView.setOnMouseClicked(this::onImageClicked);
        calmImageView.setOnMouseClicked(this::onImageClicked);
        shapeImageView.setOnMouseClicked(this::onImageClicked);
        happierImageView.setOnMouseClicked(this::onImageClicked);
    }

    @FXML
    private void onImageClicked(MouseEvent event) {
        ImageView imageView = (ImageView) event.getSource();

        if (imageView == arcadeImageView) {
            playSong(0);
        } else if (imageView == partyImageView) {
            playSong(1);
        } else if (imageView == fadedImageView) {
            playSong(2);
        } else if (imageView == calmImageView) {
            playSong(3);
        } else if (imageView == shapeImageView) {
            playSong(4);
        } else if (imageView == happierImageView) {
            playSong(5);
        }

    }

    private void playSong(int index) {
        String songName = songs[index];
        String resourcePath = "/audio/" + songName + ".mp3";
        Media media = new Media(getClass().getResource(resourcePath).toExternalForm());


        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


    }
}

