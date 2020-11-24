/**
 * Created By Achmad Yusuf
 * Github : abdullah1006
 **/
package com.example.crudmysql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.crudmysql.API.RetroServer;
import com.example.crudmysql.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    private EditText inNama,inAlamat,inTelepon;
    private Spinner spJk;
    private Button btnSimpan,btnHapus;
    private String nama,jenisKelamin,alamat,telepon;
    private int iduser;
    private Space space;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        /*Initialize*/
        inNama = findViewById(R.id.in_nama);
        inAlamat = findViewById(R.id.in_alamat);
        inTelepon = findViewById(R.id.in_telp);
        spJk = findViewById(R.id.sp_jenisKelamin);
        btnSimpan = findViewById(R.id.btn_simpan);
        btnHapus = findViewById(R.id.btn_hapus);
        space = findViewById(R.id.space);

        //Kirim data dari Main Activity
        Intent data = getIntent();
        String id = data.getStringExtra("id");
        if(id !=null){
            inNama.setText(data.getStringExtra("nama"));
            jenisKelamin = data.getStringExtra("jenis_kelamin");
            if(jenisKelamin.equals("Laki-Laki")){
                spJk.setSelection(0);
            }else{
                spJk.setSelection(1);
            }
            inAlamat.setText(data.getStringExtra("alamat"));
            inTelepon.setText(data.getStringExtra("telp"));
            iduser = Integer.parseInt(id);
            btnHapus.setVisibility(View.VISIBLE);
            space.setVisibility(View.VISIBLE);
        }

        // Ketika button simpan di klik
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = inNama.getText().toString();
                alamat = inAlamat.getText().toString();
                telepon = inTelepon.getText().toString();
                jenisKelamin = spJk.getSelectedItem().toString();

                //Buat Peringatan jika editText gk terisi
                if(nama.trim().equals("")){
                    inNama.setError("Nama harus diisi");
                }else if(alamat.trim().equals("")){
                    inAlamat.setError("Alamat Harus Diisi");
                }else if(telepon.trim().equals("")){
                    inTelepon.setError("No Telepon harus diisi");
                }else{
                    if (id != null){
                        updateData();
                    }else{
                        createData();
                    }
                }
            }
        });

        //Ketika Button Hapus Di Klik
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertData();
            }
        });
    }

    //Function Buat Data
    public void createData(){
        Call<ResponseModel> simpanData = RetroServer.getUserAPI().ardCreateUser(
                nama,jenisKelamin,alamat,telepon
        );

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String message = response.body().getMessage();
                Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Funcion Perbarui Data
    private void updateData(){
        Call<ResponseModel> perbaruiData = RetroServer.getUserAPI().ardUpdateUser(
                iduser,
                nama,
                jenisKelamin,
                alamat,
                telepon
        );
        perbaruiData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Toast.makeText(AddActivity.this, "Berhasil Mengupdate", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Gagal Hubung Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Function Alert/Peringatan jika mau di hapus
    private void alertData(){
        AlertDialog.Builder dialogPesan = new AlertDialog.Builder(AddActivity.this);
        dialogPesan.setMessage("Yakin Untuk Menghapus ?");
        dialogPesan.setCancelable(true);
        //Positive Button
        dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteData();
                dialogInterface.dismiss();
                finish();
            }
        });
        //Negative Button
        dialogPesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialogPesan.show();
    }

    //Function Delete Data
    private void deleteData(){
        Call<ResponseModel> hapusData = RetroServer.getUserAPI().ardDeleteUser(iduser);
        hapusData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String message = response.body().getMessage();
                Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}