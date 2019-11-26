package com.kottarido.unipi.dependencyinjectionkodein.data.db

// i database class tha mporouse na einai singleton alla den xriazete na mpoume stin diadikasia afou
// ta singletons tha ta diaxiristei apo moni tis i kodein Library
class DatabaseFakeImpl: Database {
    // den xriazete dependency injection (diladi na perasw to quoteDaoFakeImpl meso constructor)
    // gt i fakeDB theloun panta fake data access obj opote ta kanoume instantiate apeuthias
    override val quoteDao :QuoteDao = QuoteDaoFakeImpl()
}