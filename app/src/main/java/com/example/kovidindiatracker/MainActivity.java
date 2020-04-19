package com.example.kovidindiatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import es.dmoral.toasty.Toasty;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.util.Calendar;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView confirm, active, recover, death, lastupdate;


    ListView listView;
    //Context context;
    private static CustomAdapter adapter;
    ArrayList<DataModel> dataModels = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "https://api.covid19india.org/data.json";

        lastupdate = findViewById(R.id.lastUpdatedTv);
        confirm = findViewById(R.id.confirmedTv);
        active = findViewById(R.id.activeTv);
        recover = findViewById(R.id.recoveredTv);
        death = findViewById(R.id.deceasedTv);

        listView = findViewById(R.id.list);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.list_header, listView, false);
        listView.addHeaderView(header);

        corona(url);

        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                corona(url);
                Toasty.success(MainActivity.this, "Refresh Done", 50, true).show();
                swipeRefreshLayout.setRefreshing(false);

            }
        });

    }

    public void corona(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String myResponse = response.body().string();
                //Log.i("APi Response: ", myResponse);

                Gson gson = new Gson();
                //Type pojoType = new TypeToken<List<Pojo>>(){}.getType();
                final Pojo pojo = gson.fromJson(myResponse, Pojo.class);
                //List<Pojo> list = gson.fromJson(myResponse, pojoType);

                adapter = new CustomAdapter(MainActivity.this, R.layout.item_list, dataModels);
                adapter.clear();

                for (int i = 0; i < pojo.getStatewise().size(); i++) {
                    dataModels.add(new DataModel(pojo.getStatewise().get(i).getState(),
                            pojo.getStatewise().get(i).getConfirmed() + "\n↑" + pojo.getStatewise().get(i).getDeltaconfirmed(),
                            pojo.getStatewise().get(i).getActive()+ "\n↑" + pojo.getStatewise().get(i).getDeltarecovered(),
                            pojo.getStatewise().get(i).getRecovered()+ "\n↑" + pojo.getStatewise().get(i).getDeltarecovered(),
                            pojo.getStatewise().get(i).getDeaths()+ "\n↑" + pojo.getStatewise().get(i).getDeltadeaths()));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        confirm.setText(pojo.getStatewise().get(0).getConfirmed());
                        active.setText(pojo.getStatewise().get(0).getActive());
                        recover.setText(pojo.getStatewise().get(0).getRecovered());
                        death.setText(pojo.getStatewise().get(0).getDeaths());

                        lastupdate.setText("LAST UPDATED" +"\n"+"\n"+ pojo.getStatewise().get(0).getLastupdatedtime());

                        listView.setAdapter(adapter);


                    }
                });

            }
        });
    }

    public void settext(){

    }

    public long timedifference(String lastup) throws ParseException {

        Date current = Calendar.getInstance().getTime();
        Date lastups=new SimpleDateFormat("dd/MM/yyyy").parse(lastup);

        long diff = current.getTime() - lastups.getTime();

        //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");



           // long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            final long  advance;

            if (diffSeconds >= 60 ){
                advance =  diffMinutes;
            } else if (diffMinutes >= 60){
                advance =  diffHours;
            } else if(diffHours >= 24){
                advance =  diffDays;
            } else {
                advance =  diffSeconds;
            }

            return advance;

    }

}
