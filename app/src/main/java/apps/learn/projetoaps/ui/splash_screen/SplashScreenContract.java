package apps.learn.projetoaps.ui.splash_screen;

public interface SplashScreenContract {

    interface View {
        void openGameMenuActivity();
    }

    interface Presenter {
        int DEFAULT_WAIT_SECONDS = 3000;
        void waitAndChangeUi();
    }
}
