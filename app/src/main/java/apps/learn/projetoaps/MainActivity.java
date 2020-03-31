package apps.learn.projetoaps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import apps.learn.projetoaps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding activityMainBinding;

    public ActivityMainBinding getActivityMainBinding() {
        return activityMainBinding;
    }

    public void setActivityMainBinding(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setActivityMainBinding(ActivityMainBinding.inflate(getLayoutInflater()));
        setContentView(this.getActivityMainBinding().getRoot());
    }


}
