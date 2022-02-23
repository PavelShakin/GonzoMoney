package com.speedfiymax.epp.ui.game

import android.graphics.Color
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class Configurator {

    fun configPie(pie: PieChart) {
        val item1 = (Math.random() * 100f).toFloat()
        val item2 = (Math.random() * 100f).toFloat()
        val item3 = (Math.random() * 100f).toFloat()
        val item4 = (Math.random() * 100f).toFloat()
        val item5 = (Math.random() * 100f).toFloat()
        val item6 = (Math.random() * 100f).toFloat()

        val entries = listOf(
            PieEntry(item1, (item1 * 10).toInt().toString()),
            PieEntry(item2, (item2 * 10).toInt().toString()),
            PieEntry(item3, (item3 * 10).toInt().toString()),
            PieEntry(item4, (item4 * 10).toInt().toString()),
            PieEntry(item5, (item5 * 10).toInt().toString()),
            PieEntry(item6, (item6 * 10).toInt().toString())
        )
        val dataSet = PieDataSet(entries, "")

        val colors = ArrayList<Int>()
        pie.isDrawHoleEnabled = true
        pie.isRotationEnabled = false
        pie.legend.isEnabled = false
        dataSet.setDrawValues(false)
        colors.add(Color.CYAN)
        colors.add(Color.GRAY)
        colors.add(Color.BLACK)
        colors.add(Color.RED)
        colors.add(Color.BLUE)
        colors.add(Color.GREEN)

        dataSet.colors = colors
        val data = PieData(dataSet)

        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(30f)
        data.setValueTextColor(Color.BLACK)
        pie.data = data
    }
}