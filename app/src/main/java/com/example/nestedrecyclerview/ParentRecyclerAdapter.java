package com.example.nestedrecyclerview;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<String> parentList;
    ArrayList<String> dayArrayList=new ArrayList();

    public ParentRecyclerAdapter(Context context, ArrayList<String> parentList) {
        this.context = context;
        this.parentList = parentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.parent_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parentItemNameTextView.setText(parentList.get(position));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);
        dayArrayList.clear();
        String[] days={"Saturday","Sunday","Monday","Tuesday","WednessDay","Thursday","Friday"};
        for(int i=0; i<days.length; i++){
            dayArrayList.add(days[i]);
        }
        ChildRecyclerViewAdapter childRecyclerViewAdapter=new ChildRecyclerViewAdapter(dayArrayList);
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
        childRecyclerViewAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView parentItemNameTextView;
        RecyclerView childRecyclerView;

        public ViewHolder(@ NonNull View itemView) {
            super(itemView);
            parentItemNameTextView=itemView.findViewById(R.id.parentItemNameTextView);
            childRecyclerView=itemView.findViewById(R.id.childRecyclerView);



        }
    }
}
