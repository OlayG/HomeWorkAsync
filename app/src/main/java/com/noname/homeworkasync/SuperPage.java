package com.noname.homeworkasync;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SuperPage extends AppCompatActivity {

    EditText etInput;
    RecyclerView recyclerView;
    Button btnStart;
    PersonAdapter personAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.super_page);

        progressBar = findViewById(R.id.progress);
        etInput = findViewById(R.id.et_input);
        btnStart = findViewById(R.id.btn_start);
        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = etInput.getText().toString();
                new LoadPersonTask().execute(input);
            }
        });
    }

    class LoadPersonTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Person> doInBackground(String... strings) {
            String input = strings[0];
            int secs = Integer.valueOf(input);

            int firstHalf = secs/2;
            int secondHalf = secs/2;

            try {
                Thread.sleep(firstHalf * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Create instance of Handler for UI thread(MainActivity)
            // context.getMainLooper() sets the Thread focus to the UI
            Handler mainHandler = new Handler(SuperPage.this.getMainLooper());

            Runnable testRunnable = new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(SuperPage.this, "toast from runnable", Toast.LENGTH_SHORT).show();
                }
            };

            // We use the Handler to run the Runnable
            mainHandler.post(testRunnable);

            try {
                Thread.sleep(secondHalf * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return getPersonList();
        }

        private List<Person> getPersonList() {
            List<Person> people = new ArrayList<>();

            people.add(new Person("name", "dob", "", 24));
            people.add(new Person("name2", "dob2", "", 242));
            people.add(new Person("name3", "dob3", "", 243));
            people.add(new Person("name4", "dob4", "", 224));
            people.add(new Person("name5", "dob5", "", 274));
            people.add(new Person("name6", "dob6", "", 214));
            people.add(new Person("name7", "dob7", "", 124));
            people.add(new Person("name8", "dob8", "", 2422));
            people.add(new Person("name9", "dob9", "", 1324));
            people.add(new Person("name10", "dob10", "", 2224));
            people.add(new Person("name11", "dob11", "", 245));
            people.add(new Person("name12", "dob12", "", 249));
            people.add(new Person("name13", "dob13", "", 240));

            return people;
        }

        @Override
        protected void onPostExecute(List<Person> people) {
            super.onPostExecute(people);
            progressBar.setVisibility(View.GONE);
            personAdapter = new PersonAdapter(people);
            recyclerView.setAdapter(personAdapter);
        }
    }
}
