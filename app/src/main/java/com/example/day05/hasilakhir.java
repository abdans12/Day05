package com.example.day05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day05.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class hasilakhir extends AppCompatActivity {

    private TextView textViewNamaPelanggan, textViewKodeBarang, textViewNamaBarang,
            textViewHarga, textViewTotalHarga, textViewDiskonHarga, textViewDiskonMember, textViewJumlahBayar;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilakhir);

        textViewNamaPelanggan = findViewById(R.id.name);
        textViewKodeBarang = findViewById(R.id.codebrg);
        textViewNamaBarang = findViewById(R.id.Namabarang);
        textViewHarga = findViewById(R.id.Harga);
        textViewTotalHarga = findViewById(R.id.Totalharga);
        textViewDiskonHarga = findViewById(R.id.Diskonharga);
        textViewDiskonMember = findViewById(R.id.Diskonmember);
        textViewJumlahBayar = findViewById(R.id.TotalBayar);
        shareButton = findViewById(R.id.Bagikan);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData();
            }
        });

        Intent intent = getIntent();
        String namaPelanggan = intent.getStringExtra("Nama Pelanggan");
        String kodeBarang = intent.getStringExtra("Kode Barang");
        String namaBarang = intent.getStringExtra("Nama Barang");
        long harga = intent.getLongExtra("Harga", 0);
        int jumlahBarang = intent.getIntExtra("Jumlah Barang", 0);
        long totalHarga = intent.getLongExtra("Total Harga", 0);
        long discountHarga = intent.getLongExtra("Diskon Harga", 0);
        long discountMember = intent.getLongExtra("Diskon Member", 0);
        long jumlahBayar = intent.getLongExtra("Jumlah Bayar", 0);

        NumberFormat formatter = new DecimalFormat("#,###,###,###");
        String formattedHarga = "Rp " + formatter.format(harga);
        String formattedTotalHarga = "Rp " + formatter.format(totalHarga);
        String formattedDiscountHarga = "Rp " + formatter.format(discountHarga);
        String formattedDiscountMember = "Rp " + formatter.format(discountMember);
        String formattedJumlahBayar = "Rp " + formatter.format(jumlahBayar);

        textViewNamaPelanggan.setText(getString(R.string.nama_pelanggan_label) + " " + namaPelanggan);
        textViewKodeBarang.setText(getString(R.string.kode_barang_label) + " " + kodeBarang);
        textViewNamaBarang.setText(getString(R.string.nama_barang_label) + " " + namaBarang);
        textViewHarga.setText(getString(R.string.harga_label) + " " + formattedHarga);
        textViewTotalHarga.setText(getString(R.string.total_harga_label) + " " + formattedTotalHarga);
        textViewDiskonHarga.setText(getString(R.string.diskon_harga_label) + " " + formattedDiscountHarga);
        textViewDiskonMember.setText(getString(R.string.diskon_member_label) + " " + formattedDiscountMember);
        textViewJumlahBayar.setText(getString(R.string.jumlah_bayar_label) + " " + formattedJumlahBayar);

    }

    private void shareData() {
        String dataToShare = "Detail Transaksi\n" +
                textViewNamaPelanggan.getText().toString() + "\n" +
                textViewKodeBarang.getText().toString() + "\n" +
                textViewNamaBarang.getText().toString() + "\n" +
                textViewHarga.getText().toString() + "\n" +
                textViewTotalHarga.getText().toString() + "\n" +
                textViewDiskonHarga.getText().toString() + "\n" +
                textViewDiskonMember.getText().toString() + "\n" +
                textViewJumlahBayar.getText().toString();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, dataToShare);
        startActivity(Intent.createChooser(shareIntent, "Bagikan via"));
    }
}