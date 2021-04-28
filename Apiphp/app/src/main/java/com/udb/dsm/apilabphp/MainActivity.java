package com.udb.dsm.apilabphp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.udb.dsm.apilabphp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PersonAdapter personAdapter;
    List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializeRecyclerView();
        getPeopleList();
    }

    private ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://atoldeelote.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        return service;
    }

    private void getPeopleList() {
        final Call<PersonResponse> batch = getApiService().getInfo();
        batch.enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                if(response != null && response.body() != null) {
                    people.clear();
                    List<Person> person = response.body().getPeopleInfo();
                    people.addAll(person);
                    personAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {
                if(t != null) {
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initializeRecyclerView() {
        personAdapter = new PersonAdapter(people);
        binding.lvPeople.setLayoutManager(new LinearLayoutManager(this));
        binding.lvPeople.setAdapter(personAdapter);
    }

}