package com.kottarido.unipi.dependencyinjectionkodein.data.db

// an xrisimopoiousame tin Room Libarary auto tha itan mia abstract class
// alla o skopos einai o idios afou kai i class kai to interface exoun ws skopo na kanoun
// hold ola ta data access objects (DAO). stin periptosi mas mono to QuoteDao
interface Database {
    val quoteDao: QuoteDao
}