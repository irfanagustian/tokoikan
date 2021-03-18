package com.example.plisbisa.model

import java.io.Serializable

class Produk : Serializable{
    lateinit var nama : String
    lateinit var deskripsi : String
    lateinit var alamat : String
    var gambar:Int = 0
}