This is a very simple gradle/javafx/sqllite sample application.

The sample applications lets a users view list of animals and also add/delete them.
Validations are not implemented in this sample.

To run(For Now, Tested only in Linux), 

* clone this repo
* Go to zoo-maint folder, Run `./gradlew` to install gradle locally
* run `./gradlew setUpDB` (This sets up the sqllite db and needs to be run only once. Subsequent runs are ignored)
* sudo 'apt-get install openjfx'(This is needed for linux to install jfx in openjdk)
* run `gradle clean build distZip` creates zip file in the build/distribution/ folder.
* Extract the zoo-maint.zip
* Go to zoo-maint/bin folder and click the zoo-maint script file.
* Zoo application launches


References:

* https://gist.github.com/xconnecting/4166113 (setup sqllite using gradle)
* https://docs.oracle.com/javafx/2/ui_controls/table-view.htm (javafx table view)