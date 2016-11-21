package com.yulistian.menumakanan;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Struk extends AppCompatActivity implements View.OnClickListener {
    String txtNim1, txtNama1, totstring;
    TextView txtNim, txtNama, txtHasil;
    AppCompatButton btnExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);
        txtNama = (TextView) findViewById(R.id.TextViewNM);
        txtNim = (TextView) findViewById(R.id.TextViewNom);
        txtHasil = (TextView) findViewById(R.id.TextViewHM);
        btnExit = (AppCompatButton) findViewById(R.id.btnNext);
        btnExit.setOnClickListener(this);

        Bundle b = getIntent().getExtras();

        txtNim1 = b.getString("parse_bangku");
        txtNama1 = b.getString("parse_nama");
        totstring = b.getString("parse_harga");

        DecimalFormat formatter = new DecimalFormat("##,###,###");
        int ttl = Integer.parseInt(totstring);
        String totalInString = formatter.format(ttl);
        String combine = "Rp. " + totalInString;
        txtNim.setText(txtNim1);
        txtNama.setText(txtNama1);
        txtHasil.setText(combine);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda Benar-Benar Ingin Keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Struk.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                }).show();
    }
}
