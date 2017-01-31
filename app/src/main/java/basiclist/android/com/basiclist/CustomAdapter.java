package basiclist.android.com.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/** ListView 사용을 위한 Adapter
 * Created by myPC on 2017-01-31.
 */

    // ListView 사용을 위한 adapter 세팅에는 BaseAdapter를 상속받아야함 -> 구현해야하는 메소드가 있음
public class CustomAdapter extends BaseAdapter {

    // Layout을 객체로 변환해서 사용해야 하기 때문에 inflater를 사용
    LayoutInflater inflater = null;
    String datas[];

    public CustomAdapter(String datas[], Context context) { // 컨텍스트는 시스템 자원을 활용할수 있는 자원이 많이 정의되어있는 객체

        // getView에서 사용할 xml 레이아웃을 객체로 변환해 주는 inflater을 가져온다.
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas = datas;
   }

    /**
     * 사용하는 데이터의 총 개수
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }

    /**
     * 선택된 리스트 아이템
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**
     * 아이템의 인덱스값
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    // 리스트아답타에서 뷰는 한 행 단위이다.
    // 한 행 단위를 개발자가 직접 만들어서 시스템에 넘겨줘야 한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 커스텀 아답타에서 아이템리스트.xml을 세팅해서 넘겨주기

        // 이렇게 하는방법도 있지만 view를 메모리에 가지고 있기 때문에 자료가 많아지면 out of momery가 될수 있다. 때문에 아래 방법으로 한다.

//        // 1. 한 행에 해당하는 레이아웃 xml을 뷰객체로 만들어준다.
//        View view = inflater.inflate(R.layout.list_item, null);
//
//        // 2. 만들어진 뷰 객체를 통해서 findViewById를 사용한다.
//        TextView txtNo = (TextView) view.findViewById(R.id.txtNo);
//        TextView txtDay = (TextView) view.findViewById(R.id.txtDay);
//
//        // 3. inflate 된 뷰의 위젯에 값을 세팅한다.
//        txtNo.setText( (position + 1) + "" ) ;
//        txtDay.setText(datas[position]);
//        return view;

        // 화면에서 빠진 행을 새로 세팅되는 행을 구성하는데 사용된다.

        // 1. 한 행에 해당하는 레이아웃 xml을 뷰객체로 만들어준다.
        if(convertView == null) { //한번 화면에 세팅됐던 행은 convertView에 담겨져서 돌아온다

            convertView = inflater.inflate(R.layout.list_item, null);
        }

        // 2. 만들어진 뷰 객체를 통해서 findViewById를 사용한다.
        TextView txtNo = (TextView) convertView.findViewById(R.id.txtAge);
        TextView txtDay = (TextView) convertView.findViewById(R.id.txtName);

        // 3. inflate 된 뷰의 위젯에 값을 세팅한다.
        txtNo.setText((position + 1) + "");
        txtDay.setText(datas[position]);



        return convertView;
    }
}
