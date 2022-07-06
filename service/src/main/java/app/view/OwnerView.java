package app.view;

import java.time.LocalDate;

public class OwnerView {
    public String name;
    public LocalDate date;

    public OwnerView(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}
