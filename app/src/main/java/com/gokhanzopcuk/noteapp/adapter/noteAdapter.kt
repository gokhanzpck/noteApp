package com.gokhanzopcuk.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gokhanzopcuk.noteapp.DATA.noteBilgi
import com.gokhanzopcuk.noteapp.Fragment.HomePageFragmentDirections
import com.gokhanzopcuk.noteapp.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class noteAdapter(var mContext: Context, var notlistesi:List<noteBilgi>) :
        RecyclerView.Adapter<noteAdapter.CardTasarımTutucu>() {
        inner class CardTasarımTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarımTutucu {
            val binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
            return CardTasarımTutucu(binding)
        }

        override fun getItemCount(): Int {
            return notlistesi.size
        }

        override fun onBindViewHolder(holder: CardTasarımTutucu, position: Int) {
            val not=notlistesi.get(position)
            val t=holder.tasarim

            t.textView.text=not.note_baslik
            t.textView2.text=not.note_aciklama
            t.cardView.setOnClickListener {
                val gecis=HomePageFragmentDirections.notDetayGecis(noteBilgi = not)
                Navigation.findNavController(it).navigate(gecis)
            }
            t.imageButton3.setOnClickListener {
                Snackbar.make(it,"${not.note_baslik} silinsin mi?", Snackbar.LENGTH_LONG)
                    .setAction("EVET"){
                    }
            }
        }
    }
