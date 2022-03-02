package com.company.epam.part4.AggAndComp.Country;

public class MainCountry {
    public static void main(String[] args) {

//    3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//    столицу, количество областей, площадь, областные центры.

        City brest = new City("Брест", 340000, true, false);
        City pinsk = new City("Пинск",  126000, false, false);
        City baranovichi = new City("Барановичи", 175000, false, false);
        //Витебская область
        City vitebsk = new City("Витебск",  365000, true, false);
        City braslav = new City("Браслав",  10000, false, false);
        City lepel = new City("Лепель",  18000, false, false);
        //Гомельская область
        City gomel = new City("Гомель",  510000, true, false);
        City mozyr = new City("Мозырь",  111000, false, false);
        City svetlogorsk = new City("Светлогорск",  65000, false, false);
        //Гродненская область
        City grodno = new City("Гродно",  357000, true, false);
        City lida = new City("Лида",  103000, false, false);
        City shchuchin = new City("Щучин",  16000, false, false);
        //Минская область
        City minsk = new City("Минск",  2000000, true, true);
        City smolevichi = new City("Смолевичи",  17000, false, false);
        City borisov = new City("Борисов",  130000, false, false);
        City logoisk = new City("Логойск",  15000, false, false);
        //Могилевская область
        City mogilev = new City("Могилев",  357000, true, false);
        City bobruisk = new City("Бобруск",  212000, false, false);
        City osipovichi = new City("Осиповичи",  30000, false, false);
        //Районы
        //Брестская область
        District brestDistr = new District("Брестский район", 1544.11, 383000, brest);
        District pinskDistr = new District("Пинский район", 3252.77, 172000, pinsk);
        District baranovichiDistr = new District("Барановичский район", 2171.88, 205000, baranovichi);
        //Витебская область
        District vitebskDistr = new District("Витебский район", 2737, 402000, vitebsk);
        District braslavDistr = new District("Браславский район", 2270.07, 35000, braslav);
        District lepelDistr = new District("Лепельский район", 1822.22, 51000, lepel);
        //Гомельская область
        District gomelDistr = new District("Гомельский район", 1951.4, 578000, gomel);
        District mozyrDiste = new District("Мозырьский район", 1603.47, 133000, mozyr);
        District svetlogorskDistr = new District("Светлогорский район", 1899.91, 83000, svetlogorsk);
        //Гродненская область
        District grodnoDistr = new District("Гродненский район", 2594.05, 407000, grodno);
        District lidaDistr = new District("Лидский район", 1566.74, 132000, lida);
        District shchuchinDaistr = new District("Щучинский район", 1911.54, 40000, shchuchin);
        //Минская область
        District minskDistr = new District("Минский район", 2251.5, 2215000, minsk);
        District smolevichiDistr = new District("Смолевичский район", 1394.14, 46000, smolevichi);
        District logoiskDistr = new District("Логойский район", 2365.02, 35000, logoisk);
        District borisovDistr = new District("Борисовский район", 2987.63, 180000, borisov);
        //Могилевская область
        District mogilevDistr = new District("Могилевский район", 1895.4, 397000, mogilev);
        District bobruiskDistr = new District("Бобруйский район", 1599.05, 228000, bobruisk);
        District osipovichiDistr = new District("Осиповичский район", 1947.21, 48000, osipovichi);
        //Области
        Region brestRegion = new Region("Брестская область", 32777,brestDistr, baranovichiDistr, pinskDistr);
        Region vitebskRegion = new Region("Витебская область", 40051, vitebskDistr, brestDistr, lepelDistr);
        Region gomelRegion = new Region("Гомельская область", 40372, mozyrDiste, svetlogorskDistr);
        Region grodnoRegion = new Region("Гродненская область", 25127, grodnoDistr, lidaDistr, shchuchinDaistr);
        Region minskRegion = new Region("Минская область", 39854, minskDistr, smolevichiDistr, borisovDistr, logoiskDistr);
        Region mogilevRegion = new Region("Могилевская область", 29068, mogilevDistr, bobruiskDistr, osipovichiDistr);
        Region[] regions = {brestRegion, vitebskRegion, gomelRegion, grodnoRegion, minskRegion, mogilevRegion};
        Country belarus = new Country("Республика Беларусь", regions);
        belarus.printCapital();
        belarus.printNumberRegions();
        belarus.printAreaCountry();
        belarus.printRegionCenter();
        belarus.numberPopulationCountry();
    }
}
