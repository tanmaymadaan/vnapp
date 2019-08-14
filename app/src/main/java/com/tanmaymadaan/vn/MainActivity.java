package com.tanmaymadaan.vn;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ListFragment.OnOptionClickListener{

    EditText mrdNo, fName, lName;
    TextView result;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .add(R.id.container, new ListFragment())
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.detailsContainer, new PatientFragment())
                    .commit();
        }
    }

    @Override
    public void onOptionSelected(String option) {

    }

    /*

    public void addPatient(View view){
        String mrdNoS = mrdNo.getText().toString().trim();
        String firstName = fName.getText().toString().trim();
        String lastName = lName.getText().toString().trim();
        String myUrl = getString(R.string.url);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(myUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        result.setText(myUrl);
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Patient patient = new Patient(mrdNoS, firstName, lastName);

        Call<Patient> call = jsonPlaceHolderApi.postPatient(patient);
        call.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if(!response.isSuccessful()){
                    result.setText("Code: " + response.code());
                    return;
                }

                Patient patientRes = response.body();


                result.setText("Posted " + patientRes.getMrdNo());
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {

                if (t instanceof IOException) {
                    //result.setText("Network Failure");
                    //Toast.makeText(ErrorHandlingActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    //result.setText("Conv issue");
                    // Toast.makeText(ErrorHandlingActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
                result.setText(t.getMessage());
            }
        });
    }

    */
}
