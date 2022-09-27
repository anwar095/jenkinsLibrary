def mavenBuild(final def args){
  env.MAVENCOMMAND = "mvn clean install -U -Dmaven.wagon.http.ssl.insecure=true"
  env.BUILDFOLDER = "$args.folder"
  if("$args.mavencommand" != 'default'){
    env.MAVENCOMMAND = "$args.mavencommand"
  } 
  
        cd $BUILDFOLDER
        $MAVENCOMMAND
}
