package testview.bawei.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListAdapter adapter;
    private ListView listview;
    private List<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        addData();
        adapter=new ListAdapter(this);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);

    }
    private void addData() {
      list.add("A、李白");
        list.add("B、杜甫");
        list.add("C、王羲之");
        list.add("D、杜牧");
    }
    class ListAdapter extends BaseAdapter {
        private int selectedPosition = -1;// 选中的位置
        private Context context;
        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }
        public void setSelectedPosition(int position) {
            selectedPosition = position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null) {
                holder=new ViewHolder();
                convertView= LayoutInflater.from(context).inflate(R.layout.listview_item, null);
                holder.tv=(TextView) convertView.findViewById(R.id.tv);
                holder.iv=(ImageView) convertView.findViewById(R.id.iv);

                convertView.setTag(holder);
            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            String string = list.get(position);
            holder.tv.setText(string);
                if (selectedPosition==position) {
                    convertView.setSelected(true);
                    convertView.setPressed(true);
     convertView.setBackgroundColor(Color.parseColor("#0097e0"));
                    holder.iv.setImageResource(R.mipmap.ic_launcher_round);
                }else{
                    convertView.setSelected(false);
                    convertView.setPressed(false);
     convertView.setBackgroundColor(Color.parseColor("#e4ebf1"));
                    holder.iv.setImageResource(R.mipmap.ic_launcher);
                }
            return convertView;
        }
        class ViewHolder{
            TextView tv;
            ImageView iv;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.setSelectedPosition(position);
        adapter.notifyDataSetInvalidated();
    }
}
