package com.example.plisbisa.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plisbisa.R
import com.example.plisbisa.adapter.ProdukAdapter
import com.example.plisbisa.model.Produk


class HomeFragment : Fragment() {

    lateinit var rvProduk : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvProduk = view.findViewById(R.id.rv_produk)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvProduk.adapter = ProdukAdapter(arrayProduk)
        rvProduk.layoutManager = layoutManager

        return view
    }

    val arrayProduk : ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Ikan Tongkol"
        p1.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg"
        p1.alamat = "Padang"
        p1.gambar = R.drawable.ikannn

        val p2 = Produk()
        p2.nama = "Ikan Padang"
        p2.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg kscn;ksdfjhv.zxcnbvlsdf"
        p2.alamat = "Bukittinggi"
        p2.gambar = R.drawable.ikannn



        val p3 = Produk()
        p3.nama = "Ikan Nila"
        p3.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg cuscbkjasxbcilKEJBV Jb"
        p3.alamat = "Palembang"
        p3.gambar = R.drawable.produk_ikan



        val p4 = Produk()
        p4.nama = "Ikan Emas"
        p4.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg jdclbwldshcglwefblaskdbv bh"
        p4.alamat = "Padang"
        p4.gambar = R.drawable.ikannn



        val p5 = Produk()
        p5.nama = "Ikan Tongkol"
        p5.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg jhdlbwalegf"
        p5.alamat = "Jakarta"
        p5.gambar = R.drawable.ikannn



        val p6 = Produk()
        p6.nama = "Ikan Lele"
        p6.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg hdhabw edbcasjhb"
        p6.alamat = "Pariaman"
        p6.gambar = R.drawable.produk_ikan



        val p7 = Produk()
        p7.nama = "Ikan Gabus"
        p7.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg cksdhflakeudgvxckjbvbeb"
        p7.alamat = "Jawa Timur"
        p7.gambar = R.drawable.ikannn



        val p8 = Produk()
        p8.nama = "Ikan Badut"
        p8.deskripsi = "di Butuhkan Sebanyak 100 kg dengan Berat Masing-Masing Ikan 5 kg sdELFGLWEFUG"
        p8.alamat = "Padang"
        p8.gambar = R.drawable.produk_ikan



        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)
        arr.add(p6)
        arr.add(p7)
        arr.add(p8)

        return arr

    }

}