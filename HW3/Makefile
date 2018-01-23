#Issei Mori
#1612406
#Make jar file out of ChessMoves.java
#Makefile

JAVASRC    = ChessMoves.java
#SOURCES    = README Makefile $(JAVASRC)
SOURCES = README Makefile $(wildcard *.java)
MAINCLASS  = ChessMoves
CLASSES    = ChessMoves.class ChessPiece.class LinkedList.class Node.class Empty.class Queen.class Rook.class Bishop.class King.class Knight.class Pawn.class
JARFILE    = ChessMoves.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)