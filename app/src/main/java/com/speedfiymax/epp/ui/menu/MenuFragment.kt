package com.speedfiymax.epp.ui.menu

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.speedfiymax.epp.R
import com.speedfiymax.epp.ui.spinner.SpinnerFragment

class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val start = view.findViewById<Button>(R.id.startButton)
        start.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SpinnerFragment())
                .addToBackStack(null)
                .commit()
        }

        val exit = view.findViewById<Button>(R.id.exitButton)
        exit.setOnClickListener {
            activity?.finishAffinity()
        }
    }
}