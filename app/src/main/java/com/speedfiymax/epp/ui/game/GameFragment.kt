package com.speedfiymax.epp.ui.game

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.speedfiymax.epp.R
import java.util.*

class GameFragment : Fragment(R.layout.fragment_game) {
    private lateinit var backButton: ImageButton
    private lateinit var spinButton: Button
    private lateinit var pie: PieChart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pie = view.findViewById(R.id.pie)
        spinButton = view.findViewById(R.id.spinButton)
        backButton = view.findViewById(R.id.backButton)

        Configurator().configPie(pie)
        configSpinButton()
        configBackButton()
    }

    private fun configBackButton() {
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun configSpinButton() {
        spinButton.setOnClickListener {
            val angle = (Math.random() * 360f).toFloat()

            pie.spin(
                5000,
                0f,
                720 + angle,
                Easing.EaseOutCirc
            )

            view?.findViewById<TextView>(R.id.resultText)?.text = "You won " + pie.data.dataSet
                .getEntryForIndex(pie.getIndexForAngle(270f - angle))
                .value.toInt() + "$"

            Timer().schedule(
                object : TimerTask() {
                    override fun run() {
                        view?.findViewById<TextView>(R.id.resultText)?.visibility = View.VISIBLE
                    }
                }, 5000
            )
        }
    }


}