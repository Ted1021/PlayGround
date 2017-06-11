package com.study.tedkim.checkairpollution;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvPol1, tvPol2, tvPol3, tvPol4, tvPol5, tvPol6, tvWarning;
    Spinner spLabLocation;

    String mLocation;

    static final int NO2 = 0;
    static final int O3 = 1;
    static final int CO = 2;
    static final int SO2 = 3;
    static final int PM10 = 4;
    static final int PM25 = 5;

    ArrayList<Double> mPollutionList;

    static final String API_URL = "http://openAPI.seoul.go.kr:8088/" + "4449524f656b696d31333566664a7165" + "/json/DailyAverageAirQuality/1/1/20170610/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getLocation();

    }

    public void initView(){

        tvPol1 = (TextView) findViewById(R.id.textView_pol1);
        tvPol2 = (TextView) findViewById(R.id.textView_pol2);
        tvPol3 = (TextView) findViewById(R.id.textView_pol3);
        tvPol4 = (TextView) findViewById(R.id.textView_pol4);
        tvPol5 = (TextView) findViewById(R.id.textView_pol5);
        tvPol6 = (TextView) findViewById(R.id.textView_pol6);

        tvWarning = (TextView) findViewById(R.id.textView_warning);

        spLabLocation = (Spinner) findViewById(R.id.spinner_location);

    }

    public void getLocation(){

        spLabLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mLocation = (String) parent.getItemAtPosition(position);

                String request = API_URL + mLocation;
                getPollutionInfo(request);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                mLocation = (String) parent.getItemAtPosition(0);

            }
        });
    }

    public void getPollutionInfo(String request){

        new AsyncTask<String, Void, Void>(){

            @Override
            protected Void doInBackground(String... params) {

                try{

                    URL url = new URL(params[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");
                    if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){

                        String json = "";

                        json = getJsonData(connection);
                        Log.e("CHECK_JSON", ">>>>>>>>>>>>>>"+json);

                        getAirConditionData(json);

                    }
                }catch(Exception e){

                    e.printStackTrace();

                }

                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);

                tvPol1.setText(mPollutionList.get(NO2)+"");
                tvPol2.setText(mPollutionList.get(O3)+"");
                tvPol3.setText(mPollutionList.get(CO)+"");
                tvPol4.setText(mPollutionList.get(SO2)+"");
                tvPol5.setText(mPollutionList.get(PM10)+"");
                tvPol6.setText(mPollutionList.get(PM25)+"");

                double warning_gauge = mPollutionList.get(4);
                if(warning_gauge < 30){
                    tvWarning.setText("좋음");
                    tvWarning.setTextColor(getColor(R.color.good));
                }
                else if(warning_gauge >= 31 || warning_gauge < 80){
                    tvWarning.setText("보통");
                    tvWarning.setTextColor(getColor(R.color.normal));
                }
                else if(warning_gauge >= 81 || warning_gauge < 150){
                    tvWarning.setText("나쁨");
                    tvWarning.setTextColor(getColor(R.color.bad));
                }
                else{
                    tvWarning.setText("아주나쁨");
                    tvWarning.setTextColor(getColor(R.color.insane));
                }

            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(MainActivity.this, "Get Information!! ", Toast.LENGTH_SHORT).show();

            }
        }.execute(request);

    }

    public String getJsonData(HttpURLConnection connection){

        try {
            InputStreamReader ifs = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(ifs);

            StringBuilder json = new StringBuilder();
            String singleLine = "";
            while ((singleLine = br.readLine()) != null)
                json.append(singleLine);

            return json.toString();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void getAirConditionData(String json){

        mPollutionList = new ArrayList<>();

        try {

            JSONObject airConditionData = new JSONObject(json);
            JSONObject dailyAverageAirQuality = airConditionData.getJSONObject("DailyAverageAirQuality");
            JSONArray row = dailyAverageAirQuality.getJSONArray("row");
            JSONObject pollutionInfo = row.getJSONObject(0);

            double no2 = pollutionInfo.getDouble("NO2");
            mPollutionList.add(no2);

            double o3 = pollutionInfo.getDouble("O3");
            mPollutionList.add(o3);

            double co = pollutionInfo.getDouble("CO");
            mPollutionList.add(co);

            double so2 = pollutionInfo.getDouble("SO2");
            mPollutionList.add(so2);

            double pm10 = pollutionInfo.getDouble("PM10");
            mPollutionList.add(pm10);

            double pm25 = pollutionInfo.getDouble("PM25");
            mPollutionList.add(pm25);

            for(double data : mPollutionList){

                Log.e("CHECK_DATA", "--------------- "+data+"");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
