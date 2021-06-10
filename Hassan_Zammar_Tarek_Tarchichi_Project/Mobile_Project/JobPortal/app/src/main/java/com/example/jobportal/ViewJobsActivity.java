package com.example.jobportal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewJobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);
        ListView ls = findViewById(R.id.IsJobs);

        ArrayList<Job> jobs = new ArrayList<Job>();
        ArrayAdapter<Job> adapter = new ArrayAdapter<Job>
                (this, android.R.layout.simple_list_item_1, jobs);
        ls.setAdapter(adapter);


        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://hassanzammar.000webhostapp.com/Project/getJobs.php";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i < response.length();i++) {
                    try {
                        JSONObject row = response.getJSONObject(i);
                        int CID = row.getInt("CID");
                        String Cname = row.getString("Cname");
                        String Email = row.getString("Email");
                        int Cphone = row.getInt("Cphone");
                        String Jtitle = row.getString("Jtitle");
                        String Jdescription = row.getString("Jdescription");
                        String Jaddress = row.getString("Jaddress");
                        jobs.add(new Job(CID, Cname, Email, Cphone, Jtitle, Jdescription, Jaddress));
                    }
                    catch (Exception ex) {
                        Toast.makeText(ViewJobsActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }

                adapter.notifyDataSetChanged();

            }
        }, null);

        queue.add(request);

    }
}