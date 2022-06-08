package com.codeclinic.codeassignment.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.codeclinic.codeassignment.R
import com.codeclinic.codeassignment.core.Resource
import com.codeclinic.codeassignment.data.model.Section
import com.codeclinic.codeassignment.data.model.Urls
import com.codeclinic.codeassignment.databinding.ActivityMainBinding
import com.codeclinic.codeassignment.presentation.vh.StickyHeaderChildVH
import com.codeclinic.codeassignment.presentation.vh.StickyHeaderParentVH
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import smartadapter.SmartRecyclerAdapter
import smartadapter.stickyheader.StickyHeaderItemDecorationExtension
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /*we used Android Hilt for Dependency Injection here we set the AndroidEntry Point for accessing the repository via ViewModel
   * so we inject ViewModel Factory in this activity into the MainViewModel Class which has custom Parameters within it.*/

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: SmartRecyclerAdapter

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        bindAdapter()
        bindLiveData()
    }

    private fun bindAdapter() {
        adapter = SmartRecyclerAdapter.empty()
            .map(Section::class, StickyHeaderParentVH::class)
            .map(Urls::class, StickyHeaderChildVH::class)
            .add(
                StickyHeaderItemDecorationExtension(
                    headerItemType = Section::class
                )
            )
            .into(binding.recyclerView)
    }

    private fun bindLiveData() {

        viewModel.getMainPageData()

        viewModel.accessApiResponseLiveData().observe(this) { response ->
            //with sealed class we derive the response into three parts as loading ,error managing, and handling response into the UI as below

            when (response) {
                // when we get the response successfully we set it into the UI respectfully

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    response.data?.let {
                        val mArray = arrayListOf<Any>()
                        for (i in it.indices) {
                            mArray.add(Section("Section ${i + 1}"))
                            mArray.add(it[i].urls!!)
                        }
                        adapter.addItems(mArray.toMutableList())
                    }
                }

                // when we get the error for any suppose possibilities then we show it here
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.i(TAG, response.message.toString() + " ")
                    response.message?.let {
                        Snackbar.make(binding.rootLayout, it, Snackbar.LENGTH_LONG).show()
                    }
                }

                /*and last but not the least we show the loading as we send the request to the backend and hide it as soon
                * as we get the response */

                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}