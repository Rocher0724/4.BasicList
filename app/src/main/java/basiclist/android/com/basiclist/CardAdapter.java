package basiclist.android.com.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/** RecyclerCardView 사용을 위한 Adapter
 * Created by myPC on 2017-01-31.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {
    ArrayList<User> datas;
    // 클릭처리, 애니메이션 등 활용을 위해 시스템 자원이 필요.
    Context context;

    // 생성자를 통해 입력받은 datas와 context를 필드로 전환.
    public CardAdapter(ArrayList<User> datas, Context context) {
        this.datas = datas;
        this.context = context;

    }

    // View를 생성해서 홀더에 저장하는 역할.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }

    // listView에서 getView()함수를 대체하는 함수
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        // setOnClikListener 안에서 user.id와 user.name을 사용하기 위해서 final 선언이 필요
        final User user = datas.get(position);
        holder.txtId.setText(user.id+"");
        holder.txtName.setText(user.name);
        holder.txtAge.setText((user.age+""));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.id);
                intent.putExtra("day", user.name);

                context.startActivity(intent);
            }
        });

        // 애니메이션 선언
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.cardView.setAnimation(animation);

    }

    // 데이터 총 개수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    // 리사이클러 뷰에서 사용하는 뷰홀더
    // 이 뷰홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge;
        CardView cardView;

        public CustomViewHolder(View View) {
            super(View);
            // 생성자가 호출되는 순간(new하는 순간) 내부의 위젯을 생성해서 변수에 담아둔다.
            txtId = (TextView) View.findViewById(R.id.txtId);
            txtName = (TextView) View.findViewById(R.id.txtName);
            txtAge = (TextView) View.findViewById(R.id.txtAge);
            cardView = (CardView) View.findViewById(R.id.cardView);
        }
    }
}
