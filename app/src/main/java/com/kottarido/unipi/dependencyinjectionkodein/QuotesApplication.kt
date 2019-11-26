package com.kottarido.unipi.dependencyinjectionkodein

import android.app.Application
import com.kottarido.unipi.dependencyinjectionkodein.data.db.Database
import com.kottarido.unipi.dependencyinjectionkodein.data.db.DatabaseFakeImpl
import com.kottarido.unipi.dependencyinjectionkodein.data.db.QuoteDao
import com.kottarido.unipi.dependencyinjectionkodein.data.db.QuoteDaoFakeImpl
import com.kottarido.unipi.dependencyinjectionkodein.data.repository.QuoteRepositoryImpl
import com.kottarido.unipi.dependencyinjectionkodein.ui.quotes.QuotesViewModelFctory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

// edo tha efarmosoume to dependency injection
// xrisimopoioume application class gt einai prosvasimi meso olon ton components (activity, fragments klp)
// episis kanoume implement to interface KodeinAware
//(otan kanoume inherit class tin kanoume kai instantiate (), otan kanoume interface apla grafoume to onoma tou)
//
class QuotesApplication :Application() , KodeinAware {
    // epidi einai kodin aware kanoume override to Kodein
    // kai to kanoume kodein.lazy gt arxikopoiite mono otan to application einai etimo na 3ekinisi
    // diladi molis i onCreate exei trexei
    override val kodein: Kodein = Kodein.lazy {
        // arxika kanoume bind to interface tis database mas with singleton (gt i db mas prepei na einai singleton
        // den einai sosto na exoume polapla instances tis db tin idia stigmi)
        // einai poli simantiko na kanoume bind me interfaces gt an theloume na ala3oume kati alazoume mono to
        // implementation tou interface kai olos o kodikas douleuei kanonika
        bind<Database>() with singleton {
            // auto to singleton tha arxikopoiisei to implementation tis database mas (databaseFakeImpl)
            // opote tha ftia3oume ena singleton tis databaseFakeImpl kai kathe fora pou kaloume tin
            // database mas epistrefei to idi iparxon instance
            DatabaseFakeImpl()
        }

        // epanalamvanoume to idio gia to QuoteDao
        // to with einai mia infix function i opoia stin kotlin epitre na kaloume "methodous" xoris na xrisimopoioume "." kai "()"
        bind<QuoteDao>() with singleton {
            // edo den tha kanoume apla fakeQuoteDaoImpl()
            // giati theloume ola ta DAO na ginonte instatiate meso tou database implementation
            // opote kalontas tin instance<Database> mas epistrefei to instance tis DatabaseFakeImpl
            // pou dimiourgisame apo pano
            instance<Database>().quoteDao
        }

        // omios kai gia to quoteRepositoryImpl
        bind<QuoteRepositoryImpl>() with singleton {
            // to QuoteRepositoryImpl thelei ston constractor ena QuoteDao Instance
            // to opoio to pernaei i Kodein aftomata me tin instance()
            QuoteRepositoryImpl(instance())
        }

        // telos prepei na kanoume bind to QuotesViewModelFactory
        // auto den exei interfase opote tha to perasoume meso concrete class kai to kanoume
        // bind meso provider opou einai to antitheto tou singleton (to singleton provides you only
        // with a single instance eno o provider se kathe call epistefei new Instance)
        bind<QuotesViewModelFctory>() with provider { QuotesViewModelFctory(instance()) }
    }
}