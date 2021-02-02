package com.ibk.appbackend.features.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ibk.appbackend.R
import com.ibk.appbackend.databinding.ActivityMainBinding
import com.ibk.appbackend.features.model.EmployeeInfoShowModel
import com.ibk.appbackend.features.model.EmployeeInfoShowModelImpl
import com.ibk.appbackend.features.viewmodel.EmployeeInfoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var model: EmployeeInfoShowModel
    private lateinit var viewModel: EmployeeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // initialize model. (I know we should not initialize model in View. But for simplicity...)
        model = EmployeeInfoShowModelImpl()
        // initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(EmployeeInfoViewModel::class.java)


        binding.btnGetAllData.setOnClickListener {
            viewModel.getWeatherInfo(model)
            println(model)
        }
    }


}