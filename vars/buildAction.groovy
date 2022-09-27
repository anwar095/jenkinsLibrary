def mavenBuild(final def args){
  env.MAVENCOMMAND = "mvn clean install -U -Dmaven.wagon.http.ssl.insecure=true"
  env.BUILDFOLDER = "$args.folder"
  if("$args.mavencommand" != 'default'){
    env.MAVENCOMMAND = "$args.mavencommand"
  } 
         sh '''
        cd $BUILDFOLDER
        $MAVENCOMMAND
         sh '''
}


def buildPushImage(final def args){
  env.DOCKERSCRIPTPATH = "build-docker-image.bash"
    if("$args.imagebuildscript" != 'default'){
      env.DOCKERSCRIPTPATH = "$args.imagebuildscript"
    } 
    
       sh '''
           bash $DOCKERSCRIPTPATH
          '''
}
