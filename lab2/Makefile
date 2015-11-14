#makefile for the runGreet and runGreetings commands
#attached with the lab2 zip

JAVASRC = greet.java greetings.java
SOURCES = README makefile ${JAVASRC}
MAINCLASS = greet
CLASSES = greet.class greetings.class
JARFILE = namePrint
JARCLASSES = ${CLASSES}
all: ${JARFILE}

${JARFILE}: ${CLASSES}
	echo "Main-class: ${MAINCLASS}" > Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}
${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES} ${JARFILE}

runGreet:
	javac greet.java
	java greet
runGreetings:
	javac greetings.java
	java greetings

.PHONY: clean all
.PHONY: runGreet
.PHONY: runGreetings
