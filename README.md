# Gitlab Docker Updater

=> single command to update your gitlab docker container  

Each execution of the program will update the container to the next minor version. 
To be safe, a backup will be made before upgrading gitlab version.

## Required Setup

* gitlab running on linux server (tested with ubuntu 18.04)
* gitlab community edition
* docker-compose installed
* `docker-compose.yml` needs to fulfill the following criteria
    * `container_name` with the name of the gitlab container
    * `image` has to be an exact gitlab version (e.g. `gitlab/gitlab-ce:12.9.0-ce.0` )
* jar has to be in the the same folder as `docker-compose.yml`
* java needs to be installed (tested with java 11)
    
## Guide

* [Download](release/GitlabDockerUpdater-latest.jar) jar next to `docker-compose.yml`
* Run the jar with java -jar GitlabDockerUpdater-latest.jar

## Steps, the program does in background
1. Get current version from `docker-compose.yml`
2. Check if there is a new version
3. Perform backup for current version
4. Set new version tag into `docker-compose.yml`
5. Pull new version image, restart docker container, display logs
6. After that point you can press strg+c at any time to stop the program