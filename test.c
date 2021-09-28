#include <stdio.h>

void test() {
    char *str1 = "hello";
    char *str2 = "world";
    str1 = str2;
    printf("%s %s\n", str1, str2);
}
void func() {
    int s = 0;
    while (s++ < 10) {
    
        if (s < 4 && s < 9) {
            continue;
        }
        printf("\n%d\t",s);
    }
}
int main(){
    func();
    return 0;
}
