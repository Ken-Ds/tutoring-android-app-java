package com.example.finalsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalsapplication.dataType.AccountInfo;
import com.example.finalsapplication.dataType.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class UserManagement extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;

    public AccountInfo editAccount;

    private ImageButton backButton, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_management);

        listView = (ListView) findViewById(R.id.list);
        searchView = (SearchView) findViewById(R.id.searchView);
        backButton = (ImageButton) findViewById(R.id.backButton);
        addButton = (ImageButton) findViewById(R.id.addButton);

        searchView.setQueryHint("Search By Name");



        ArrayList<AccountInfo> accountInfos = createArray();

        ArrayList list1 = new ArrayList<>();
        for (int x =0; x< accountInfos.size(); x++){
            list1.add("Name: "+accountInfos.get(x).getName() + "\t\t" + "ID: "+ accountInfos.get(x).getId());
        }
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_layout,R.id.text,list1);

        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        listView.setDividerHeight(10);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int x =0; x < accountInfos.size();x++){
                    if(position==x){
                        editAccount = accountInfos.get(position);
                    }
                }
                Intent i = new Intent(UserManagement.this, EditProfile.class);
                i.putExtra("name", editAccount.getName());
                i.putExtra("email", editAccount.getEmail());
                i.putExtra("id", String.valueOf(editAccount.getId()));
                Intent i1 = new Intent(UserManagement.this, ProfileInfoAdmin.class);
                startActivity(i1);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserManagement.this, AdminMenu.class);
                startActivity(i);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserManagement.this, AddUser.class);
                startActivity(i);
            }
        });
    }


    public ArrayList<AccountInfo> createArray(){
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<AccountInfo> accounts = db.fetchAccount();
        return accounts;
    }
}
