package comqq.example.asus_pc.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn);
        txt = (TextView) findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Activity_sen.class);
                startActivity(intent);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FirstEvent event) {
        txt.setText(event.getMsg());
        Toast.makeText(this,"成功",Toast.LENGTH_LONG).show();
        /* Do something */
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
