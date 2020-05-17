public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char c1, char c2) {
        if (Math.abs(c1 - c2) == 1) {
            return true;
        }
        return false;
    }
}
