package com.example.academia.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.academia.R

class Avaliacao : Fragment() {

    companion object {
        fun newInstance(): Avaliacao {
            val fragmentAvaliacao = Avaliacao()
            val argumentos = Bundle()
            fragmentAvaliacao.arguments = argumentos
            return fragmentAvaliacao

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avaliacao, container, false)
    }
}