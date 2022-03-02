package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

public class Train {
    String nameDestination;
    int numberTrain;
    Date timeDeparture;



    public Train(String nameDestination, int numberTrain, Date timeDeparture) {
        this.nameDestination = nameDestination;
        this.numberTrain = numberTrain;
        this.timeDeparture = timeDeparture;
    }

    public Train() {
    }

    public String getNameDestination() {
        return nameDestination;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public Date getTimeDeparture() {
        return timeDeparture;
    }

    //добавьте возможность сортировки элементов массива по номерам поездов.
    public static Comparator<Train> NumberTrainComparator = new Comparator<Train>() {
        @Override
        public int compare(Train tr1, Train tr2) {
            return tr1.getNumberTrain() - tr2.getNumberTrain();
        }
    };

    //Добавьте возможность сортировки массив по пункту назначения,
    //причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
    public static Comparator<Train> NameAndTimeComparator = new Comparator<Train>() {
        @Override
        public int compare(Train tr1, Train tr2) {
            int flag = tr1.getNameDestination().compareTo(tr2.getNameDestination());
            if (flag == 0) {
                flag = tr1.getTimeDeparture().compareTo(tr2.getTimeDeparture());
            }
            return flag;
        }
    };
    @Override
    public String toString() {
        return "Поезд: " +
        "пункт назначения - '" + nameDestination + '\'' +
                ", номер поезда - " + numberTrain +
                ", время отправления - '" + timeDeparture + '\'';
    }
    //Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
    public static String searchNumberTrain(BufferedReader reader, Train[] trains) throws IOException {
        System.out.print("Для поиска введите номер поезда: ");
        int readNumberTrain = Integer.parseInt(reader.readLine());
        int count = 0;
        Train tempTrain = new Train();
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].numberTrain == readNumberTrain) {
                tempTrain = trains[i];
            } else {
                count++;
            }
        }
        return count != trains.length ? tempTrain.toString() : "Поезд с номером " + readNumberTrain + " не найден";
    }
}
