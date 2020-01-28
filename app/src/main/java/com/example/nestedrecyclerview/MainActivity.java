package com.example.nestedrecyclerview;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<String> itemArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.parentRV);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        adapter=new ParentRecyclerAdapter(MainActivity.this,itemArrayList);
        recyclerView.setAdapter(adapter);
        String[] item={"itemOne","itemTwo","itemThree","itemFour","itemFive"};
        for (int i=0; i<item.length; i++){
            itemArrayList.add(item[i]);

        }
        adapter.notifyDataSetChanged();

    }
}
