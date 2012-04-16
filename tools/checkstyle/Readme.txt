Configure code style for CCC (Eclipse Indigo)
1. Open Window -> Preferences -> Java -> Code Style -> Formatter -> Import and specify CCCFormatter.xml (attached)
2. Open Window -> Preferences -> Java -> Code Style -> Organize Imports -> Import and specify OrderImport.importorder (attached)  
3. Open Window -> Preferences -> Java -> Appearance -> Members Sort Order and set following order
	- Static Fields
	- Static Initializers
	- Static Methods
	- Fields
	- Initializers
	- Constructors
	- Methods
   
   set checkbox "Sort members in same category by visibility" and use following order
	- Public
	- Protected
	- Default
	- Private
	
4. For formating use Source -> Format (ctrl + shift + F)
5. For sorting members (fields, methods etc) use Source -> Sort Members (be careful with sorting).