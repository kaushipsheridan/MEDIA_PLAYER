package com.example.randomaccessfiles;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class musicScreenController implements Initializable {

    @FXML
    private ImageView imageVieww;
    @FXML
    private Button previousButton;
    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button nextButton;

    private String songName;
    private int currentSongIndex = 0;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    private final String[] songs = {
            "arcade",
            "party",
            "faded",
            "calm",
            "shape",
            "happier"
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        previousButton.setOnAction(event -> onPreviousButtonClicked());
        playButton.setOnAction(event -> onPlayButtonClicked());
        pauseButton.setOnAction(event -> onPauseButtonClicked());
        nextButton.setOnAction(event -> onNextButtonClicked());

        setButtonStates();
    }

    private void setButtonStates() {
        playButton.setDisable(isPlaying);
        pauseButton.setDisable(!isPlaying);
        nextButton.setDisable(isPlaying);
        previousButton.setDisable(isPlaying);
    }

    @FXML
    private void onPreviousButtonClicked() {
        currentSongIndex--;
        if (currentSongIndex < 0) {
            currentSongIndex = songs.length - 1;
        }
        updateSong();
    }

    @FXML
    private void onNextButtonClicked() {
        currentSongIndex++;
        if (currentSongIndex >= songs.length) {
            currentSongIndex = 0;
        }
        updateSong();
    }

    @FXML
    private void updateSong() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }

    @FXML
    private void onPlayButtonClicked() {
        if (!isPlaying) {
            mediaPlayer.play();
            isPlaying = true;
        }
        setButtonStates();
    }

    @FXML
    private void onPauseButtonClicked() {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
        }
        setButtonStates();
    }

    public void setSongName(String songName) {
        this.songName = songName;
        String imagePath = songName + ".jpg";
        imageVieww.setImage(new Image(imagePath));
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.mediaPlayer.setOnEndOfMedia(this::onEndOfMedia);
    }

    private void onEndOfMedia() {
        isPlaying = false;
        setButtonStates();
    }

    public void setImage(Image image) {
        imageVieww.setImage(image);
    }
}

