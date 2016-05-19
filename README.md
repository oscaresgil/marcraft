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
3. Navigate inside the folder and open a terminal:
  #### Windows
  Use `Shift` and Right Click into the folder, and select "Open Command Window here".
  #### Linux/Unix
	Open a terminal, find and enter the folder using `cd`.
4. Run this command:
  #### Windows
	    gradlew setupDecompWorkspace --refresh-dependencies
  #### Linux/Unix
	    ./gradlew setupDecompWorkspace --refresh-dependencies
  If the command doesn't work, you must enter this command first: `chmod +x gradlew`.
5. After the installation of the gradle is done, we must choose the IDE. We are only showing Eclipse and Intellij, other IDEs are accepted but not listed in this tutorial.
	5.1. If you will use Eclipse, run this command:
		#### Windows 
        gradlew eclipse
		#### Linux/Unix
        ./gradlew eclipse
	5.2. If you will use IntellijIDEA:
		5.2.1. First you must open the IDE and import the project. Wait until the Gradle Sync is finished.
		5.2.2. Run this command:
    #### Windows
        gradlew genIntellijRuns
		#### Linux/Unix
        ./gradlew genIntellijruns
6. Open the IDE you are working with and import the generated proyect.
6.1. If you are using Intellij and found a problem running the project. You must:
	6.1.1. Go to `Run/Edit` Configurations.
	6.1.2. Go to `Application/Minecraft` Client
	6.1.3. In the `Use classpath of module` section, switch the package to `<Name of Project>_main` and click on `Apply`.
	6.1.4. Do the same steps for the Minecraft Server.

	7. Run the project. 

### Getting MarCraft Source
Now we need MarCraft source. 
1. We need to install Git; you can get it [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git):
2. Open the directory folder and navigate to the `src/main` folder. Inside it, open a Terminal and run this command:
    git clone https://github.com/oscaresgil/marcraft
2.1. This will clone the MarCraft Source, but it's necesary to remove some things first: 
  2.1.1. Navigate into the `marcraft` downloaded folder. Move the `java` and `resources` folders into the upper directory (`src/main`), and then remove the marcraft downloaded folder.
3. Run the updated project.
4. Inside Marcraft main menu, select `Singleplayer`.
  4.1. Select `Create New World`
  4.2. Type any name for the world
  4.3. Select `Creative` Game Mode. 
  4.4. Select `More World Options`
  4.5. Select `Superflat` world type. 
  4.6. Select `Create New World`
5. Wait until Minecraft finish loading the world.

### Gameplay:
	1. Move using `wasd` buttons 
	2. Jump using `space` button
	3. Double Jump (fly) using twice the `space` button
	4. Destroy any block using left click 
	5. Interact using right click (in front of rover's wheel)
