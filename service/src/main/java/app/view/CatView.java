package app.view;

import java.time.LocalDate;

public class CatView {
    public LocalDate date;
    public String family;
    public String color;

    public CatView(LocalDate date, String family, String color) {
        this.date = date;
        this.family = family;
        this.color = color;
    }
}
