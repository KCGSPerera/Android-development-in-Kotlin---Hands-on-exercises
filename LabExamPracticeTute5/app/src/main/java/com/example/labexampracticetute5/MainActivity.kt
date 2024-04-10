package com.example.labexampracticetute5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ViewAnimator
import androidx.appcompat.app.AlertDialog
import com.example.labexampracticetute5.models.FormData
import com.example.labexampracticetute5.models.validations.ValidationResults

class MainActivity : AppCompatActivity() {

    lateinit var edtStudentId:EditText
    lateinit var  spnYear:Spinner
    lateinit var spnSemester:Spinner
    lateinit var cbAgree:CheckBox

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtStudentId = findViewById(R.id.edtStudentId)
        spnYear = findViewById(R.id.Years)
        spnSemester =findViewById(R.id.Semesters)
        cbAgree =findViewById(R.id.cbAgreement)
    }

    fun displayAlert(title:String, message:String){
        var builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK"){dialog, which ->

        }
        val dialog = builder.create()
        dialog.show()
    }


    fun submit(v: View){

        val myForm = FormData(
            edtStudentId.text.toString(),
            spnYear.selectedItem.toString(),
            spnSemester.selectedItem.toString(),
            cbAgree.isChecked
        )

        val studentIDValidation = myForm.validateStudentId()
        val spnYearValidation = myForm.validateYear()
        val spnSemesterValidation = myForm.validateSemester()
        val cbAgreeValidation = myForm.validateAgreement()


        when(studentIDValidation){
            is ValidationResults.Valid -> {
                count++
            }
            is ValidationResults.Invalid -> {
                edtStudentId.error = studentIDValidation.errorMessage
            }
            is ValidationResults.Empty -> {
                edtStudentId.error = studentIDValidation.errorMessage
            }
        }

        when(spnYearValidation){
            is ValidationResults.Valid -> {
                count++
            }
            is ValidationResults.Invalid -> {

            }
            is ValidationResults.Empty -> {
                val tv:TextView = spnYear.selectedView as TextView
                tv.error = ""
                tv.text = spnYearValidation.errorMessage
            }
        }

        when(spnSemesterValidation){
            is ValidationResults.Empty -> {
                val tv:TextView = spnSemester.selectedView as TextView
                tv.error = ""
                tv.text = spnSemesterValidation.errorMessage

            }
            is ValidationResults.Invalid -> {

            }
            ValidationResults.Valid -> {
                count++
            }
        }

        when(cbAgreeValidation){
            is ValidationResults.Empty -> {

            }
            is ValidationResults.Invalid -> {
                displayAlert("Error", cbAgreeValidation.errorMessage)
            }
            ValidationResults.Valid -> {
                count++
            }
        }


        if(count == 4){
            displayAlert("Success", "You have successfully registered")
        }else{
            count = 0
        }
    }
}