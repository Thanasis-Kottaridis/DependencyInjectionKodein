package com.kottarido.unipi.dependencyinjectionkodein.data.repository

import androidx.lifecycle.LiveData
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote

// to repository einai H single source of truth gia ola ta data pou to model mas apetei
// to repository interface xrisimopoieite ws ena collection olon ton Dao interfaces (giati se ena pragmatiko project tha exoume pano pao 1)
interface QuoteRepository {
    // auto to interface tha exei mono 2 functions mia gia adding quote kai mia gia getting quote
    fun addQuote(quote: Quote)
    fun getQuotes():LiveData<List<Quote>>
}