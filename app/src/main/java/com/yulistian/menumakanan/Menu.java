package com.yulistian.menumakanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Intent;

import java.text.DecimalFormat;

public class Menu extends AppCompatActivity implements OnItemSelectedListener {
    String txtNama1, txtbangku, value_spinner, harga;
    Integer NG, tot, n1, n2, hargaMakanan;
    TextView txtNama, TextViewNo, TextViewMenu;
    AppCompatButton btnNext;
    EditText txtJumlah;
    Spinner combo;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtNama = (TextView) findViewById(R.id.TextViewNama);
        TextViewNo = (TextView) findViewById(R.id.TextViewNo);
        btnNext = (AppCompatButton) findViewById(R.id.btnNext);
        txtJumlah = (EditText) findViewById(R.id.txtJumlah);
        combo = (Spinner) findViewById(R.id.spinner);
        TextViewMenu = (TextView) findViewById(R.id.TextViewMenu);
        String[] MMakan = { "Nasi Goreng", "Mie Goreng", "Sate Sapi", "Pecel Ayam", "Itik Goreng"};
        ArrayAdapter<String> AdapterList = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,MMakan);
        combo.setAdapter(AdapterList);
        combo.setOnItemSelectedListener(this);



        btnNext = (AppCompatButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (txtJumlah.getText().toString().equals("")) {
                    Toast.makeText(Menu.this, "Harap Masukan Jumlah Pembelian", Toast.LENGTH_SHORT).show();
                } else {
                    n1 = Integer.parseInt(txtJumlah.getText().toString());
                    n2 = hargaMakanan;
                    tot = n1 * n2;
                    txtNama1 = txtNama.getText().toString();
                    value_spinner = TextViewNo.getText().toString();
                    harga = tot.toString();
                    Intent i = new Intent(Menu.this, Struk.class);
                    Bundle b = new Bundle();
                    b.putString("parse_bangku", value_spinner);
                    b.putString("parse_nama", txtNama1);
                    b.putString("parse_harga", harga);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }
            }
        });

        Bundle b = getIntent().getExtras();
        txtNama1 = b.getString("parse_nama");
        txtbangku = b.getString("parse_bangku");

        TextViewNo.setText(txtbangku);
        txtNama.setText(txtNama1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (combo.getSelectedItem().toString().equals("Nasi Goreng")) {
            NG = 17500;
        } else if (combo.getSelectedItem().toString().equals("Mie Goreng")) {
            NG = 15000;
        } else if (combo.getSelectedItem().toString().equals("Sate Sapi")) {
            NG = 25000;
        } else if (combo.getSelectedItem().toString().equals("Pecel Ayam")) {
            NG = 23000;
        } else {
            NG = 35000;
        }
        hargaMakanan = NG;
        DecimalFormat formatter = new DecimalFormat("##,###,###");
        String InString = formatter.format(NG);
        String combine = "Rp. " + InString;
        TextViewMenu.setText(combine);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Silahkan Pilih Menu Makanan", Toast.LENGTH_LONG).show();
    }
}
