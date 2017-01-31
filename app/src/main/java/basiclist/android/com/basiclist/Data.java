package basiclist.android.com.basiclist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/** 오늘 사용한 리스트뷰에서 리스트를 만들기 위해 custom한 데이터 set이다. 여러번 만들기 번거로워서 따로만들었다.
 * Created by myPC on 2017-01-31.
 */

public class Data {
    private ArrayList<User> datas;

    // arraylist와 난수생성load를 private로 선언하였기 때문에 외부에서 가져갈수 있도록 getDatas를 만들었다.
    public ArrayList<User> getDatas() {
        return datas;
    }

    // 생성자. 호출시 100개의 데이터 생성
    public Data() {
        datas = new ArrayList<>();
        load();

    }

    private void load() {
        // 특정 범위의 무작위 난수를 생성해준다.
        Random random = new Random();

        // data에 100명의 User를 생성하여 담는다
        for ( int i=0 ; i<100 ; i++) {
            User user   = new User();
            user.id     = i+1;
            user.name   = "홍길동" + user.id;
            user.age    = random.nextInt(80);

            // 난수생성 확인을 위해 log를 사용하였다.
//            Log.i("Random", "number= " + user.age);

            datas.add(user);
        }
    }




}
