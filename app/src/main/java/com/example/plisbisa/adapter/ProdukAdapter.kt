package com.example.plisbisa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plisbisa.R
import com.example.plisbisa.model.Produk


class ProdukAdapter(var data: ArrayList<Produk>) : RecyclerView.Adapter<ProdukAdapter.Holder>(){
    class Holder (view: View):RecyclerView.ViewHolder(view){
        val txtTitle = view.findViewById<TextView>(R.id.tv_title)
        val txtDescription = view.findViewById<TextView>(R.id.tv_description)
        val txtAlamat = view.findViewById<TextView>(R.id.tv_alamat)
        val imgProduk = view.findViewById<ImageView>(R.id.img_ikan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.txtTitle.text = data[position].nama
        holder.txtDescription.text = data[position].deskripsi
        holder.txtAlamat.text = data[position].alamat
        holder.imgProduk.setImageResource(data[position].gambar)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}