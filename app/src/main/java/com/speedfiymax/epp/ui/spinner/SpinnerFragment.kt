package com.speedfiymax.epp.ui.spinner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.speedfiymax.epp.R
import com.speedfiymax.epp.ui.game.GameFragment
import java.util.*

class SpinnerFragment : Fragment(R.layout.fragment_spinner) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timer().schedule(
            object : TimerTask() {
                override fun run() {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, GameFragment())
                        .commit()
                }
            }, 1700
        )
    }
}