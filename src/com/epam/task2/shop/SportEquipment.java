package com.epam.task2.shop;

/**
 * Contains the override equals hashcode
 */
public class SportEquipment {
    public static final String CATEGORY = "category";
    public static final String TITLE = "title";

    private String category;
    private String title;

    public SportEquipment(String category, String title) {
        this.category = category;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }
}
