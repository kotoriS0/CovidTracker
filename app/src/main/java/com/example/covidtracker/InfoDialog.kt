package com.example.covidtracker

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.NonCancellable.start

class InfoDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Red: High Transmission\nOrange: Substantial Transmission\nYellow: " +
                    "Moderate Transmission\nBlue: Low Transmission\n\nThe number represents " +
                    "the weekly case count per 100k people in the county.")
                .setNegativeButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}