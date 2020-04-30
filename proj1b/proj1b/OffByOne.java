package proj1b.proj1b;

import proj1b.proj1b.CharacterComparator;

public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == 1 || y - x == 1;
    }
}
