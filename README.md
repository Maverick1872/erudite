#Erudite eBook Library Manager
##Purpose
Allow a convenient location to self-host an eBook library manager. Additionally, it will allow users to define
custom functionality (plugins) to hook into specific events within the application

##Available application hooks
* pre-upload
* pre-fetch-metadata
* post-fetch-metadata
* post-upload

##Plugins
####Supported Languages
[Possible implementation](https://stackoverflow.com/questions/11490140/implementing-plugins-in-a-java-application)
* Java
* Javascript
* Python

##Book Metadata APIs
* Goodreads - 12/08/2020 is being deprecated apparently
* Google - meh api so given a single test book request
* ISBNdb - 10$ minimum
* Open Library - crowd sourced
    * Curious if this application could be used to backfill their data when missing???
* SHOP.COM is also maybe barely a contender
* Amazon Product API?


### Override application properties
Use `-Dproperty=value` when starting the application.
