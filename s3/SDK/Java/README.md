
# Create a new MAven Project
# https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
``` sh
mvn archetype:generate -DgroupId=com.aosnaya.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```

# https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/setup-project-maven.html
``` sh
mvn -B archetype:generate \
 -DarchetypeGroupId=software.amazon.awssdk \
 -DarchetypeArtifactId=archetype-lambda -Dservice=s3 -Dregion=US_EAST_1 \
 -DarchetypeVersion=2.32.24 \
 -DgroupId=com.aosnaya.myapp \
 -DartifactId=myapp
```