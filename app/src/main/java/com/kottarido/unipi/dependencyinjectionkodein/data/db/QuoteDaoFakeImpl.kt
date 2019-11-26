package com.kottarido.unipi.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote

// epidi den xrisimopoioume tin Room oste na mas kanei tin implementation tou QuoteDao interface
// ftiaxnoume mia fake quoteDao implementation.
// Opte auti i class tha kanei implemen to QuoteDao interface
class QuoteDaoFakeImpl : QuoteDao {

    // edo tha ftia3oume enan fake database table i opia tha einai apla mia list stin mnimi den tha einai kanoniki
    // einai mutable gt theloume na prosthetoume kai na aferoume elements apo autin
    private val quoteList = mutableListOf<Quote>()

    // episis theloume mutable LiveData ta opoia kathe fora tha pernoun mia list apo quotes
    // kai tha tin kanoun observe opote ginonte alages
    // (kai etsi tha enimerononte kai ta apopano components gia tin enimerosi tis quoteList)
    // ta mutableLiveData ta kratame privet gt mporoun na ala3oun timi kai emeis theloume na alazoun mono mesa se auti tin class
    private val quotes = MutableLiveData<List<Quote>>()

    // sto init block arxikopoioume tin timi ton LiveData me tin QuoteList oste na ginei i proti observation
    // auto to kanoume gt theloume amesos na sindesoume tin quoteList me ta LiveData pou mporoun na ginoun
    // observed apo outside
    init{
        quotes.value = quoteList
    }

    // kanoume Implement tis methodous touQuoteDao Interface
    override fun addQuote(quote: Quote) {
        // prosthetei to quote stin quoteList
        quoteList.add(quote)
        // enimeronei to value ton liveData prokimenou na gini i observation apo ta apopano components
        quotes.value = quoteList
    }

    // epistrefei ta quotes (diladi kanei tin observation) alla den epistefei mutableLiveData gt
    // den theloume na allazoun ta LiveData ektos autis tis klasis
    override fun getQuote() = quotes as LiveData<List<Quote>>


}