JFLAGS = -g
JC = javac
TEST?=test_0.xml
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	./antColony/*.java \
	./discreteStochaticSim/*.java \
	./graph/*.java \
	./main/*.java 

default: classes jar

classes: $(CLASSES:.java=.class)

clean:
	$(RM) ./antColony/*.class && $(RM) ./discreteStochaticSim/*.class && $(RM) ./graph/*.class && $(RM) ./main/*.class
jar:
	jar cfm simulator.jar MANIFEST.MF ./antColony/* ./discreteStochaticSim/* ./graph/* ./main/*

run:
	java -jar simulator.jar ./src/TESTS/$(TEST)
