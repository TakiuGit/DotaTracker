package model;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class Main {

    public static void main (String[] args){

        /*
        HeroesList list = new HeroesList();
        list.display();
        */

        /*
        MatchHistory history = new MatchHistory(76561198037671458L);
        System.out.println("NbMatchFound : "+ history.getListMatch().size());
        */

        Items items = new Items();
        System.out.println("Nb items found : " + items.getItems().size());
    }
}
