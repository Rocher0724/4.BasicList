 FC_ADS_4.BasicList  <br/>
패스트캠퍼스 안드로이드 스튜디오, 프로젝트 4. ListView, RecyclerView 사용

# BasicList
리스트뷰 사용법

##  ListView + BaseAdapter
* BaseAdapter 를 커스터마이징해서 ListView 를 세팅하였다.
```
// 생성자에서 inflater를 만들어주고
LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // view를 구성하는데 사용한다.
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }
    }
```
##  ListView + holder + BaseAdapter
* list view holder를 이용한다.
```
    // 각 행에서 사용되는 위젯을 재사용하기 위한 Holder 클래스를 사용한다.
    class Holder {
        public TextView mTxtId;
        public TextView mTxtName;
        public TextView mTxtAge;
    }
```
##  RecyclerView + holder + RecyclerView.Adapter
* RecyclerView.Adapter를 커스터마이징 하여 Recycler view를 사용한다.

```
    // View를 생성해서 홀더에 저장하는 역할.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }
```
##  RecyclerView + holder + card + RecyclerView.Adapter
* xmlns 로 namespace를 정의해서 Recycler Card view를 사용한다.
* cardview 에 onclick 이벤트를 사용한다.

```
// card view에 애니메이션 효과 사용
    Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
    holder.cardView.setAnimation(animation);
```
