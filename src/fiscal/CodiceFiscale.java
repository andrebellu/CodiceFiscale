package fiscal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodiceFiscale {

    //attributi
    private String surname;
    private String name;
    private String city;
    private int day;
    private int month;
    private int year;
    private String gender;

    String codePath = "CodiciCatastali.txt";

    //costruttori
    public CodiceFiscale(){}

    //setter
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //metodi

    public String cutSurname() {
        String cuttedSurname = "";
        surname = surname.toUpperCase();

        for (int i = 0; i < surname.length(); i++) {
            if (cuttedSurname.length() != 3 && surname.charAt(i) != 'A' && surname.charAt(i) != 'E' && surname.charAt(i) != 'I' && surname.charAt(i) != 'O' && surname.charAt(i) != 'U') {
                cuttedSurname += surname.charAt(i);
            }
        }

        if (cuttedSurname.length() != 3) {
            for (int i = 0; i < surname.length(); i++) {
                if (cuttedSurname.length() != 3) {
                    if (surname.charAt(i) == 'A' || surname.charAt(i) == 'E' || surname.charAt(i) == 'I' || surname.charAt(i) == 'O' || surname.charAt(i) == 'U') {
                        cuttedSurname += surname.charAt(i);
                    }
                }
            }
        }

        if (cuttedSurname.length() != 3) {
            do {
                cuttedSurname += 'X';
            } while (cuttedSurname.length() != 3);
        }

        return cuttedSurname;
    }

    public String cutName() {
        String cuttedName = "";
        name = name.toUpperCase();

        for (int i = 0; i < name.length(); i++) {
            if (cuttedName.length() != 4 && name.charAt(i) != 'A' && name.charAt(i) != 'E' && name.charAt(i) != 'I' && name.charAt(i) != 'O' && name.charAt(i) != 'U') {
                cuttedName += name.charAt(i);
            }
        }

        if (cuttedName.length() == 4) {
            cuttedName = cuttedName.substring(0, 1) + cuttedName.substring(1 + 1);
        }

        if (cuttedName.length() != 3) {
            for (int i = 0; i < name.length(); i++) {
                if (cuttedName.length() != 3) {
                    if (name.charAt(i) == 'A' || name.charAt(i) == 'E' || name.charAt(i) == 'I' || name.charAt(i) == 'O' || name.charAt(i) == 'U') {
                        cuttedName += name.charAt(i);
                    }
                }
            }
        }

        if (cuttedName.length() != 3) {
            do {
                cuttedName += 'X';
            } while (cuttedName.length() != 3);
        }

        return cuttedName;
    }

    public String codiceCatastale() throws IOException {

        String code="", s="";

        city = city.toUpperCase().replaceAll(" ","");

        FileReader fr = new FileReader(codePath);
        BufferedReader br = new BufferedReader(fr);

        while((code=br.readLine()) != null){
            String[] part = code.split(";");
            String cityName = part[0].replaceAll(" ","");
            if(cityName.equals(city)){
                s=part[1];
            }
        }
        fr.close();
        return s;
    }

    public String data(){
        String fiscalDate="";
        String fiscalYear = Integer.toString(year).substring(2,4);

        if(gender.toUpperCase().equals("F")){
            day +=40;
        }
        String fiscalDay = Integer.toString(day);
        if(fiscalDay.length()==1){
            fiscalDay="0"+fiscalDay;
        }


        String fiscalMonth="";
        switch(month) {
            case 1: fiscalMonth="A";
                break;
            case 2: fiscalMonth="B";
                break;
            case 3: fiscalMonth="C";
                break;
            case 4: fiscalMonth="D";
                break;
            case 5: fiscalMonth="E";
                break;
            case 6: fiscalMonth="H";
                break;
            case 7: fiscalMonth="L";
                break;
            case 8: fiscalMonth="M";
                break;
            case 9: fiscalMonth="P";
                break;
            case 10: fiscalMonth="R";
                break;
            case 11: fiscalMonth="S";
                break;
            case 12: fiscalMonth="T";
                break;
        }

        return fiscalYear+fiscalMonth+fiscalDay;
    }

    public String controllo(String finalResult) throws IOException {
                String c = "";
                String char_posPari = "";
                String char_posDispari = "";
                int counter=0;

                for(int i=0;i<finalResult.length();i++)
                {
                    if(i % 2 == 0)
                        char_posDispari += finalResult.charAt(i);
                    else
                        char_posPari += finalResult.charAt(i);
                }

                for(int i=0; i <char_posDispari.length(); i++)
                {
                    switch(char_posDispari.charAt(i))
                    {
                        case '0': counter += 1;
                            break;
                        case '1': counter += 0;
                            break;
                        case '2': counter += 5;
                            break;
                        case '3': counter += 7;
                            break;
                        case '4': counter += 9;
                            break;
                        case '5': counter += 13;
                            break;
                        case '6': counter += 15;
                            break;
                        case '7': counter += 17;
                            break;
                        case '8': counter += 19;
                            break;
                        case '9': counter += 21;
                            break;
                        case 'A': counter += 1;
                            break;
                        case 'B': counter += 0;
                            break;
                        case 'C': counter += 5;
                            break;
                        case 'D': counter += 7;
                            break;
                        case 'E': counter += 9;
                            break;
                        case 'F': counter += 13;
                            break;
                        case 'G': counter += 15;
                            break;
                        case 'H': counter += 17;
                            break;
                        case 'I': counter += 19;
                            break;
                        case 'J': counter += 21;
                            break;
                        case 'K': counter += 2;
                            break;
                        case 'L': counter += 4;
                            break;
                        case 'M': counter += 18;
                            break;
                        case 'N': counter += 20;
                            break;
                        case 'O': counter += 11;
                            break;
                        case 'P': counter += 3;
                            break;
                        case 'Q': counter += 6;
                            break;
                        case 'R': counter += 8;
                            break;
                        case 'S': counter += 12;
                            break;
                        case 'T': counter += 14;
                            break;
                        case 'U': counter += 16;
                            break;
                        case 'V': counter += 10;
                            break;
                        case 'W': counter += 22;
                            break;
                        case 'X': counter += 25;
                            break;
                        case 'Y': counter += 24;
                            break;
                        case 'Z': counter += 23;
                            break;

                    }
                }

                for(int i=0;i<char_posPari.length();i++){
                    switch(char_posPari.charAt(i)){
                        case '0': counter += 0;
                            break;
                        case '1': counter += 1;
                            break;
                        case '2': counter += 2;
                            break;
                        case '3': counter += 3;
                            break;
                        case '4': counter += 4;
                            break;
                        case '5': counter += 5;
                            break;
                        case '6': counter += 6;
                            break;
                        case '7': counter += 7;
                            break;
                        case '8': counter += 8;
                            break;
                        case '9': counter += 9;
                            break;
                        case 'A': counter += 0;
                            break;
                        case 'B': counter += 1;
                            break;
                        case 'C': counter += 2;
                            break;
                        case 'D': counter += 3;
                            break;
                        case 'E': counter += 4;
                            break;
                        case 'F': counter += 5;
                            break;
                        case 'G': counter += 6;
                            break;
                        case 'H': counter += 7;
                            break;
                        case 'I': counter += 8;
                            break;
                        case 'J': counter += 9;
                            break;
                        case 'K': counter += 10;
                            break;
                        case 'L': counter += 11;
                            break;
                        case 'M': counter += 12;
                            break;
                        case 'N': counter += 13;
                            break;
                        case 'O': counter += 14;
                            break;
                        case 'P': counter += 15;
                            break;
                        case 'Q': counter += 16;
                            break;
                        case 'R': counter += 17;
                            break;
                        case 'S': counter += 18;
                            break;
                        case 'T': counter += 19;
                            break;
                        case 'U': counter += 20;
                            break;
                        case 'V': counter += 21;
                            break;
                        case 'W': counter += 22;
                            break;
                        case 'X': counter += 23;
                            break;
                        case 'Y': counter += 24;
                            break;
                        case 'Z': counter += 25;
                            break;
                    }
                }
                switch(counter%26){
                    case 0: c = "A";
                        break;
                    case 1: c = "B";
                        break;
                    case 2: c = "C";
                        break;
                    case 3: c = "D";
                        break;
                    case 4: c = "E";
                        break;
                    case 5: c = "F";
                        break;
                    case 6: c = "G";
                        break;
                    case 7: c = "H";
                        break;
                    case 8: c = "I";
                        break;
                    case 9: c = "J";
                        break;
                    case 10: c = "K";
                        break;
                    case 11: c = "L";
                        break;
                    case 12: c = "M";
                        break;
                    case 13: c = "N";
                        break;
                    case 14: c = "O";
                        break;
                    case 15: c = "P";
                        break;
                    case 16: c = "Q";
                        break;
                    case 17: c = "R";
                        break;
                    case 18: c = "S";
                        break;
                    case 19: c = "T";
                        break;
                    case 20: c = "U";
                        break;
                    case 21: c = "V";
                        break;
                    case 22: c = "W";
                        break;
                    case 23: c = "X";
                        break;
                    case 24: c = "Y";
                        break;
                    case 25: c = "Z";
                        break;
                }
                return c;
            }
        }
