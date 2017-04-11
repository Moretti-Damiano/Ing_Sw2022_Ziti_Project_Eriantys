# Project Template - Prova Finale (Ingegneria del Software)

## Project Setup
In order to set up your project, follow these steps
### Clone and push the template to your repo
Using the git command line client for your OS, type the following commands:
```bash
 # clone the repo on your current folder, naming the remote as 'template'
 git clone https://github.com/deib-polimi/prova-finale-template --origin template
 # move to the cloned repo
 cd prova-finale-template/
 # add your repository as 'origin' (default) remote
 git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME
 # push the template project to your github repository, setting 
 git push --set-upstream origin master
 # alternatively, if you already have some content in your repo (e.g., a README)
 # and YOU WANT TO OVERWRITE IT, force the push
 git push --force --set-upstream origin master
 
```
then, you can safely remove the 'template' remote by typing `git remote rm template`.

### Customize your project files and Import them in Eclipse
- Open the `pom.xml` file in a text editor and substitute the two occurrences of **pcXX** with your assigned **team_code**.
- Import it in Eclipse as Maven Project:
  * from Eclipse, select `File > Import... > Existing Maven Project`
  * click `Browse...` and select the directory where you cloned the project
  * make sure the project is listed and selected under `Projects`
  * select `Finish`
  * you should now see the project **team_code** listed in the Package Explorer view of Eclipse
- from the Package Explorer view, rename packages under `src/main/java` and `src/test/java` substituting **pcXX** with your assigned **team_code**
- customize the `README.md`
- in order to check that everything worked fine, try to build with Maven:
  + from Eclipse (Package Explorer view):
    * right-click on the project
    * select `Run as > Maven build...`
    * type `clean package` into the `Goal` field
    * click `Run`
  + from command line:
    * move to your project directory (you should be in the same folder as `pom.xml` file)
    * type `mvn clean package`
  + wait for the build to complete and make sure you have a build success

### Commit and push your changes:
  ```
  git commit -am "customize project"
  git push origin master
  ```
