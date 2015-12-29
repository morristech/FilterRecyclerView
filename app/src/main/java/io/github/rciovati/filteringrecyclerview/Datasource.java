package io.github.rciovati.filteringrecyclerview;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class Datasource {

    //<editor-fold desc="Countries list">
    private static List<Country> sCountries = Arrays.asList(
            new Country("Afghanistan"),
            new Country("Albania"),
            new Country("Algeria"),
            new Country("Andorra"),
            new Country("Angola"),
            new Country("Antigua and Barbuda"),
            new Country("Argentina"),
            new Country("Armenia"),
            new Country("Aruba"),
            new Country("Australia"),
            new Country("Austria"),
            new Country("Azerbaijan"),
            new Country("Bahamas, The"),
            new Country("Bahrain"),
            new Country("Bangladesh"),
            new Country("Barbados"),
            new Country("Belarus"),
            new Country("Belgium"),
            new Country("Belize"),
            new Country("Benin"),
            new Country("Bhutan"),
            new Country("Bolivia"),
            new Country("Bosnia and Herzegovina"),
            new Country("Botswana"),
            new Country("Brazil"),
            new Country("Brunei "),
            new Country("Bulgaria"),
            new Country("Burkina Faso"),
            new Country("Burma"),
            new Country("Burundi"),
            new Country("Cambodia"),
            new Country("Cameroon"),
            new Country("Canada"),
            new Country("Cape Verde"),
            new Country("Central African Republic"),
            new Country("Chad"),
            new Country("Chile"),
            new Country("China"),
            new Country("Colombia"),
            new Country("Comoros"),
            new Country("Congo, Democratic Republic of the"),
            new Country("Congo, Republic of the"),
            new Country("Costa Rica"),
            new Country("Cote d'Ivoire"),
            new Country("Croatia"),
            new Country("Cuba"),
            new Country("Curacao"),
            new Country("Cyprus"),
            new Country("Czech Republic"),
            new Country("Denmark"),
            new Country("Djibouti"),
            new Country("Dominica"),
            new Country("Dominican Republic"),
            new Country("East Timor"),
            new Country("Ecuador"),
            new Country("Egypt"),
            new Country("El Salvador"),
            new Country("Equatorial Guinea"),
            new Country("Eritrea"),
            new Country("Estonia"),
            new Country("Ethiopia"),
            new Country("Fiji"),
            new Country("Finland"),
            new Country("France"),
            new Country("Gabon"),
            new Country("Gambia, The"),
            new Country("Georgia"),
            new Country("Germany"),
            new Country("Ghana"),
            new Country("Greece"),
            new Country("Grenada"),
            new Country("Guatemala"),
            new Country("Guinea"),
            new Country("Guinea-Bissau"),
            new Country("Guyana"),
            new Country("Haiti"),
            new Country("Holy See"),
            new Country("Honduras"),
            new Country("Hong Kong"),
            new Country("Hungary"),
            new Country("Iceland"),
            new Country("India"),
            new Country("Indonesia"),
            new Country("Iran"),
            new Country("Iraq"),
            new Country("Ireland"),
            new Country("Israel"),
            new Country("Italy"),
            new Country("Jamaica"),
            new Country("Japan"),
            new Country("Jordan"),
            new Country("Kazakhstan"),
            new Country("Kenya"),
            new Country("Kiribati"),
            new Country("Korea, North"),
            new Country("Korea, South"),
            new Country("Kosovo"),
            new Country("Kuwait"),
            new Country("Kyrgyzstan"),
            new Country("Laos"),
            new Country("Latvia"),
            new Country("Lebanon"),
            new Country("Lesotho"),
            new Country("Liberia"),
            new Country("Libya"),
            new Country("Liechtenstein"),
            new Country("Lithuania"),
            new Country("Luxembourg"),
            new Country("Macau"),
            new Country("Macedonia"),
            new Country("Madagascar"),
            new Country("Malawi"),
            new Country("Malaysia"),
            new Country("Maldives"),
            new Country("Mali"),
            new Country("Malta"),
            new Country("Marshall Islands"),
            new Country("Mauritania"),
            new Country("Mauritius"),
            new Country("Mexico"),
            new Country("Micronesia"),
            new Country("Moldova"),
            new Country("Monaco"),
            new Country("Mongolia"),
            new Country("Montenegro"),
            new Country("Morocco"),
            new Country("Mozambique"),
            new Country("Namibia"),
            new Country("Nauru"),
            new Country("Nepal"),
            new Country("Netherlands"),
            new Country("Netherlands Antilles"),
            new Country("New Zealand"),
            new Country("Nicaragua"),
            new Country("Niger"),
            new Country("Nigeria"),
            new Country("North Korea"),
            new Country("Norway"),
            new Country("Oman"),
            new Country("Pakistan"),
            new Country("Palau"),
            new Country("Palestinian Territories"),
            new Country("Panama"),
            new Country("Papua New Guinea"),
            new Country("Paraguay"),
            new Country("Peru"),
            new Country("Philippines"),
            new Country("Poland"),
            new Country("Portugal"),
            new Country("Qatar"),
            new Country("Romania"),
            new Country("Russia"),
            new Country("Rwanda"),
            new Country("Saint Kitts and Nevis"),
            new Country("Saint Lucia"),
            new Country("Saint Vincent and the Grenadines"),
            new Country("Samoa "),
            new Country("San Marino"),
            new Country("Sao Tome and Principe"),
            new Country("Saudi Arabia"),
            new Country("Senegal"),
            new Country("Serbia"),
            new Country("Seychelles"),
            new Country("Sierra Leone"),
            new Country("Singapore"),
            new Country("Sint Maarten"),
            new Country("Slovakia"),
            new Country("Slovenia"),
            new Country("Solomon Islands"),
            new Country("Somalia"),
            new Country("South Africa"),
            new Country("South Korea"),
            new Country("South Sudan"),
            new Country("Spain "),
            new Country("Sri Lanka"),
            new Country("Sudan"),
            new Country("Suriname"),
            new Country("Swaziland "),
            new Country("Sweden"),
            new Country("Switzerland"),
            new Country("Syria"),
            new Country("Taiwan"),
            new Country("Tajikistan"),
            new Country("Tanzania"),
            new Country("Thailand "),
            new Country("Timor-Leste"),
            new Country("Togo"),
            new Country("Tonga"),
            new Country("Trinidad and Tobago"),
            new Country("Tunisia"),
            new Country("Turkey"),
            new Country("Turkmenistan"),
            new Country("Tuvalu"),
            new Country("Uganda"),
            new Country("Ukraine"),
            new Country("United Arab Emirates"),
            new Country("United Kingdom"),
            new Country("Uruguay"),
            new Country("Uzbekistan"),
            new Country("Vanuatu"),
            new Country("Venezuela"),
            new Country("Vietnam"),
            new Country("Yemen"),
            new Country("Zambia"),
            new Country("Zimbabwe"));
    //</editor-fold>

    public Observable<List<Country>> countries(@Nullable CharSequence filter) {
        if (TextUtils.isEmpty(filter)) {
            return Observable.just(sCountries);
        } else {
            final String filterText = filter.toString().toLowerCase();
            return Observable.from(sCountries)
                    .filter(c -> c.getName().toLowerCase().contains(filterText))
                    .toList();
        }
    }
}