package com.tanmaymadaan.vn;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewPatientFragment extends Fragment {


    EditText mrdNo, fName, lName;
    TextView result;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_patient, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
       /* mrdNo = getView().findViewById(R.id.mrdNo);
        fName = getView().findViewById(R.id.firstName);
        lName = getView().findViewById(R.id.lastName);
        button = getView().findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    }a

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
        });

    */
    }

    public void addPatient(View view){


    }


}
