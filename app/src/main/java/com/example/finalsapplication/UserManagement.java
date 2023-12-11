package com.example.finalsapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class UserManagement extends AppCompatActivity {

    private ListView listView;

    String[] list = {"YES","NO"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_management);

        listView = (ListView) findViewById(R.id.list);

        ArrayList<AccountInfo> accountInfos = createArray();

        ArrayList list1 = new ArrayList<>();
        for (int x =0; x< accountInfos.size(); x++){
            list1.add(""+accountInfos.get(x).getName() + "    " + accountInfos.get(x).getId());
        }

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_layout,R.id.text,list1);

        listView.setAdapter(adapter);
    }

    public ArrayList<AccountInfo> createArray(){
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<AccountInfo> accounts = db.fetchAccount();

        return accounts;
    }
}
