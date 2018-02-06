#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char* argv[]){
	int i, n;
	char* s;
	char* a;
	char line[256];
	char ch;

	a = calloc(256, sizeof(char));

	char word[256];
	word[0] = 's';

	FILE* in;


	in = fopen("in.txt", "r");

	printf("aa %s\n", fgets(a,256,in));

	fgets(a,256,in);
	printf("%d\n", strlen(a));
	fgets(a,256,in);
	printf("%d\n", strlen(a));

	for(int j = 0; j < strlen(a)-1; j++){
		printf("%c", *(a+j) );
	}
	/*while(fscanf(in, "%s", line) != EOF){
		printf("%d\n", strlen(line));
		printf("%c\n",line[0] );
	}*/




	free(a);
	a = NULL;

	fclose(in);

	return EXIT_SUCCESS;
}