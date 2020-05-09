package apps.learn.projetoaps.ui.game_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.databinding.ActivityGameQuizBinding;

public class GameQuizActivity extends AppCompatActivity {

    private static final String TAG = "GameQuizActivity";
    private ActivityGameQuizBinding activityGameQuizBinding;

    public ActivityGameQuizBinding getActivityGameQuizBinding() {
        return activityGameQuizBinding;
    }

    public void setActivityGameQuizBinding(ActivityGameQuizBinding ActivityGameQuizBinding) {
        this.activityGameQuizBinding = ActivityGameQuizBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setActivityGameQuizBinding(ActivityGameQuizBinding.inflate(getLayoutInflater()));
        setContentView(this.getActivityGameQuizBinding().getRoot());

    }

}
