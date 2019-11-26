package com.kottarido.unipi.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote

// this is quote data access object kai tha xrisimopoieite gia na kanoume add kai get Quotes stin local db mas
// otan xrisimopoioume tin room library i opoia einai gia tin SQLite
// den tha xrisimopoiisoume room apla to kanoume auto gia na 3eroume ti prepei na kanoume otan tha theloume
// na tin xrisimopoiisoume
interface QuoteDao {
    // auto to interface tha exei 2 func mia gia add kai mia gia get quote
    // H add func dexete ena quote
    fun addQuote(quote: Quote)
    // H get quote epistrefei ta liveData mias List<Quote>
    fun getQuote():LiveData<List<Quote>>

}