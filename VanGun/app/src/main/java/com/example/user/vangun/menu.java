package com.example.user.vangun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity {

    ListView listView;
    List<van> vanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        prepareData();

       listView = (ListView) findViewById(R.id.List_view);
        //Adapter
        LisAdapter adapter = new LisAdapter(menu.this,vanList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(menu.this, "Position = "+position,Toast.LENGTH_SHORT).show();


                //ส่งค่าไปที่คลาส ShowVan//
                Intent intent = new Intent(menu.this,ShowVanActivity.class);
                intent.putExtra("image",vanList.get(position).getPhoto());
                intent.putExtra("vancar1",vanList.get(position).getDatavanname());
                intent.putExtra("vancar1data",vanList.get(position).getDatavan());

                startActivity(intent);
            }
        });


        //ยังไม่ได้ลงรูปนะ..

    }



    private void prepareData() {
        int photo [] = {R.drawable.pho1,R.drawable.pho2,R.drawable.pho3,R.drawable.pho4,R.drawable.pho5,R.drawable.pho6,
                R.drawable.pho7,R.drawable.pho8,R.drawable.pho9,R.drawable.pho10,R.drawable.pho11,R.drawable.pho12,
                R.drawable.pho13,R.drawable.pho14,};

        String datavanname [] = {"จตุจักร หมอชิต2","จตุจักร หมอชิต2 ","จตุจักร หมอชิต2 ","สถานีขนสงสายใต้","สถานีขนสงสายใต้","สถานีขนสงสายใต้","เอกมัย",
                "อนุสาวรีย์ชัยสมรภูมิ","อนุสาวรีย์ชัยสมรภูมิ", "อนุสาวรีย์ชัยสมรภูมิ","อนุสาวรีย์ชัยสมรภูมิ","รังสิต","รังสิต","รังสิต",};

        String datavan [] = {getString(R.string.van1),getString(R.string.van2),getString(R.string.van3),getString(R.string.van4),
                getString(R.string.van5),getString(R.string.van6),getString(R.string.van7),getString(R.string.van8),
                getString(R.string.van9),getString(R.string.van10),getString(R.string.van11),getString(R.string.van12),
                getString(R.string.van13),getString(R.string.van14),};


        int dataSize = photo.length;
        for (int i=0 ;i<dataSize ;i++){
            van van = new van (photo[i],datavanname[i], datavan[i]);
            vanList.add(van);
        }
    }
}

