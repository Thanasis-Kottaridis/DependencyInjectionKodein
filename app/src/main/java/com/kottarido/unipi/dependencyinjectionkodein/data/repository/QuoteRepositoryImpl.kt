package com.kottarido.unipi.dependencyinjectionkodein.data.repository

import androidx.lifecycle.LiveData
import com.kottarido.unipi.dependencyinjectionkodein.data.db.QuoteDao
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote

// tha xrisimopoiisoume dependency injection
// voithaei na exoume ta quoteDao san interface gt an thelisoume na xrisimopoiisoume kanoniki
// db kai oxi fakeDao tha einai poli eukolo na ala3oume tin efarmogi
// episis auti i class kanei implement to quoteRepository

// auti i class tha einai episis singleton kai auto tha ginei meso tis kodein library
class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    : QuoteRepository {

    // auti i fun kanei add ena quote sto QuoteDao
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    // auti i fun epistrefei ta quotes pou iparxoun sto QuoteDao
    override fun getQuotes() = quoteDao.getQuote()


}