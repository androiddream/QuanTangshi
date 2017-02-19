package animalize.github.com.quantangshi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import animalize.github.com.quantangshi.Database.MyDatabaseHelper;


public class MainActivity extends AppCompatActivity {
    private Random mRand = new Random();
    private int mPoemCount = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(tb);


        mPoemCount = MyDatabaseHelper.getPoemCount(this);

        Button bt = (Button) findViewById(R.id.main_test);
        bt.setText("共" + mPoemCount + "首诗");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = mRand.nextInt(mPoemCount - 1) + 1;
                OnePoemActivity.actionStart(MainActivity.this, id);
            }
        });
    }

}