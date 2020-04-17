package apps.learn.projetoaps.ui.game_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import apps.learn.projetoaps.databinding.ActivityGameMenuBinding;

public class GameMenuActivity extends AppCompatActivity implements GameMenuContract.View {

    private ActivityGameMenuBinding activityGameMenuBinding;

    public ActivityGameMenuBinding getActivityGameMenuBinding() {
        return activityGameMenuBinding;
    }

    public void setActivityGameMenuBinding(ActivityGameMenuBinding activityGameMenuBinding) {
        this.activityGameMenuBinding = activityGameMenuBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGameMenuBinding = ActivityGameMenuBinding.inflate(getLayoutInflater());
        setContentView(activityGameMenuBinding.getRoot());
    }

    @Override
    public void hideStartButton() {
        activityGameMenuBinding.startGame.setVisibility(View.GONE);

    }

    @Override
    public void showProgressBar() {
        activityGameMenuBinding.progressBar.setVisibility(View.VISIBLE);
    }

}
