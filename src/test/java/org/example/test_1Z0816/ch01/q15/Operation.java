package org.example.test_1Z0816.ch01.q15;

public enum Operation {
    ADD {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        public int apply(int x, int y) {
            return x * y;
        }
    };

    public abstract int apply(int x, int y);
}
