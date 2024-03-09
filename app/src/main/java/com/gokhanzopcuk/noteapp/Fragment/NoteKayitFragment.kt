package com.gokhanzopcuk.noteapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gokhanzopcuk.noteapp.R
import com.gokhanzopcuk.noteapp.databinding.FragmentHomePageBinding
import com.gokhanzopcuk.noteapp.databinding.FragmentNoteKayitBinding
import com.google.android.material.snackbar.Snackbar

class NoteKayitFragment : Fragment() {
    private lateinit var binding: FragmentNoteKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding= FragmentNoteKayitBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener {

            val note_baslik=binding.baslikText.text.toString()
            val note_aciklama=binding.aciklamaText.text.toString()
            Toast.makeText(binding.buttonSave.context,"Başarılı bir şekilde kayıt edildi.",Toast.LENGTH_LONG).show()
        }









        return binding.root



    }
}