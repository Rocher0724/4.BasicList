package basiclist.android.com.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * main Activity에는 4개의 버튼으로 각각의 view를 실험해 볼수 있도록 하였다.
 */
public class MainActivity extends AppCompatActivity {
    Button mListViewbtn;
    Button mListViewHolderbtn;
    Button mRecyclerViewbtn;
    Button mRecyclerCardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewbtn = (Button) findViewById(R.id.listViewBtn);
        mListViewHolderbtn = (Button) findViewById(R.id.listViewHolderBtn);
        mRecyclerViewbtn = (Button) findViewById(R.id.recyclerViewBtn);
        mRecyclerCardBtn = (Button) findViewById(R.id.recyclerCardBtn);



        mListViewbtn.setOnClickListener(CustomClickListener);
        mListViewHolderbtn.setOnClickListener(CustomClickListener);
        mRecyclerViewbtn.setOnClickListener(CustomClickListener);
        mRecyclerCardBtn.setOnClickListener(CustomClickListener);

    }

    Intent intent = null;
    View.OnClickListener CustomClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.listViewBtn:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.listViewHolderBtn:
                    intent = new Intent(MainActivity.this, ListViewHolderActivity.class);
                    break;
                case R.id.recyclerViewBtn:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.recyclerCardBtn:
                    intent = new Intent(MainActivity.this, RecyclerCardActivity.class);
                    break;

            }
            startActivity(intent);
        }
    };
}
