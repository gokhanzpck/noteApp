package com.gokhanzopcuk.noteapp.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.gokhanzopcuk.noteapp.DATA.noteBilgi
import com.gokhanzopcuk.noteapp.R
import com.gokhanzopcuk.noteapp.adapter.noteAdapter
import com.gokhanzopcuk.noteapp.databinding.ActivityMainBinding
import com.gokhanzopcuk.noteapp.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {


        binding= FragmentHomePageBinding.inflate(inflater, container, false)
      binding.rv.layoutManager=LinearLayoutManager(requireContext())
        binding.noteAddButton.setOnClickListener{
          Navigation.findNavController(it).navigate(R.id.notKayitGecis)
      }
        val notListe=ArrayList<noteBilgi>()
        val a1=noteBilgi(1,"ANKARA","ANKARA ADANA ARASI 1950 TL PARA HARCANDI")
        val a2=noteBilgi(2,"İSTANBUL-ADANA","İSTANBUL - ADANA ARASI 5000TL YAKIT GİTTİ")
        val a3=noteBilgi(3,"26 TEMMUZ","SPORA GİDİLDİ VE İŞTE ÖNEMLİ GELİŞMELER OLDU")
        val a4=noteBilgi(4,"TURİZ-ADANA","TURİZ REKLAM AJANSINA BU AY 5 BİN ÖDEME YAPILDI")

        notListe.add(a1)
        notListe.add(a2)
        notListe.add(a3)
        notListe.add(a4)
        val NoteAdapter=noteAdapter(requireContext(),notListe)
        binding.rv.adapter=NoteAdapter



        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                ara(query!!)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                ara(newText!!)
                return true
            }
        })

        return  binding.root
    }
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)
    }
}