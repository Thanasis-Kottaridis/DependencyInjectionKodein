package com.kottarido.unipi.dependencyinjectionkodein.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kottarido.unipi.dependencyinjectionkodein.data.repository.QuoteRepository

// auti i class tha ftiaxnei instances tou Quotes viewModel
// xriazomaste auto to factory giati alios den mporoume na perasoume tipota mesa sto instance
// tou QuotesViewModel kai xriazomaste to QuotesViewModel na periexei ena property tipou quoteRepository
// afou to viewModel xriazete na epikinoni me to backEnd kapos (meso tou repository)
// kai epidi to viewModel xriazete repository kai to Factory tha dexete to repository san orisma
// kai klironomi meso tou ViewModelProvider tin NewInstanceFactory
class QuotesViewModelFctory(private val quoteRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){

    // tha periexei mono mia method i opoia tha kanei create to QuotesViewModel
    // TO Suppress to xrisimopoioume gt to T den einai standard tipos einai generic
    // oxi oti compiler den to kanei check apla gia sigouria
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}