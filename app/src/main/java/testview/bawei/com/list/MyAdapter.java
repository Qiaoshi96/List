package testview.bawei.com.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Administrator on 2017/12/24.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Bean> list;
    private int selectedPosition = -1;
    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view= View.inflate(context,R.layout.item,null);

            holder.textView=view.findViewById(R.id.item);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.textView.setText(list.get(i).toString());
        return view;
    }
    class ViewHolder {
        TextView textView;
    }
}
