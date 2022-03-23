# Project Template - Prova Finale (Ingegneria del Software)

## Project Setup

In order to set up your project, follow these steps

### Clone and push the template to your repo

On GitHub user settings, scroll down to `Developer settings`, then `Personal access token`.

Create one token to be used in place of password when prompted after git command line operations (remember to store it safely).

Using the git command line client for your OS, type the following commands:

```bash
 # clone the repo on your current folder, naming the remote as 'template'
 git clone https://github.com/deib-polimi/prova-finale-template-cremona --origin template
 # move to the cloned repo
 cd prova-finale-template-cremona/
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

- Open the `pom.xml` file in a text editor and substitute the two occurrences of **xxx** with your **team_name**.
- Import it in IntelliJ
- from the Package Explorer view, rename packages under `src/main/java` and `src/test/java` substituting **xxx** with your assigned **team_name**
- customize the `README.md`
- in order to check that everything worked fine, try to build with Maven:
  - from IntelliJ:
    - right-click on the project
    - select `Maven->Reload Project`
    - wait for the build to complete and make sure you have a build success
    - right-click on class `App` and select `Run App.main()`
    - right-click on class `AppTest` and select `Run AppTest`

### Commit and push your changes:

```
git commit -am "customize project"
git push origin master
```
