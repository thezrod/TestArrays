package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private ArrayList<String> route1 = new ArrayList<String>(5);

    private ArrayList<LocalTime> getEkeTime() {
        ArrayList<LocalTime> time = new ArrayList<>();
        time.add(LocalTime.of(0, 26));
        time.add( LocalTime.of(0, 56));
        time.add( LocalTime.of(4, 36));
        time.add(   LocalTime.of(4, 56));
        return time;
    }
    private ArrayList<LocalTime> getErikTime() {
        ArrayList<LocalTime> time = new ArrayList<>();
        time.add(LocalTime.of(0, 31));
        time.add( LocalTime.of(1, 1));
        time.add( LocalTime.of(4, 41));
        time.add(   LocalTime.of(5, 1));
        return time;
    }
    private ArrayList<LocalTime> getLindTime() {
        ArrayList<LocalTime> time = new ArrayList<>();
        time.add(LocalTime.of(0, 36));
        time.add( LocalTime.of(1, 6));
        time.add( LocalTime.of(4, 47));
        time.add(   LocalTime.of(5, 7));
        return time;
    }
    private ArrayList<LocalTime> getNordTime() {
        ArrayList<LocalTime> time = new ArrayList<>();
        time.add(LocalTime.of(0, 44));
        time.add( LocalTime.of(1, 14));
        time.add( LocalTime.of(4, 56));
        time.add(   LocalTime.of(5, 16));
        return time;
    }


    private ArrayList<ArrayList<LocalTime>> table = new ArrayList<>();


    private ArrayList<LocalTime> getCurrentTable(LocalTime currentTime){
        table.add(getEkeTime());
        table.add(getErikTime());
        table.add(getLindTime());
        table.add(getNordTime());
        ArrayList<LocalTime> current = new ArrayList<>();
        ArrayList<LocalTime> first = table.get(0);

        for(int i=0; i< first.size(); i++) {
            if(first.get(i).isAfter(currentTime)) {
                for(ArrayList<LocalTime> localTimes :table){
                    current.add(localTimes.get(i));
                }
                break;
            }
        }
        return current;
    }

    private void setRoutes(){
        route1.add("Eketrägatan");
        route1.add("Eriksbergstorget");
        route1.add("Lindholmen");
        route1.add("Nordstan");
        route1.add("Brunnsparken");
    }
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setEditable(false);
        setRoutes();
        for(String s : route1){
            textArea.setText(textArea.getText()+"\n"+s);
        }
        ArrayList<LocalTime> test = getCurrentTable(LocalTime.now());
        /**ArrayList<LocalTime> test = getCurrentTable(LocalTime.of(0,55));*/
        for(LocalTime localTime : test) {
            textArea.setText(textArea.getText() + "\n" + localTime);
        }
    }
}
