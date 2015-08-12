package recyclerviewlist.androidstudio.simple.com.recyclerviewlist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
RecyclerView recyclerView;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewItems);

        adapter=new ItemAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Data> getData() {
        List<Data> dataList=new ArrayList<Data>();
        for(int i=0;i<20;i++){
           Data data=new Data();
            data.title="Title "+i;
            data.descriptio="Description "+i;
            dataList.add(data);

        }
        return dataList;
    }


}
