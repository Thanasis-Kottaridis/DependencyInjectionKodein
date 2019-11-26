package com.kottarido.unipi.dependencyinjectionkodein.ui.quotes

import androidx.lifecycle.ViewModel
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote
import com.kottarido.unipi.dependencyinjectionkodein.data.repository.QuoteRepository

// auti i klasi apoteli to ViewModel tou MVVM pattern mas
// dexete ston constructor ena obj pou kani implement to interface tou QuoteRepository
// edo den ftiaxnoume diko mas interface kanoume inherit apo ton ViewModel tis java pou einai etimo
class QuotesViewModel(private val quoteRepository : QuoteRepository)
    :ViewModel() {
    // to viewModel tha exei tis 2 klasikes fun pou eixe kai to QuoteDao kai to QuoteRepository
    // add Quote kai getQuote
    fun addQute(quote: Quote){
        quoteRepository.addQuote(quote)
    }
    // epistrefei LiveData List<Quote> gia na ginete i paratirisi tou repository (Observation)
    fun getQuote() = quoteRepository.getQuotes()
}