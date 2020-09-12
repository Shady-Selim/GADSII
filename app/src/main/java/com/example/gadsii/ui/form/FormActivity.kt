package com.example.gadsii.ui.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gadsii.R
import kotlinx.android.synthetic.main.activity_form.*
import org.koin.android.viewmodel.ext.android.viewModel

class FormActivity : AppCompatActivity() {
    private val viewModel: FormViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        button.setOnClickListener(){
            if ((etEmail.text.toString().isNotEmpty()) && (etFN.text.toString().isNotEmpty()) && (etLN.text.toString().isNotEmpty()) && (etGH.text.toString().isNotEmpty()))
                checkResult(viewModel.postForm(etEmail.text.toString(), etFN.text.toString() , etLN.text.toString(), etGH.text.toString()))
            else
                Toast.makeText(baseContext, "Please fill all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun checkResult(postForm: Boolean) {
        if (postForm)
            Toast.makeText(baseContext, "Submission Successful", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(baseContext, "Submission not Successful", Toast.LENGTH_LONG).show()

    }
}