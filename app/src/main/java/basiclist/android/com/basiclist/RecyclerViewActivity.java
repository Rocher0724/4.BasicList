package basiclist.android.com.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Recycler View를 사용하여 구성한 Activity
 */
public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<User> datas = null;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Data data = new Data();
        datas = data.getDatas();

        // 1. Recycler 뷰 가져오기
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 2. 아답터 생성하기
        RecyclerCustomAdapter rca = new RecyclerCustomAdapter(datas, R.layout.list_hold_item);

        // 3. recycler 뷰에 아답터 세팅하기
        recyclerView.setAdapter(rca);

        // 4. recycler 뷰에 매니저 등록하기... ( 뷰의 모양을 결정 ex: 그리드, 일반리스트, 비대칭 그리드)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
