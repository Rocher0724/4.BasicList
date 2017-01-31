package basiclist.android.com.basiclist;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * ListView를 사용하여 구성한 Activity
 */
public class ListViewActivity extends AppCompatActivity {

    ListView mListViewContainer;

    String array[] = {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // 1. 리스트뷰를 가져온다
        mListViewContainer = (ListView) findViewById(R.id.listViewContainer);

        // 2. 아답터를 클래스를 사용하여 정의
        CustomAdapter adapter = new CustomAdapter(array, this);

        // 3. 리스트뷰에 아답터를 세팅한다.
        mListViewContainer.setAdapter(adapter);

        mListViewContainer.setOnItemClickListener(CustomItemClickListener);

        mListViewContainer.setOnItemLongClickListener(Long);
    }


    AdapterView.OnItemClickListener CustomItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // 1. 디테일 액티비티로 전환하기 위해 intent 생성
            Intent intent = new Intent(ListViewActivity.this, DetailActivity.class);

            // 2. 넘길 데이터를 세팅한다
            intent.putExtra("no", position+1);
            intent.putExtra("day", array[position]);

            // 3. 액티비티 호출
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener Long = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(ListViewActivity.this, "실험", Toast.LENGTH_SHORT).show();
            // false 이면 롱클릭 이후 떼었을 때 클릭이 실행 true이면 떼었을 때 클릭이 실행안됌
            return false;
        }
    };


}
