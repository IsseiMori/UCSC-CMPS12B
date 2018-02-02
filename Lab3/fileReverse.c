//Issei Mori
//1612406
//Reverse file
//fileReverse.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void stringReverse(char* s){
	char cp;
	for(int i = 0; i < strlen(s) / 2; i++){
		cp = s[i];
		s[i] = s[strlen(s)-1-i];
		s[strlen(s)-1-i] = cp;
	}
}

int main(int args, char* argv[]){
	FILE* in;
	FILE* out;
	char word[256];

	if(args != 3){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
     	exit(EXIT_FAILURE);
	}

	in = fopen(argv[1], "r");
	if( in == NULL){
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w");
	if(out == NULL){
		printf("Unable to open file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	while(fscanf(in, "%s", word) != EOF){
		stringReverse(word);
		fprintf(out, "%s\n", word);
	}

	fclose(in);
	fclose(out);

	return (EXIT_SUCCESS);
}