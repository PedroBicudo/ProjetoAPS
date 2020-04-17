package apps.learn.projetoaps.ui.game_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import apps.learn.projetoaps.databinding.ActivityGameMenuBinding;

public class GameMenuActivity extends AppCompatActivity {

    private ActivityGameMenuBinding activityGameMenuBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGameMenuBinding = ActivityGameMenuBinding.inflate(getLayoutInflater());
        setContentView(activityGameMenuBinding.getRoot());
    }

}
