package com.tanmaymadaan.vn;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PatientFragment extends Fragment {

    private Spinner idSpinner, genderSpinner, stateSpinner;
    private EditText fNameet, lNameet, phoneNoet, ageet, idNoet, guardianet,addet, cityet;
    private ArrayAdapter<CharSequence> adapter;
    private Button button;
    private String idType, gender, state;
    private int pId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient, container, false);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        idSpinner = getView().findViewById(R.id.idSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.idType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSpinner.setAdapter(adapter);

        genderSpinner = getView().findViewById(R.id.genderSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        stateSpinner = getView().findViewById(R.id.stateSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter);

        fNameet = getView().findViewById(R.id.firstName);
        lNameet = getView().findViewById(R.id.lastName);
        phoneNoet = getView().findViewById(R.id.phoneNo);
        ageet = getView().findViewById(R.id.age);
        idNoet = getView().findViewById(R.id.idNo);
        guardianet = getView().findViewById(R.id.guardianName);
        addet = getView().findViewById(R.id.address);
        cityet = getView().findViewById(R.id.city);
        button = getView().findViewById(R.id.button);

        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                idType = "Aadhar";
            }
        });

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = "Male";
            }
        });

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                state = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                idType = "Uttarakhand";
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstName = fNameet.getText().toString().trim();
                final String lastName = lNameet.getText().toString().trim();
                final String phoneNo = phoneNoet.getText().toString().trim();
                final String age = ageet.getText().toString().trim();
                final String idNo = idNoet.getText().toString().trim();
                final String guardian = guardianet.getText().toString().trim();
                final String add = addet.getText().toString().trim();
                final String city = cityet.getText().toString().trim();


                String myUrl = getString(R.string.url);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(myUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

                Call<List<Counter>> call = jsonPlaceHolderApi.getCounter();
                call.enqueue(new Callback<List<Counter>>() {
                    @Override
                    public void onResponse(Call<List<Counter>> call, Response<List<Counter>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(), response.code(), Toast.LENGTH_LONG).show();
                        }

                        List<Counter> counters = response.body();
                        for(Counter count : counters){
                            pId = count.getCounter();
                            Toast.makeText(getContext(), pId + " counter", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Counter>> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



                Patient patient = new Patient("19-08-" + pId, firstName, lastName, phoneNo, age, idType, idNo, gender, guardian, add, city, state);

                Call<Patient> call2 = jsonPlaceHolderApi.postPatient(patient);
                call2.enqueue(new Callback<Patient>() {
                    @Override
                    public void onResponse(Call<Patient> call, Response<Patient> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getContext(), response.code(), Toast.LENGTH_LONG).show();
                        }
                        Toast.makeText(getContext(), "Saved Successfully!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Patient> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
