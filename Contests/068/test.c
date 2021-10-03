#include <stdio.h>
#include <string.h>
int main() {
	char arr[10];
	fgets(arr,10,stdin);
	printf("%lu\n", strlen(arr));
	printf("%s\n", arr);
	return 0;
}