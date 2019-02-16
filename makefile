LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)
CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
TOOLS = $(LIB)/tools
MAIN = $(BINDIR)
COV = coveragereport

vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

.SUFFIXES:  .java  .class
	-d $(BINDIR)

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

all: BinaryTreeNode.class BinaryTree.class BinarySearchTree.class AVLTree.class PrintIt.class SearchAVL.class SearchIt.class Experiment.class TestBinaryTreeNode.class TestBinaryTree.class TestBinarySearchTree.class TestAVLTree.class TestSearchAVL.class TestSearchIt.class TestPrintIt.class TestSuite.class TestRunner.class  

default: -d $(BINDIR) $(ALL)

doc:
	javadoc -d $(DOCDIR) -cp $(BINDIR):$(JUNIT) $(SRCDIR)/*.java $(TESTDIR)/*.java

test_classes: all

test: test_classes
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

report: jacoco.exec
	java -cp $(BINDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

experiment:
	java -cp $(BINDIR) Experiment

avl:
	java -cp $(BINDIR) SearchAVL

bst:
	java -cp $(BINDIR) SearchIt

clean:
	@rm -f $(BINDIR)/*.class
	@rm -f $(SRCDIR)/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
	@rm -Rf doc
