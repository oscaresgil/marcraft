# MarCraft
> SpaceApps challenge 2016 - Open World Generation using NASA Mars and Vesta Data

## Tools:
1. Java JDK
2. Minecraft Source Forge
3. IDE (Eclipse, Intellij, Netbeans)
4. Git

## Steps:
### Installing Java JDK
1. Download and install Java's JDK [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes.):  
2. Add the Java's directory into the environment variables.

### Configuring Source Forge
1. Download a copy of the Source Forge of Minecraft from this [link](http://adfoc.us/serve/sitelinks/?id=271228&url=http://files.minecraftforge.net/maven/net/minecraftforge/forge/1.8.9-11.15.1.1902-1.8.9/forge-1.8.9-11.15.1.1902-1.8.9-mdk.zip), passing through the ads inside it.
2. Unzip the downloaded file into the project's folder.
3. Navigate inside the folder, open a terminal and run this command:
	
	##### Windows
	    gradlew setupDecompWorkspace --refresh-dependencies
	##### Linux/Unix
	    ./gradlew setupDecompWorkspace --refresh-dependencies
	If the command doesn't work, you must enter this command first: `chmod +x gradlew`.
#### IDE
4. After the installation of the gradle is done, we must choose the IDE. We are only showing Eclipse and Intellij, other IDEs are accepted but not listed in this tutorial.
	* For **Eclipse**, run this command:
		
		##### Windows
		    gradlew eclipse
		##### Linux/Unix
		    ./gradlew eclipse
	* For **IntellijIDEA**, you must open the IDE and import the project. Then, run this command:

		##### Windows
		    gradlew genIntellijRuns
		##### Linux/Unix
		    ./gradlew genIntellijruns
5. Open the IDE you are working with and import the generated proyect.
	* If you are using Intellij and found a problem running the project. You must:
		* Go to `Run/Edit` Configurations.
		* Go to `Application/Minecraft` Client
		* In the `Use classpath of module` section, switch the package to `<Name of Project>_main` and click on `Apply`.
		* Do the same steps for the Minecraft Server.

6. Run the project. 

### Getting MarCraft Source
Now we need MarCraft source. 
1. We need to install Git; you can get it [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git):
2. Open the directory folder and navigate to the `src/main` folder. Inside it, open a Terminal and run this command:
    git clone https://github.com/oscaresgil/marcraft
3. This will clone the MarCraft Source, but it's necesary to remove some things first: 
   Navigate into the `marcraft` downloaded folder. Move the `java` and `resources` folders into the upper directory (`src/main`), and then remove the marcraft downloaded folder.
4. Run the updated project.

## Inside MarCraft
1. Inside Marcraft main menu, select `Singleplayer`.
2. Select `Create New World`
3. Type any name for the world
4. Select `Creative` Game Mode. 
5. Select `More World Options`
6. Select `Superflat` world type. 
7. Select `Create New World`
8. Wait until Minecraft finish loading the world.

### Gameplay:
* Move using `wasd` buttons 
* Jump using `space` button
* Double Jump (fly) using twice the `space` button
* Destroy any block using left click 
* Interact using right click (in front of rover's wheel)
