# XML Codelabs

In each of the `codelabXX` folders you will find pairs of files:
- filenameXX.XML
- filenameXX.XSD

The goal is to make sure the instance (.XML) validates against the schema (.XSD) either by correcting the instance (.XML) or the schema (.XSD).
- Below, you'll find per codelab if you have to change the XML Document or the XML Schema.

Take your time for this, and make sure to thoroughly study the provided XML documents and XML Schemas. You'll gain new insights from them.
- Should certain concepts be unclear, use the resources from the slides (or a search engine) to do some extra digging.

## How to validate an XML?

### Using IntelliJ IDEA
Simply right-click on the XML document (e.g. `company01.xml`) and select **validate**.
- IntelliJ will validate the XML document by using the XML Schema that is referenced (by `xsi:noNamespaceSchemaLocation` in the XML file)

### Using an online validator
In general, you will first have to upload both the `.xml` and `.xsd` file, then these online validators can validate the provided XML document against the provided XML Schema.

A good online validator can be found here:
- https://www.freeformatter.com/xml-validator-xsd.html

### Using Notepad++ Editor
1. In Notepad++ go to `Plugins > Plugin manager > Show Plugin Manager` (*) then find  `Xml Tools` plugin. Tick the box and click `Install`.
2. Then, open the XML document you want to validate and click `Ctrl`+`Shift`+`Alt`+`M`. Or, using the `Menu`, navigate to `Plugins > XML Tools > Validate Now`.
    - A dialog will open where you can select the XSD file to which you want to validate your XML document.

(*): _Starting from Notepad++ version 7.5 the plugin manager does not come bundled anymore.
Download the latest versions from here (https://github.com/bruderstein/nppPluginManager/releases), unzip it to the same directory where the Notepad++ executable is and start Notepad++.
It should be noted that there is a need that plugin manager and Notepad++ must use the same architecture, means PluginManager_vX.X.X_x64.zip for Notepad++ 64bit and PluginManager_vX.X.X_UNI.zip for 32bit version of Notepad++._ 

## Codelabs instructions

1. Codelab01: Adjust the XML schema company01.XSD to make sure company01.XML is a valid instance of schema company01.XSD.
2. Codelab02: Adjust the XML instance company02.XML to make sure company02.XML is a valid instance of schema company02.XSD.
3. Codelab03: Adjust the XML instance company03.XML to make sure company03.XML is a valid instance of schema company03.XSD.
4. Codelab04: Adjust the XML schema company04.XSD to make sure company04.XML is a valid instance of schema company04.XSD.
5. Codelab05: Adjust the XML schema company05.XSD to make sure company05.XML is a valid instance of schema company05.XSD.
6. Codelab06: Adjust the XML schema company06.XSD to make sure company06.XML is a valid instance of schema company06.XSD.
7. Codelab07: Adjust the XML schema company07.XSD to make sure company07.XML is a valid instance of schema company07.XSD.
8. Codelab08: Adjust the XML schema company08.XSD to make sure company08.XML is a valid instance of schema company08.XSD.
9. Codelab09: Read the `README.md` that's located in folder `codelab09` for the assignment.
10. Codelab10: Read the `README.md` that's located in folder `codelab10` for the assignment.

## Solutions

For each of the codelabs, there is a solution provided in the `solutions` folder. Please only take a look at them after you have found a working solution for yourself. Use them to compare your own solution with.