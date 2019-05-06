package hashTable_06;

public class practice_02 {
	
	static class HashTable {
        static final Object EMPTY = null;
        static final Object DELETED = new Object();
        static final double A = 0.3758;
        static final int[] PRIME_NUMBER = {3, 5, 7, 11, 13, 17, 19 };

        Object[] a;
        int count=0;
        int threshold;

        public HashTable() {
            this(32);
        }

        public HashTable(int size) {
            this.a = new Object[size];
            this.threshold = (int)(this.a.length * 0.7);
        }

        private void resize() {
            int newSize = a.length * 2;
            HashTable newHashTable = new HashTable(newSize);
            for (Object value : a)
                if (value != EMPTY && value != DELETED)
                    newHashTable.add(value);
            this.a = newHashTable.a;
            this.threshold = newHashTable.threshold;
        }

        public void add(Object value) {
            int collisionCount = 0;
            do {
                int index = getIndex(value, collisionCount);
                if (a[index] == EMPTY || a[index] == DELETED) {
                    a[index] = value;
                    this.count++;
                    if (this.count >= this.threshold) resize();
                    return;
                } else if (a[index] == value)
                    return;
                ++collisionCount;
            } while (collisionCount < a.length);
        }

        private int getIndex(Object value, int collisionCount) {
            int startIndex = (int)(((value.hashCode() * A) % 1) * this.a.length);
            int step = PRIME_NUMBER[value.hashCode() % 7];
            return (startIndex + collisionCount * step) % a.length;
        }

        public void remove(Object value) {
            int collisionCount = 0;
            do {
                int index = getIndex(value, collisionCount);
                if (a[index] == EMPTY) return;
                else if (a[index] == value) {
                    a[index] = DELETED;
                    this.count--;
                    return;
                }
                ++collisionCount;
            } while (collisionCount < a.length);
        }

        public boolean contains(Object value) {
            int collisionCount = 0;
            do {
                int index = getIndex(value, collisionCount);
                if (a[index] == null) return false;
                else if (a[index].equals(value)) return true;
                ++collisionCount;
            } while (collisionCount < a.length);
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
    	Person[] a = new Person[] {
                new Person("홍길동", "남성", "A"),
                new Person("임꺽정", "남성", "AB"),
                new Person("전우치", "남성", "O")
        };
        HashTable hashTable = new HashTable();

        for (Person person : a)
            hashTable.add(person);

        for (Person person : a)
            System.out.println(hashTable.contains(person));
        System.out.println(hashTable.contains(new Person("연흥부", "남성", "AB")));
    }
}
