package com.lyj.retrofitstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lyj.retrofitstudy.javaBean.WeatherEntry;
import com.lyj.retrofitstudy.utils.RetrofitUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    @BindView(R.id.edit_city)
    EditText mEdit;
    @BindView(R.id.btn_query)
    Button mBtnQuery;
    @BindView(R.id.text_weather_info)
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_query)
    public void onViewClicked()
    {
        String city = mEdit.getText().toString();
        if (!TextUtils.isEmpty(city))
        {
            RetrofitUtils.requestWeatherCall(city, null, null).enqueue(new Callback<WeatherEntry>()
            {
                @Override
                public void onResponse(Call<WeatherEntry> call, Response<WeatherEntry> response)
                {
                    if (response.isSuccessful() && response.body() != null)
                    {
                        mText.setText(response.body().getResult().toString());
                    }
                }

                @Override
                public void onFailure(Call<WeatherEntry> call, Throwable t)
                {
                    t.printStackTrace();
                }
            });

            return;
        }

        mText.setText("There is anything to show");
    }
}
