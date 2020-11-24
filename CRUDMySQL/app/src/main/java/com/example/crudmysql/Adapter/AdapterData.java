/**
 * Created By Achmad Yusuf
 * Github : abdullah1006
 **/
package com.example.crudmysql.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudmysql.AddActivity;
import com.example.crudmysql.Model.DataModel;
import com.example.crudmysql.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listUser;

    //Ini Constructor
    public AdapterData(Context ctx, List<DataModel> listMhs) {
        this.ctx = ctx;
        this.listUser = listMhs;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listUser.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama());
        holder.tvJenisKelamin.setText(dm.getJenis_kelamin());
        holder.tvAlamat.setText(dm.getAlamat());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId,tvNama,tvJenisKelamin,tvAlamat;
        DataModel dm;

        //Masukkan apa aja yang mau di holder/ditampilkan pada list item
        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvJenisKelamin = itemView.findViewById(R.id.tv_jenisKelamin);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);

            //Ketika salah satu item diklik
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goInput = new Intent(ctx, AddActivity.class);
                    goInput.putExtra("id",String.valueOf(dm.getId()));
                    goInput.putExtra("nama",dm.getNama());
                    goInput.putExtra("jenis_kelamin",dm.getJenis_kelamin());
                    goInput.putExtra("alamat",dm.getAlamat());
                    goInput.putExtra("telp",dm.getTelp());
                    ctx.startActivity(goInput);
                }
            });
        }
    }
}

