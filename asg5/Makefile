# Makefile for Programming Assignment 5

JAVASRC    = edfile.java dllist.java auxlib.java dllistTest.java
SOURCES    = ${JAVASRC} Makefile README
MAINCLASS  = edfile
CLASSES    = ${JAVASRC:.java=.class}
JARCLASSES = ${CLASSES} dllist\$$*.class
JARFILE    = edfile
TESTCLASS  = dllist
CLASSPATH  = "junit-4.12.jar:hamcrest-core-1.3.jar:."

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo "Main-class: ${MAINCLASS}" >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	chmod +x ${JARFILE}
	rm Manifest

%.class : %.java
	javac -cp ${CLASSPATH} $<

test : ${TESTCLASS}Test.class ${TESTCLASS}.class
	java -cp ${CLASSPATH} org.junit.runner.JUnitCore ${TESTCLASS}Test

clean :
	rm -f *.class Manifest

spotless : clean
	rm -f ${JARFILE}

.PHONY:all test clean spotless
