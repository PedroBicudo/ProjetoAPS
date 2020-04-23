package apps.learn.projetoaps.ui.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import apps.learn.projetoaps.R;
import apps.learn.projetoaps.databinding.ActivitySplashScreenBinding;
import apps.learn.projetoaps.ui.game_menu.GameMenuActivity;

public class SplashScreen extends AppCompatActivity implements SplashScreenContract.View{

    ActivitySplashScreenBinding activitySplashScreenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(activitySplashScreenBinding.getRoot());

        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(SplashScreen.this);
        splashScreenPresenter.waitAndChangeUi();
    }

    @Override
    public void openGameMenuActivity() {
        Intent intent = new Intent(SplashScreen.this, GameMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
