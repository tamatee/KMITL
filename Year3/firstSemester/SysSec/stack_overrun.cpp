/*
StackOverrun.cpp
This program shows an example of how a stack-based buffer overrun can be used to
execute arbitrary code. Its objective is to find an input string that executes the
function Y.
*/
#include <stdio.h>
#include <string.h>

void X(const char *input)
{
    char buf[10];

    // Not passing any arguments is a trick to view the stack.
    printf("My stack looks like:\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n\n");

    // Pass the user input straight to secure code public enemy #1.
    strcpy(buf, input);
    printf("%s\n", buf);

    printf("Now the stack looks like: \n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n%p\n\n");
}

void Y(void)
{
    printf("Argh! I've been hacked!\n");
}

int main(int argc, char *argv[])
{
    printf("Address of X = %p\n", X);
    printf("Address of Y = %p\n", Y);
    // if (argc != 2)
    // {
    //     printf("Please supply a string as an argument!\n");
    //     return -1;
    // }
    X(argv[1]);
    return 0;
}
