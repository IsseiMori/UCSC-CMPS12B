//-----------------------------------------------------------------------------
//Issei Mori
//1612406
//classify characters
//charTypes.c
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

void extract_chars(char* s, char* a, char* d, char* p, char* w){
	int count_a, count_d, count_p, count_w;
	count_a = count_d = count_p = count_w = 0;
	for(int i = 0; i < strlen(s); i++){
		if(isalpha((int)s[i])){
			a[count_a] = s[i];
			count_a++;
		}else if(isdigit((int)s[i])){
			d[count_d] = s[i];
			count_d++;
		}
		else if(ispunct((int)s[i])){
			p[count_p] = s[i];
			count_p++;
		}
		else if(isspace((int)s[i])){
			w[count_w] = s[i];
			count_w++;
		}
	}
	a[count_a] = '\0';
	d[count_d] = '\0';
	p[count_p] = '\0';
	w[count_w] = '\0';
}

int main(int argc, char* argv[]){
	int i, n;
	char* s;
	char* a;
	char* d;
	char* p;
	char* w;
	int line = 1;

	FILE* in;
	FILE* out;


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

	//allocate memory
	s = calloc(256, sizeof(char));
	a = calloc(256, sizeof(char));
	d = calloc(256, sizeof(char));
	p = calloc(256, sizeof(char));
	w = calloc(256, sizeof(char));

	//exit if callor fails
	if(s == NULL || a == NULL || d == NULL || p == NULL || w == NULL){
		printf("Unable to allocate sufficient memory\n");
		exit(EXIT_FAILURE);
	}
	

	while(fgets(s,256,in) != NULL){

		fprintf(out, "line %d contains:\n", line);
		line++;

		extract_chars(s,a,d,p,w);

		//print out alphabet
		if(strlen(a) <= 1) fprintf(out, "%d alphabetic character: ",strlen(a));
		else fprintf(out, "%d alphabetic characters: ",strlen(a));
		for(int j = 0; j < strlen(a); j++) fprintf(out, "%c", *(a+j));
		fprintf(out, "\n");

		
		//print out digit
		if(strlen(d) <= 1) fprintf(out, "%d numeric character: ",strlen(d));
		else fprintf(out, "%d numeric characters: ",strlen(d));
		for(int j = 0; j < strlen(d); j++) fprintf(out, "%c", *(d+j));
		fprintf(out, "\n");

		//print out punctuation
		if(strlen(p) <= 1) fprintf(out, "%d punctuation character: ",strlen(p));
		else fprintf(out, "%d punctuation characters: ",strlen(p));
		for(int j = 0; j < strlen(p); j++) fprintf(out, "%c", *(p+j));
		fprintf(out, "\n");


		//print out white spaces
		if(strlen(w) <= 1) fprintf(out, "%d whitespace character: ",strlen(w));
		else fprintf(out, "%d whitespace characters: ",strlen(w));
		for(int j = 0; j < strlen(w); j++) fprintf(out, "%c", *(w+j));
		fprintf(out, "\n");

	}

	free(s);
	free(a);
	free(d);
	free(p);
	free(w);
	s = a = d = p = w = NULL;

	fclose(in);
	fclose(out);

	return EXIT_SUCCESS;
}