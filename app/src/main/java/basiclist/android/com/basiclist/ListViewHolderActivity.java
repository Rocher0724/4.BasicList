package basiclist.android.com.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * ListView에서 View를 findViewById로 생성하여 갖고있는것에 대한 비용이 크기 때문에 재사용하여 listview를 구성
 */
public class ListViewHolderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();
    ListView mListViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_holder);

        // 리스트에 띄울 데이터는 Data클래스가 생성
        Data data = new Data();
        datas = data.getDatas();

        // 1. 리스트뷰 가져오기
        mListViewContainer = (ListView) findViewById(R.id.listView);

        // 2. 아답터 생성
        CustomHoldAdapter adapter = new CustomHoldAdapter(datas, this);

        // 3. 리스트뷰에 아답터 세팅
        mListViewContainer.setAdapter(adapter);

    }

    // 이번에는 따로 Class를 만들어서 두지않고 Activity안에 넣어보았다.
    class CustomHoldAdapter extends BaseAdapter {

        ArrayList<User> datas;
        LayoutInflater inflater = null;

        public CustomHoldAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;

            // 어떤 행이 화면에 보여져서 생성된 적이 있다면 재사용
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_hold_item, null);
                holder = new Holder();

                holder.mTxtId = (TextView) convertView.findViewById(R.id.txtId);
                holder.mTxtName = (TextView) convertView.findViewById(R.id.txtName);
                holder.mTxtAge = (TextView) convertView.findViewById(R.id.txtAge);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            // 사용할 데이터 instance를 arraylist에서 꺼낸다
            User user = datas.get(position);

            holder.mTxtId.setText(user.id + "");
            holder.mTxtName.setText(user.name);
            holder.mTxtAge.setText(user.age + "");

            return convertView;
        }

        // 각 행에서 사용되는 위젯을 재사용하기 위한 Holder 클래스
        class Holder {
            public TextView mTxtId;
            public TextView mTxtName;
            public TextView mTxtAge;
        }
    }
}
