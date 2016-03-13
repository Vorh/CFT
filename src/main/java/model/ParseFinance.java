package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ParseFinance {
    private static String usd;
    private static String uah;
    private static String eur;
    private static String cny;

    //region GetCurrency
    public static String getUsd() {
        return usd;
    }

    public static String getUah() {
        return uah;
    }

    public static String getEur() {
        return eur;
    }

    public static String getCny() {
        return cny;
    }
    //endregion

    private static Document doc;

    public static String parseUSD(){
        try {
            doc = Jsoup.connect("http://www.forexpf.ru/currency_usd.asp").get();
            usd = String.valueOf(doc.body());
            Element element = doc.select("td.cell font b").first();
            usd = String.valueOf(element);
            String  s = usd.replaceAll("<b>|</b>", "");
            usd = s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usd;
    }

    public static String parseUAH(){
        try {
            doc = Jsoup.connect("http://www.banki.ru/products/currency/uah/").get();
            uah = String.valueOf(doc.body());
            String element = doc.select("div.currency-table__rate__num").first().text();
            uah = String.valueOf(element);
            uah = uah.replace(",",".");
            double s = Double.parseDouble(uah);
            s = s / 10;
            uah = String.valueOf(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uah;
    }

    public static String parseCNY(){
        try {
            doc = Jsoup.connect("http://www.banki.ru/products/currency/cny/").get();
            cny = String.valueOf(doc.body());
            String element = doc.select("div.currency-table__rate__num").first().text();
            cny = String.valueOf(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cny;
    }

    public  static String parseEUR(){
        try {
            doc = Jsoup.connect("http://www.forexpf.ru/currency_eur.asp").get();
            eur = String.valueOf(doc.body());
            Element element = doc.select("td.cell font b").first();
            eur = String.valueOf(element);
            String  s = eur.replaceAll("<b>|</b>", "");
            eur = s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eur;
    }
}
