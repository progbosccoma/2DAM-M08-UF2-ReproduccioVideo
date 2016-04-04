package net.infobosccoma.playvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;


/**
 * Exemple que mostra com reproduir un vídeo (de Youtube)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playVideo();
    }

    /**
     * Reprodueix el vídeo a pantalla completa
     */
    private void playVideo() {
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        // obtenir les mides de la pantalla per maximitzar la vista del video
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) videoView.getLayoutParams();
        params.width =  metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        videoView.setLayoutParams(params);


        // vincular el control de reproducció (MediaController) amb el visor (VideoView)
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath("http://redirector.googlevideo.com/videoplayback?source=youtube&fexp=9405191%2C9407610%2C9408210%2C9408522%2C9416074%2C9416126%2C9419451%2C9420452%2C9422342%2C9422596%2C9423661%2C9423662%2C9427365%2C9427902%2C9429149%2C9429165%2C9429504%2C9429585&dur=219.033&id=o-AEiQedFmS3fzZ8IBWZ_YfFX9WFFVWY3ePNhje8-lj1Xv&lmt=1426699401409748&itag=18&ip=2a03%3A8180%3A1001%3A16a%3A%3A8ee1&expire=1459295820&initcwndbps=477500&ratebypass=yes&ipbits=0&nh=IgpwcjA1LmRmdzA2KgkxMjcuMC4wLjE&sparams=dur%2Cgcr%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Csource%2Cupn%2Cexpire&upn=EknVzklcXhA&sver=3&mime=video%2Fmp4&gcr=us&signature=2AFE6B97EE1D3922D1E3C2A513E2BDFEEDE6C95D.E345A7DC688D29FCA464A785AD36F6BD20809853&mt=1459273979&pl=40&mv=m&ms=au&mm=31&mn=sn-q4fl6n7e&key=yt6&title=PROGRAMAME+OLOT+2015");
        videoView.start();
    }
}
