package apps.learn.projetoaps.ui.splash_screen;

import android.os.Handler;

public class SplashScreenPresenter implements SplashScreenContract.Presenter{

    private SplashScreen splashScreen;

    public SplashScreenPresenter(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
    }

    @Override
    public void waitAndChangeUi() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.openGameMenuActivity();
            }
        }, DEFAULT_WAIT_SECONDS);
    }
}
