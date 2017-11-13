This is a very simple gradle/javafx/sqllite sample application.

The sample applications lets a user view list of animals and also add/delete them.

To run(tested only in Linux, should work in mac also) 

* clone this repo and go to zoo-main folder and run the below commands.
* `./gradlew` to install gradle locally
* `./gradlew setUpDB` (This sets up a file based sqllite db and needs to be run only once. Subsequent runs are ignored)
* `sudo apt-get install openjfx`(Linux only: this is needed for linux to install jfx in openjdk)
* `./gradlew clean build distZip` creates zip file zoo-maint.zip in the build/distribution/ folder.
* Extract the zoo-maint.zip and execute zoo-maint script in bin folder.

Note:
* if gradle is installed, then `gradle` can be used instead of `./gradlew` 
* This is a very basic implementation. No Validations have been done.
* javafx classes have a lot of final methods. So it is not possible to mock these classes/methods. So only minimal unit testing was done.

References:

* https://gist.github.com/xconnecting/4166113 (setup sqllite using gradle)
* https://docs.oracle.com/javafx/2/ui_controls/table-view.htm (javafx table view)
