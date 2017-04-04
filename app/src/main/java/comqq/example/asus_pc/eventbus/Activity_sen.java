package comqq.example.asus_pc.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by asus-pc on 2017/4/1.
 */

public class Activity_sen extends Activity {
    private Button btn_post;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen);
        btn_post= (Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });
    }
}
