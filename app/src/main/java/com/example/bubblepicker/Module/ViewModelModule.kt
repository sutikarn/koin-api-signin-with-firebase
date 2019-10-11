package com.example.bubblepicker.Module




import com.example.bubblepicker.ViewModel.LuckyViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


var viewModelModule = module {

     viewModel { LuckyViewModel(get()) }

}

