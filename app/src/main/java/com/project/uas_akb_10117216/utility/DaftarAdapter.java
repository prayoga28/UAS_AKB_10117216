package com.project.uas_akb_10117216.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.uas_akb_10117216.R;
import com.project.uas_akb_10117216.model.db.DaftarModel;

import java.util.ArrayList;

public class DaftarAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<DaftarModel> recordList;

    public DaftarAdapter(Context context, int layout, ArrayList<DaftarModel> recordList){
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView tvNim, tvNama, tvKelas, tvTelp, tvEmail, tvSosmed;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.tvNama = row.findViewById(R.id.tv_nama);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        DaftarModel daftarModel = recordList.get(position);

//        holder.tvNim.setText(daftarModel.getId().toString());
        holder.tvNama.setText(daftarModel.getNama());
//        holder.tvKelas.setText(daftarModel.getAlamat());
//        holder.tvEmail.setText(daftarModel.getWebsite());

        return row;
    }
}

//    Tanggal Pengerjaan : 11 Agustus 2020
//    Nim : 10117216
//    Nama : Adi Prayoga
//    Kelas : IF - 7
