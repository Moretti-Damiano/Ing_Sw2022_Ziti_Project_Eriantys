# Project Template - Prova Finale (Ingegneria del Software)

## Project Setup
In order to set up your project, follow these steps
### Clone and push the template to your repo
Using the git command line client for your OS, type the following commands:
```bash
 # clone the repo on your current folder, naming the remote as 'template'
 git clone https://github.com/franco-maroni/test-project-template --origin template
 # move to the cloned repo
 cd test-project-template/
 # add your repository as 'origin' (default) remote
 git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME
 # push the template project to your github repository, setting 
 git push --set-upstream origin master
 # alternatively, if you already have some content in your repo (e.g., a README)
 # and YOU WANT TO OVERWRITE IT, force the push
 git push --force --set-upstream origin master
 
```
then, you can safely remove the 'template' remote by typing `git remote rm template`.

### Personalize your poject files and Import them in Eclipse
- Open the `pom.xml` file in a text editor and substitute the two occurrences of **pcXX** with your assigned **team code**.
- Import it in eclipse as Maven Project ... 
- rename packages under `src/main/java` and `src/test/java` substituting **pcXX** with your assigned **team code**
- try mvn clean package
- modify the `README.md`


### Commit and push your changes:
  ```
  git add pom.xml src/*
  git commit -am "customize project"
  git push origin master
  ```
