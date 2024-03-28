#include <iostream>
#include <limits>

int main()
{
    std::cout << "Hello C++";
    std::cin.clear(); // resets any error flags
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(),'\n');
        // ignore any characters in the input line buffer until we find a newline
    std::cin.get();
        // literally means get one more character from user
        // in practice waits for user to press enter
        // added these lines so the terminal windows doesn't closes.
    return 0;
}
