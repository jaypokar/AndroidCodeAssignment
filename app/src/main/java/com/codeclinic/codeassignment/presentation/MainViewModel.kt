package com.codeclinic.codeassignment.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeclinic.codeassignment.core.Resource
import com.codeclinic.codeassignment.data.model.DataListModel
import com.codeclinic.codeassignment.domain.mainPage.mainPageUseCases.GetMainPageDataUseCase
import com.codeclinic.codeassignment.util.ConnectionDetector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val app: Application,
    private val getMainPageUseCase: GetMainPageDataUseCase,
) : ViewModel() {

    private val apiResponse: MutableLiveData<Resource<List<DataListModel>>> = MutableLiveData()

    //Result will be accessed through liveData object and for the Activity lifecycle is not needed since ViewModel has it own lifecycle so it gets easy to retrieve new and upcoming data form yhe API.
    fun accessApiResponseLiveData(): MutableLiveData<Resource<List<DataListModel>>> = apiResponse

    fun getMainPageData() =
        viewModelScope.launch(Dispatchers.IO) {
            // we called on viewModel scope , after exiting the activity the viewModel will stop the operation of requesting API if its running of course.
            //And Dispatchers.IO is coroutine call for executing this block in the separate Thread not in UI Thread to keep the operation and smooth and fast.
            apiResponse.postValue(Resource.Loading())
            try {
                if (ConnectionDetector.isNetworkAvailable(app)) {
                    //result is retrieved from Use case, any number of use case can created to separate individual functionalities and can be reused anywhere again.
                    val apiResult = getMainPageUseCase.invoke()
                    apiResponse.postValue(apiResult)
                } else {
                    apiResponse.postValue(Resource.Error("Not Internet Connection"))
                }
            } catch (e: Exception) {
                apiResponse.postValue(Resource.Error(e.message.toString()))
            }
        }


}