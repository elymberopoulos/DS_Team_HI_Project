# DS_TEAM_HI_COMP439
 
 The purpose of this project is to simulate IOT.  IOT is utilized in many
 everyday appliances and devices.  These devices are always available
 through the network.  This project will support smart devices, such as lightbulbs
 and smart outlets / powerstrips, and other smart devices.
 
 The goal of the project is to implement software that will allow us to
 add and remove devices.  It will also allow us to view their current state,
 and creating smart instances, or implementing a timer for automatic power on 
 and power off.  
 
 ## What is IOT:
 IOT is a technology that enables devices to connect via the internet.  As it is called
 the Internet Of Things.  This will include pretty much any device that can be on the net.
 The purpose of this technology is to make the device "aware".  It also gives the user unparalleled 
 power and utility , all from any remote location.  Device updates, monitoring and other things that are soon to come.
 Devices can range from cameras, to dvd players, or lightbulbs and other devices that are not normally wired for internet use.
 Another great aspect is that the data that will be collected could be extremely valuable to people.  It could give us better
 understandings how the internet works and what we can do with it.
 
 ## Functionality:
 The overall functionality of the project thus far is to add devices by user choice.  Thus adding the device.  The user is able to 
 run a multitude of commands that perform various options.  The devices themselves such as a smart lightbulb, can theoretically work if there is no network.  For instance, plugging in an lightbulb without any network what so ever, will power the device, since the device would already be plugged in.  It is the connectivity from the device that gives us the extra options , since its a smart device.  This application can also work with other devices as well.  For now , with the current project, we are only sticking with lightbulbs and power switches.
 

-----------------------------------------------------------------------------------------------------------------------------
## Directions:
Dependencies: Java 1.8, Junit 5

Directions: In Intellij run the main file in the src directory/package and the program should start up in the IDE's run terminal.
The tests for the project are in the test directory/package. Right click on the directory and click run tests with coverage for detailed
results on test coverage.

## Detailed Information: 
The following are current tests that are implemented into the application.  All of these tests
are used for getting detailed information from the devices that are being tested.  


   @Test
   void setPowerSwitch() {
   (this is used to either enable the switch to on or off)
    
   @Test
   void isDeviceOn() {
   (this tests to see if the device is either on or off)
    
   @Test
   void getTimer() {
   (this is to get the current running time of the device)
   
   
   @Test
   void checkTimer() {
   (this checks to make sure that time is running)
   
   @Test
   void setDeviceName() {
   (this allows you to set a name for the device)
    
   @Test
   void showState()
   (this shows the state of the device)
   
   @Test
   void getDeviceName() {
   (this will give you the name of the device that is running)
    
-----------------------------------------------------------------------------------------------------------------------------


Directory structure -  This section goes into a little bit detail with regards to what they actually are and what information they hold.
The structure is simple.

"Device Manager" - this is the directory for the management of devices.

"Device" - this directory holds the devices that are used or when created.  for instance the light and the power strip that are already in there.

"RunAllTests" -  this directory holds all the information for all the tests that are ran.

"TimerTest" - this directory holds all the information with regards to time stamps

-----------------------------------------------------------------------------------------------------------------------------

## Setting Up Implementations for Testing-
set up the testing locally as root to avoid problems. 




## Examples of usage:
When running the application.  The user will see a command prompt with 'help
```
Type 'help' if needed.
help
<< This is the help menu >>
VALID COMMANDS:
	add device, remove device, move device, manage device
	set timer, set schedule, show devices, show devices with state, cls, help, exit
```

# Add Device:
```
add device
				<<<<<<<< CURRENT DEVICES >>>>>>>>>
______________________________________________________________________
COLLECTION: 'lights': {}
COLLECTION: 'power strips': {}
----------------------------------------------------------------------
What type of device?
	 < 'smart light' >
	 < 'smart power strip' >
```

# Remove Device:
```
remove device
	Enter key of device to remove:
```

# Move Device:
```
move device
				<<<<<<<< CURRENT DEVICES >>>>>>>>>
______________________________________________________________________
COLLECTION: 'lights': {}
COLLECTION: 'power strips': {}
----------------------------------------------------------------------
This option allows for the moving of a device from its original collection to a new collection.
What is the original collection name:
What is the key name of the device to be moved:
Enter destination collection name:
```
# Manage Device:
```
manage device
Available options:
set light power, set power strip power
```
# Set Timer:
```
set timer
<<<<<	 ENTER DEVICE INFORMATION	>>>>>>
	DEVICE KEY: 
	DEVICE COLLECTION NAME: 
Please enter a timer time in seconds.
60
Type 'help' if needed.
Schedule wait STARTED at: Mon Jan 28 11:32:50 CST 2019
Schedule wait ENDED at: Mon Jan 28 11:32:50 CST 2019
Device timer started at:Mon Jan 28 11:32:50 CST 2019
```
# Set Schedule:
```
set schedule
<<<<<	 ENTER DEVICE INFORMATION	>>>>>>
	DEVICE KEY: 
	DEVICE COLLECTION NAME: 
Please enter a timer time in seconds.
60
Next input options are for a setting a schedule.
Start in how many HOURS: 6
Start in how many MINUTES: 60
Type 'help' if needed.
Schedule wait STARTED at: Mon Jan 28 11:36:50 CST 2019
```
# Show Devices:
```
show devices
				<<<<<<<< CURRENT DEVICES >>>>>>>>>
______________________________________________________________________
COLLECTION: 'lights': {123=devices.SmartLight@6e0be858}
COLLECTION: 'power strips': {}
----------------------------------------------------------------------
```
# Show Devices With State:
```
show devices with state
COLLECTION: 'lights'
 <><> Key: '123' Device Power State: falseSmart Light Brightness level: 0COLLECTION: 'power strips'
```
# CLS:
```
"Clears the Screen"
```
# Help:
```
help
			 << This is the help menu >>
VALID COMMANDS:
	add device, remove device, move device, manage device
	set timer, set schedule, show devices, show devices with state, cls, help, exit
```
# Exit:
```
"Exits the program"
```
-----------------------------------------

## Node JS

