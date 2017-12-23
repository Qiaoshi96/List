package testview.bawei.com.list;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Bean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
       Bean bean= new Bean("A、李白",false);
        Bean bean1= new Bean("B、杜甫",false);
        Bean bean2= new Bean("C、王羲之",false);
        Bean bean3= new Bean("D、王维",false);
        list.add(bean);  list.add(bean1);   list.add(bean2);   list.add(bean3);
        MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               TextView textView= view.findViewById(R.id.item);
                list.get(i).setSelect(true);
                textView.setTextColor(android.graphics.Color.RED);
            }
        });
    }
}
