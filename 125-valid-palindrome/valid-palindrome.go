import (
    "unicode"
)

func isPalindrome(s string) bool {
    n := len(s);
    i := 0;
    j := n - 1;
    runes := []rune(s);


    for i <= j {
        c1 := runes[i];
        c2 := runes[j];

        if !unicode.IsLetter(c1) && !unicode.IsDigit(c1) {i++; continue;}
        if !unicode.IsLetter(c2) && !unicode.IsDigit(c2) {j--; continue;}

        if unicode.ToLower(c1) != unicode.ToLower(c2) {return false};

        i++;
        j--;
    }

    return true;
}