package com.gokhanzopcuk.noteapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.gokhanzopcuk.noteapp.R
import com.gokhanzopcuk.noteapp.databinding.FragmentHomePageBinding
import com.gokhanzopcuk.noteapp.databinding.FragmentNoteDetayBinding

class NoteDetayFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding= FragmentNoteDetayBinding.inflate(inflater, container, false)
       val bundle:NoteDetayFragmentArgs by navArgs()
        var gelenNot=bundle.noteBilgi
        binding.baslikText2.setText(gelenNot.note_baslik)
        binding.aciklamaText2.setText(gelenNot.note_aciklama)
        binding.buttonGNcelle.setOnClickListener {
            var baslik=binding.baslikText2.text.toString()
            var aciklama=binding.aciklamaText2.text.toString()
            Toast.makeText(binding.buttonGNcelle.context,"Başarılı bir şekilde güncellendi.",Toast.LENGTH_LONG).show()
        }


       return binding.root
    }
}