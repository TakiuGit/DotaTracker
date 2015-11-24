package model;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class Main {

    public static void main (String[] args){
        DotaReader reader = new DotaReader();
        //        reader.download("https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?"+ Constant.STEAM_KEY);
        Heroes h = new Heroes("npc_dota_hero_drow_ranger",6);
        System.out.println(h.getName());


    }
}
