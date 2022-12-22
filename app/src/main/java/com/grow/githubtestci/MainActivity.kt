package com.grow.githubtestci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.grow.githubtestci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initView()
        setClickEvent()
    }

    private fun initView() {

    }

    private fun setClickEvent() {
        mBinding.btnSubmit.setOnClickListener {
            showMessage(1)
        }

        mBinding.btnShowDialog.setOnClickListener {
            showMessage(2)
        }
    }

    private fun showMessage(type: Int) {
        val mText = mBinding.edEnterText.editableText.toString().trim()
        if (mText.isEmpty()) {
            mBinding.edEnterText.apply {
                error = "Enter text"
                requestFocus()
            }


        } else {
            if (type == 1) {
                Toast.makeText(this@MainActivity, "Your Name is : $mText", Toast.LENGTH_SHORT).show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Your Name is")
                    .setMessage(mText)
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.close)) { dialog, _ ->
                        dialog.dismiss()
                    }.create().show()
            }
        }
    }
}