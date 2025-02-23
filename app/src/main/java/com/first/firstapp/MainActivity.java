package com.first.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.first.firstapp.ListViewActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText editUserName, editPassword;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private Spinner userdataSpinner, spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        checkBox=findViewById(R.id.checkBox);
        radioGroup=findViewById(R.id.radioGroup);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Checkbox Selected", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Checkbox deselected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton radioButton = findViewById(checkedId);
                String radioName = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, radioName, Toast.LENGTH_SHORT).show();
            }
        });

        login = findViewById(R.id.btnLogin);
        editUserName = findViewById(R.id.editUserName);
        editPassword = findViewById(R.id.editPassword);

        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        }));

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.countries));
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<UserData> userDataList = new ArrayList<>();
        for(int i=0; i < 10; i++){
            userDataList.add(new UserData("name"+i, "email"+i, i,i));
        }
        userdataSpinner = findViewById(R.id.users);
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, userDataList);
        userdataSpinner.setAdapter(adapter);
    }
    public void loginUser(){
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();

        if(userName.isEmpty()){
            editUserName.setError(getString(R.string.errorText));
        } else if (password.isEmpty()) {
            editPassword.setError(getString(R.string.errorText));
        }else{
            Log.i("LoginInfo", userName+" "+password);
            Toast.makeText(this,userName+ " "+ password, Toast.LENGTH_SHORT).show();
            Snackbar.make(login, userName+ " " + password, Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(this, ListViewActivity.class);
            intent.putExtra("userName", userName);
            intent.putExtra("password", password);
            intent.putExtra("phone", 9815922);
            startActivity(intent);

            Intent gridIntent = new Intent(this, activity_grid_view.class);
            gridIntent.putExtra("userName", userName);
            gridIntent.putExtra("password", password);
            gridIntent.putExtra("phone", 9815922);
            startActivity(gridIntent);



        }
    }


}