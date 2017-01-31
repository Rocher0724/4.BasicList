package basiclist.android.com.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * listView에서 view를 클릭하였을 때 실행되는 Activity.
 * 클릭한 view에 적혀있는 자료 (리스트번호"no", 요일"day")를 intent가 전달해준다.
 */
public class DetailActivity extends AppCompatActivity {

    TextView mTxtNumber, mTxtDayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTxtNumber = (TextView) findViewById(R.id.txtNumber);
        mTxtDayResult = (TextView) findViewById(R.id.txtDayResult);

        // 1. 리스트에서 넘어온 인텐트를 꺼낸다.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 2. 넘어온 인텐트에서 특정 값을 타입에 맞춰 꺼낸다.
        int no = bundle.getInt("no");
        String day = bundle.getString("day");

        // 3. 꺼낸 값을 위젯에 세팅한다.
        mTxtNumber.setText((no + ""));
        mTxtDayResult.setText(day);


    }
}
