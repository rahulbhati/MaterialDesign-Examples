package recyclerviewlist.androidstudio.simple.com.recyclerviewlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Rahul on 8/12/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    LayoutInflater inflater;
List<Data> dataList= Collections.emptyList();
    Context context;
    ItemAdapter(Context context,List<Data> dataList){
        this.context=context;
        this.dataList=dataList;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view=inflater.inflate(R.layout.custom_row,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        Data data=dataList.get(i);
        viewHolder.titleTxt.setText(data.title);
        viewHolder.descriptionTxt.setText(data.descriptio);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleTxt,descriptionTxt;

        @Override
        public void onClick(View v) {

         dataList.remove(getPosition());
            notifyItemRemoved(getPosition());

        }

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTxt=(TextView)itemView.findViewById(R.id.titleTxt);
            descriptionTxt=(TextView)itemView.findViewById(R.id.descriptionTxt);
            descriptionTxt.setOnClickListener(this);

        }
    }
}
