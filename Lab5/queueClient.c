//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//Insert, delete, and print values into the linkedlist
//queueClient.c
//-----------------------------------------------------------------------------
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include "queue.h"

int main(int argc, char* argv[]){

	FILE* in;
	FILE* out;
	char command;
	int number;
	LinkedList list = newLinkedList();
	
	if(argc != 3){
		printf("Usage: %s <input file> <output file>\n",argv[0]);
		exit(EXIT_FAILURE);
	}

	in = fopen(argv[1], "r");
	if(in == NULL){
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w");
	if(in == NULL){
		printf("Unable to open file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	while(fscanf(in, "%c %d \n", &command, &number)>0){
		//printf("%c and %d\n", command, number);

		switch(command){
			case 'e':
				insert(number,list);
				fprintf(out, "enqueued %d\n", number);
				break;
			case 'p':
				//fprintf(out, "printed\n");
				printLinkedListToFile(out, list);
				break;
			case 'd':
				deleteTop(out, list);
		}

		command = '\0';
		number = 0;
	}

	freeLinkedList(&list);
	//fclose(in);
	//fclose(out);
}