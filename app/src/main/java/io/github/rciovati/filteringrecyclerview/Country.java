package io.github.rciovati.filteringrecyclerview;

public class Country {
    private String mName;

    public Country(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        return !(mName != null ? !mName.equals(country.mName) : country.mName != null);

    }

    @Override
    public int hashCode() {
        return mName != null ? mName.hashCode() : 0;
    }
}
