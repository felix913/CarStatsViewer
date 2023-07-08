package com.ixam97.carStatsViewer.ui.activities

import android.app.Activity
import android.os.Bundle
import com.ixam97.carStatsViewer.CarStatsViewer
import com.ixam97.carStatsViewer.R
import kotlinx.android.synthetic.main.activity_settings_main_view.*

class SettingsMainViewActivity: Activity() {

    private val appPreferences = CarStatsViewer.appPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_main_view)

        settings_consumption_plot_switch_secondary_color.isChecked = appPreferences.chargePlotSecondaryColor
        settings_consumption_plot_switch_visible_gages.isChecked = appPreferences.consumptionPlotVisibleGages
        settings_charge_plot_switch_secondary_color.isChecked = appPreferences.chargePlotSecondaryColor
        settings_charge_plot_switch_visible_gages.isChecked = appPreferences.chargePlotVisibleGages

        settings_main_view_back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        settings_multiselect_trip.entries = ArrayList(resources.getStringArray(R.array.trip_type_names).toMutableList().apply{removeAt(0)})
        settings_multiselect_trip.selectedIndex = appPreferences.mainViewTrip
        settings_multiselect_trip.setOnIndexChangedListener {
            appPreferences.mainViewTrip = settings_multiselect_trip.selectedIndex
            CarStatsViewer.dataProcessor.changeSelectedTrip(settings_multiselect_trip.selectedIndex + 1)
        }

        settings_consumption_plot_switch_secondary_color.setOnClickListener {
            appPreferences.consumptionPlotSecondaryColor = settings_consumption_plot_switch_secondary_color.isChecked
        }
        settings_consumption_plot_switch_visible_gages.setOnClickListener {
            appPreferences.consumptionPlotVisibleGages = settings_consumption_plot_switch_visible_gages.isChecked
        }
        settings_charge_plot_switch_secondary_color.setOnClickListener {
            appPreferences.chargePlotSecondaryColor = settings_charge_plot_switch_secondary_color.isChecked
        }
        settings_charge_plot_switch_visible_gages.setOnClickListener {
            appPreferences.chargePlotVisibleGages = settings_charge_plot_switch_visible_gages.isChecked
        }
    }
}