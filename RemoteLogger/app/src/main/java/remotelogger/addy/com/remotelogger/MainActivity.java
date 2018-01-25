package remotelogger.addy.com.remotelogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.remotelogger.RemoteLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RemoteLogger.init(MainActivity.this.getApplicationContext());

            }
        }).start();

        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0 ; i< 100 ; i++)
                        {
                            RemoteLogger.issue("New","Test issue",5);
                        }
                    }
                }).start();



            }
        });
    }


}
