package com.kottarido.unipi.dependencyinjectionkodein.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kottarido.unipi.dependencyinjectionkodein.R
import com.kottarido.unipi.dependencyinjectionkodein.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

// edo einai to View tou MVVM mas gia auto to paradigma
// kai edo tha diaxiristoume to Dependency Injection opote to kanoume kai edo kodein aware

class QuotesActivity : AppCompatActivity(), KodeinAware {

    // kanei implement to attribute tis kodein kai xrisimopoiei to by to opoio simenei oti tha einai lazy
    // (dil tha trexei meta tin onCreate lazily initialise)
    // to closestKodein pernei to kodein pou exoume orisei pio konta ( se packages fantazome)
    // alla to mono kodein pou exoume orisei einai to quotesApplication
    override val kodein by closestKodein()

    // kanoume instatiate to quotesViewModelFactory
    // to opoio to pernoume meso tou instance() tis kodein apo to QuotesApplication
    // to opoio tha kalesei mia alisida apo actions gt an doume to QuotesActivity apo to telos pros tin arxi
    // to kathe bind kalei to apopano tou.
    private val viewModelFactory: QuotesViewModelFctory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        // method pou arxikopoiei to UI
        initialiseUI()
    }

    // enas kalos tropos einai na xrisimopoiisoume data Binding me liveData gia na arxikopoiisoume to UI
    // to opoio mas epitrepei na xiristoume pola views kai events meso tou XML kai na glitosoume kodika
    // apo to View component tou MVVM
    // omos se auto to tutorial den tha to xrisimopoiisoume auto
    private fun initialiseUI() {
        // xrisimopoioume ViewModelProviders gia na arxikopoiisoume/na paroume ena idi iparxon QuotesViewModel
        // kai pername san orisma auto to activity kai to factory to opoio tha xrisimopoiisei gia na to ftia3ei
        // kai dilonoume ti tipos class tha mas epistrepsei me to get ( QuotesViewModel::class.java)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuotesViewModel::class.java)

        // paratirei LiveData apo to QuotesViewModel to opoio me tin sira tou parakolouthei LiveData
        // apo to repository kai auto me tin sira tou parakolouthei liveData apo to DAO
        // o observer einai auto to Activity (View Component) kai paratirei quote Lists (quotes)
        // gia kathe quote stin list pernei to text tou kai to vazei se enan StringBuilder
        viewModel.getQuote().observe(this, Observer { quotes ->
            // kanei initialise ton builder
            val sb = StringBuilder()
            // gia kathe quote sta quotes kane kati...
            quotes.forEach { quote ->
                sb.append("$quote\n\n")
            }

            // ta kanei display sto textView
            textView_quotes.text = sb.toString()

        })

        // When button clicked, instantiate a Quote and add it tou DB through viewModel
        button_add_quote.setOnClickListener {
            // diavazei to kenourio quote apo ta edit text
            val newQuote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            // kai meta pame sto viewModel pou ftia3ame kai kanoume addQuote
            viewModel.addQute(newQuote)

            // stin sinexia adiazei to editext ton quotes
            editText_quote.setText("")
            // adiazei to editText gia tous authors
            editText_author.setText("")

        }
    }
}
