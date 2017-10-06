JC = javac
.SUFFIXES: .java .class

default: compile

compile: 
	$(JC) Assignment2/*.java