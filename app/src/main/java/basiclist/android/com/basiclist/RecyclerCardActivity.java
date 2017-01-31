package basiclist.android.com.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * RecyclerView에 CardView를 추가하여 애니메이션을 준 Activity
 */
public class RecyclerCardActivity extends AppCompatActivity {

    ArrayList<User> datas = null;

    RecyclerView recyclerCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        // Data를 통해 리스트에 넣을 데이터 set을 생성
        Data data = new Data();
        datas = data.getDatas();

        // 1. Recycler 뷰 가져오기
        recyclerCardView = (RecyclerView) findViewById(R.id.recyclerCardView);

        // 2. 아답터 생성하기
        CardAdapter cardAdapter = new CardAdapter(datas, this);

        // 3. recycler 뷰에 아답터 세팅하기
        recyclerCardView.setAdapter(cardAdapter);

        // 4. recycler 뷰에 매니저 등록하기... ( 뷰의 모양을 결정 ex: 그리드, 일반리스트, 비대칭 그리드)
        recyclerCardView.setLayoutManager(new LinearLayoutManager(this));
    }
}
