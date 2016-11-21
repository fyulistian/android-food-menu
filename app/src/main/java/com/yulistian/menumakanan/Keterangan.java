package com.yulistian.menumakanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Keterangan extends AppCompatActivity implements OnItemSelectedListener {
    String txtNama1, value_spinner;
    EditText txtNama;
    AppCompatButton btnNext;
    Spinner combo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keterangan);
        String[] bangku = { "MM-001", "MM-002", "MM-003", "MM-004",
                "MM-005", "MM-006", "MM-007", "MM-008", "MM-009", "MM-010" };
        txtNama = (EditText) findViewById(R.id.txtNama);
        combo = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> AdapterList = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,bangku);
        combo.setAdapter(AdapterList);
        combo.setOnItemSelectedListener(this);
        btnNext = (AppCompatButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if (txtNama.getText().toString().equals("")) {
                Toast.makeText(Keterangan.this, "Nama Pemesan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            } else {
                txtNama1 = txtNama.getText().toString();
                value_spinner = combo.getSelectedItem().toString();
                Intent i =  new Intent(Keterangan.this, Menu.class);
                Bundle b = new Bundle();
                b.putString("parse_bangku", value_spinner);
                b.putString("parse_nama", txtNama1);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Silahkan Pilih Bangku", Toast.LENGTH_LONG).show();
    }
}
