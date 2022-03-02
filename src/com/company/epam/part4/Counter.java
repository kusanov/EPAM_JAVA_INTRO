package com.company.epam.part4;

import static java.lang.Math.random;

public class Counter {

    int count;
    int beginCount;
    int endCount;


    public Counter() {
        this.beginCount = 0;
        this.endCount = 10;
        this.count = 4;
    }


        public Counter(int beginCount, int endCount) {
            this.beginCount = beginCount;
            this.endCount = endCount;
            this.count = (int) (random() * ((endCount - beginCount) + 1)) + beginCount;
        }

        public Counter(int count, int beginCount, int endCount) {
            this.count = count;
            this.beginCount = beginCount;
            this.endCount = endCount;
        }

        int reduceCount() {
            if (count - beginCount==0) {
                return count;
            } else if (count > beginCount && count <= endCount) {
                return count--;
            } else {
                return count;
            }
        }

        int increaseCount() {
            if (count - endCount==0) {
                 return count;
            } else if (count < endCount && count >= beginCount) {
                return count++;
            } else {
                return count;
            }
        }

        int currentValueCount() {
            return count;
        }

        @Override
        public String toString () {
            return "Счетчик:" +
                    " исходное значение счетчика count = " + count +
                    ", начало диапазона beginCount = " + beginCount +
                    ", конец диапазона endCount = " + endCount + ".";
        }
    }

