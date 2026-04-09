package pract10;

import java.util.Comparator;

public class GPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }
}
